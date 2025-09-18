<script setup>
import { ref, reactive, computed, nextTick } from 'vue'
import { apiConfig } from '@/config/api.js'

const code = ref('#x.x')
const result = ref('')
const steps = ref('')
const explanation = ref('')
const isExecuting = ref(false)
const error = ref('')
const codeInput = ref(null)
const syntaxHighlighting = ref(null)

const examples = [
    {
        name: 'Identity Function',
        code: '#x.x',
        description: 'The simplest lambda expression - returns its input unchanged'
    },
    {
        name: 'Constant Function',
        code: '#x.#y.x',
        description: 'Returns the first argument, ignoring the second'
    },
    {
        name: 'Church Numeral 0',
        code: '#f.#x.x',
        description: 'Church encoding of the number zero'
    },
    {
        name: 'Church Numeral 1',
        code: '#f.#x.f x',
        description: 'Church encoding of the number one'
    },
    {
        name: 'Church Numeral 2',
        code: '#f.#x.f (f x)',
        description: 'Church encoding of the number two'
    }
]

// Syntax highlighting
const highlightedCode = computed(() => {
    if (!code.value) return ''

    let highlighted = code.value

    // Escape HTML
    highlighted = highlighted
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')

    // Highlight lambda symbols (#)
    highlighted = highlighted.replace(/#/g, '<span class="token-lambda">#</span>')

    // Highlight variables (single letters after # or spaces)
    highlighted = highlighted.replace(/\b([a-zA-Z])\b(?!\s*\.)/g, '<span class="token-variable">$1</span>')

    // Highlight dot operators
    highlighted = highlighted.replace(/\./g, '<span class="token-operator">.</span>')

    // Highlight parentheses
    highlighted = highlighted.replace(/[()]/g, '<span class="token-paren">$&</span>')

    // Highlight comments (if any)
    highlighted = highlighted.replace(/\/\/.*$/gm, '<span class="token-comment">$&</span>')

    // Add line breaks
    highlighted = highlighted.replace(/\n/g, '<br>')

    return highlighted
})

const updateHighlighting = () => {
    nextTick(() => {
        if (syntaxHighlighting.value) {
            syntaxHighlighting.value.scrollTop = codeInput.value.scrollTop
            syntaxHighlighting.value.scrollLeft = codeInput.value.scrollLeft
        }
    })
}

const syncScroll = () => {
    if (syntaxHighlighting.value && codeInput.value) {
        syntaxHighlighting.value.scrollTop = codeInput.value.scrollTop
        syntaxHighlighting.value.scrollLeft = codeInput.value.scrollLeft
    }
}

const loadExample = (example) => {
    code.value = example.code
    result.value = ''
    steps.value = ''
    explanation.value = ''
    error.value = ''
    updateHighlighting()
}

const executeCode = async () => {
    if (!code.value.trim()) {
        error.value = 'Please enter some code to execute'
        return
    }

    isExecuting.value = true
    error.value = ''
    result.value = ''
    steps.value = ''
    explanation.value = ''

    try {
        const response = await fetch(apiConfig.endpoints.playground.execute, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                code: code.value.trim()
            })
        })

        const data = await response.json()

        if (data.success) {
            result.value = data.result
            steps.value = data.steps
            explanation.value = data.explanation
        } else {
            error.value = data.error || 'An error occurred while executing the code'
        }
    } catch (err) {
        error.value = 'Failed to connect to the server. Please make sure the backend is running.'
    } finally {
        isExecuting.value = false
    }
}

const clearAll = () => {
    code.value = ''
    result.value = ''
    steps.value = ''
    explanation.value = ''
    error.value = ''
    updateHighlighting()
}

// Format steps similar to the original jQuery implementation
const formatSteps = (stepsText) => {
    if (!stepsText) return ''
    
    let formatted = stepsText
    
    // Handle newlines first
    formatted = formatted.replace(/\n/g, '<br>')
    
    // Handle arrows with indentation using &nbsp; for spacing
    formatted = formatted.replace(/→/g, '<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;→')
    
    // Handle equals with proper spacing
    formatted = formatted.replace(/=/g, '<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = ')
    
    // Handle question marks with small spacing
    formatted = formatted.replace(/\?/g, '&nbsp;&nbsp; ')
    
    // Handle section breaks with tilde (but not at the beginning)
    formatted = formatted.replace(/(?<!^)~/g, '<br><br>~')
    
    // Look for "Results" section and highlight final results
    formatted = formatted.replace(
        />>>>> Results <<<<<(.*?)$/s,
        '>>>>> Results <<<<<$1'
    )
    
    // Highlight any final results that look like lambda expressions
    formatted = formatted.replace(
        /(#[a-zA-Z]+\.[a-zA-Z#.\s()]+)/g,
        '<strong style="color: #fbbf24;">$1</strong>'
    )
    
    return formatted
}

// Format explanation to preserve proper spacing and line breaks
const formatExplanation = (explanationText) => {
    if (!explanationText) return ''
    
    let formatted = explanationText
    
    // Escape HTML characters first to prevent XSS
    formatted = formatted
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
    
    // Convert line breaks to HTML breaks
    formatted = formatted.replace(/\n/g, '<br>')
    
    // Add some spacing around numbered lists
    formatted = formatted.replace(/(\d+\.\s)/g, '<br>$1')
    
    // Add spacing around bullet points if present
    formatted = formatted.replace(/(-\s)/g, '<br>&nbsp;&nbsp;$1')
    
    // Highlight lambda expressions in explanations
    formatted = formatted.replace(
        /(#[a-zA-Z]+\.[a-zA-Z#.\s()]+)/g,
        '<code style="background-color: rgba(251, 191, 36, 0.1); padding: 2px 4px; border-radius: 3px; color: #fbbf24;">$1</code>'
    )
    
    // Highlight quoted expressions
    formatted = formatted.replace(
        /`([^`]+)`/g,
        '<code style="background-color: rgba(251, 191, 36, 0.1); padding: 2px 4px; border-radius: 3px; color: #fbbf24;">$1</code>'
    )
    
    // Clean up any extra breaks at the beginning
    formatted = formatted.replace(/^(<br>)+/, '')
    
    return formatted
}
</script>

<template>
    <div class="playground">
        <div class="playground-header">
            <h1><img src="/favicon.png" alt="Lazer" class="playground-icon"> Lazer Playground</h1>
            <p>Experiment with impure lambda calculus expressions and get AI-powered explanations</p>
        </div>

        <div class="playground-content">
            <!-- Examples Panel -->
            <div class="examples-panel">
                <h3>📚 Examples</h3>
                <div class="examples-list">
                    <div v-for="example in examples" :key="example.name" class="example-item"
                        @click="loadExample(example)">
                        <h4>{{ example.name }}</h4>
                        <code>{{ example.code }}</code>
                        <p>{{ example.description }}</p>
                    </div>
                </div>
            </div>

            <!-- Main Playground -->
            <div class="main-playground">
                <!-- Code Editor -->
                <!-- Code Editor -->
                <div class="editor-section">
                    <div class="section-header">
                        <h3>💻 Code Editor</h3>
                        <div class="editor-actions">
                            <button @click="clearAll" class="btn btn-secondary btn-small">Clear</button>
                        </div>
                    </div>
                    <div class="code-editor">
                        <div class="editor-container">
                            <textarea v-model="code" placeholder="Enter your Lazer code here... e.g., #x.x"
                                class="code-input" rows="8" spellcheck="false" @input="updateHighlighting"
                                @scroll="syncScroll" ref="codeInput"></textarea>
                            <div class="syntax-highlighting" ref="syntaxHighlighting" v-html="highlightedCode"></div>
                        </div>
                    </div>
                    <div class="execution-controls">
                        <button @click="executeCode" :disabled="isExecuting" class="btn btn-primary">
                            <span v-if="isExecuting">⏳ Executing...</span>
                            <span v-else>▶️ Execute Code</span>
                        </button>
                    </div>
                </div> <!-- Results Section -->
                <div class="results-section">
                    <div class="section-header">
                        <h3>📊 Execution Results</h3>
                    </div>

                    <!-- Error Display -->
                    <div v-if="error" class="error-display">
                        <h4>❌ Error</h4>
                        <p>{{ error }}</p>
                    </div>

                    <!-- Result Display -->
                    <div v-if="result && !error" class="result-display">
                        <h4>✅ Result</h4>
                        <div class="result-content">
                            <code>{{ result }}</code>
                        </div>
                    </div>

                    <!-- Explanation Display -->
                    <div v-if="explanation && !error" class="explanation-display">
                        <h4>🤖 AI Explanation</h4>
                        <div class="explanation-content">
                            <div v-html="formatExplanation(explanation)"></div>
                        </div>
                    </div>

                    <!-- Steps Display -->
                    <div v-if="steps && !error" class="steps-display">
                        <h4>📋 Execution Steps</h4>
                        <div class="steps-content">
                            <div v-html="formatSteps(steps)"></div>
                        </div>
                    </div>

                    <!-- Empty State -->
                    <div v-if="!result && !error && !isExecuting" class="empty-state">
                        <p>👆 Enter some Lazer code above and click "Execute Code" to see results</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Help Section -->
        <div class="help-section">
            <h3>📖 Quick Reference</h3>
            <div class="help-content">
                <div class="help-item">
                    <strong>Lambda Notation:</strong> Use <code>#</code> instead of <code>λ</code>
                </div>
                <div class="help-item">
                    <strong>Function Definition:</strong> <code>#x.body</code> defines a function with parameter x
                </div>
                <div class="help-item">
                    <strong>Function Application:</strong> <code>f x</code> applies function f to argument x
                </div>
                <div class="help-item">
                    <strong>Multiple Parameters:</strong> <code>#x.#y.body</code> or curried functions
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.playground {
    min-height: 100vh;
    background: #f8fafc;
    padding: 2rem;
}

.playground-header {
    text-align: center;
    margin-bottom: 3rem;
}

.playground-header h1 {
    font-size: 2.5rem;
    margin-bottom: 0.5rem;
    color: #1f2937;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.5rem;
}

.playground-icon {
    width: 2rem;
    height: 2rem;
}

.playground-header p {
    font-size: 1.1rem;
    color: #6b7280;
}

.playground-content {
    max-width: 1400px;
    margin: 0 auto;
    display: grid;
    grid-template-columns: 300px 1fr;
    gap: 2rem;
}

/* Examples Panel */
.examples-panel {
    background: white;
    border-radius: 12px;
    padding: 1.5rem;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
    height: fit-content;
}

.examples-panel h3 {
    margin-bottom: 1rem;
    color: #1f2937;
}

.examples-list {
    display: flex;
    flex-direction: column;
    gap: 1rem;
}

.example-item {
    padding: 1rem;
    border: 1px solid #e5e7eb;
    border-radius: 8px;
    cursor: pointer;
    transition: all 0.3s ease;
}

.example-item:hover {
    border-color: #4f46e5;
    background: #f8fafc;
}

.example-item h4 {
    font-size: 0.9rem;
    margin-bottom: 0.5rem;
    color: #1f2937;
}

.example-item code {
    display: block;
    background: #1f2937;
    color: #10b981;
    padding: 0.5rem;
    border-radius: 4px;
    font-family: 'Monaco', 'Menlo', monospace;
    margin-bottom: 0.5rem;
    font-size: 0.85rem;
}

.example-item p {
    font-size: 0.8rem;
    color: #6b7280;
    line-height: 1.4;
}

/* Main Playground */
.main-playground {
    display: flex;
    flex-direction: column;
    gap: 2rem;
}

.section-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 1rem;
}

.section-header h3 {
    color: #1f2937;
    margin: 0;
}

.editor-actions {
    display: flex;
    gap: 0.5rem;
}

.editor-section,
.results-section {
    background: white;
    border-radius: 12px;
    padding: 1.5rem;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
}

/* Code Editor */
.code-editor {
    margin-bottom: 1rem;
}

.editor-container {
    position: relative;
    border-radius: 8px;
    overflow: hidden;
    background: #1f2937;
}

.code-input,
.syntax-highlighting {
    width: 100%;
    min-height: 200px;
    padding: 1rem;
    font-family: 'Monaco', 'Menlo', 'Consolas', monospace;
    font-size: 1rem;
    line-height: 1.5;
    border: none;
    outline: none;
    resize: vertical;
    overflow: auto;
    white-space: pre;
    word-wrap: break-word;
}

.code-input {
    position: relative;
    z-index: 2;
    background: transparent;
    color: transparent;
    caret-color: #10b981;
}

.syntax-highlighting {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 1;
    background: #1f2937;
    color: #e5e7eb;
    pointer-events: none;
    overflow: hidden;
}

.code-input:focus {
    box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
}

.code-input::placeholder {
    color: #9ca3af;
}

/* Syntax highlighting tokens */
.token-lambda {
    color: #f59e0b;
    font-weight: bold;
}

.token-variable {
    color: #10b981;
}

.token-operator {
    color: #ef4444;
    font-weight: bold;
}

.token-paren {
    color: #8b5cf6;
    font-weight: bold;
}

.token-comment {
    color: #6b7280;
    font-style: italic;
}

.execution-controls {
    display: flex;
    justify-content: center;
}

/* Buttons */
.btn {
    padding: 0.75rem 1.5rem;
    border: none;
    border-radius: 8px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
    text-decoration: none;
    display: inline-block;
}

.btn-primary {
    background: #4f46e5;
    color: white;
}

.btn-primary:hover:not(:disabled) {
    background: #4338ca;
}

.btn-primary:disabled {
    background: #9ca3af;
    cursor: not-allowed;
}

.btn-secondary {
    background: #6b7280;
    color: white;
}

.btn-secondary:hover {
    background: #4b5563;
}

.btn-small {
    padding: 0.5rem 1rem;
    font-size: 0.9rem;
}

/* Results */
.error-display,
.result-display,
.steps-display,
.explanation-display {
    margin-bottom: 1.5rem;
    padding: 1rem;
    border-radius: 8px;
}

.error-display {
    background: #fef2f2;
    border: 1px solid #fecaca;
}

.error-display h4 {
    color: #dc2626;
    margin-bottom: 0.5rem;
}

.error-display p {
    color: #991b1b;
    margin: 0;
}

.result-display {
    background: #f0fdf4;
    border: 1px solid #bbf7d0;
}

.result-display h4 {
    color: #16a34a;
    margin-bottom: 0.5rem;
}

.result-content code {
    background: #1f2937;
    color: #10b981;
    padding: 1rem;
    border-radius: 6px;
    display: block;
    font-family: 'Monaco', 'Menlo', monospace;
    font-size: 1.1rem;
}

.steps-display {
    background: #fef3c7;
    border: 1px solid #f59e0b;
}

.steps-display h4 {
    color: #d97706;
    margin-bottom: 0.5rem;
}

.steps-content pre {
    background: #1f2937;
    color: #e5e7eb;
    padding: 1rem;
    border-radius: 6px;
    font-family: 'Monaco', 'Menlo', monospace;
    font-size: 0.9rem;
    line-height: 1.4;
    white-space: pre-wrap;
    word-wrap: break-word;
    margin: 0;
    overflow-x: auto;
}

.steps-content div {
    background: #1f2937;
    color: #e5e7eb;
    padding: 1rem;
    border-radius: 6px;
    font-family: 'Monaco', 'Menlo', monospace;
    font-size: 0.9rem;
    line-height: 1.6;
    margin: 0;
    overflow-x: auto;
}

/* Tab spacing classes for step formatting */
.tab-space {
    margin-left: 2rem;
}

.tab-space-sml {
    margin-left: 0.5rem;
}

/* Special formatting for step symbols */
.steps-content div strong {
    color: #fbbf24;
    font-size: 1.1em;
}

.explanation-display {
    background: #eff6ff;
    border: 1px solid #bfdbfe;
}

.explanation-display h4 {
    color: #2563eb;
    margin-bottom: 0.5rem;
}

.explanation-content p {
    color: #1e40af;
    line-height: 1.6;
    margin: 0;
}

.empty-state {
    text-align: center;
    padding: 3rem 1rem;
    color: #6b7280;
}

/* Help Section */
.help-section {
    max-width: 1400px;
    margin: 3rem auto 0;
    background: white;
    border-radius: 12px;
    padding: 1.5rem;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
}

.help-section h3 {
    margin-bottom: 1rem;
    color: #1f2937;
}

.help-content {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 1rem;
}

.help-item {
    padding: 1rem;
    background: #f8fafc;
    border-radius: 8px;
    border-left: 4px solid #4f46e5;
}

.help-item strong {
    color: #1f2937;
}

.help-item code {
    background: #e5e7eb;
    padding: 0.2rem 0.4rem;
    border-radius: 4px;
    font-family: 'Monaco', 'Menlo', monospace;
}

/* Responsive Design */
@media (max-width: 1024px) {
    .playground-content {
        grid-template-columns: 1fr;
    }

    .examples-panel {
        order: 2;
    }

    .main-playground {
        order: 1;
    }
}

@media (max-width: 768px) {
    .playground {
        padding: 1rem;
    }

    .playground-header h1 {
        font-size: 2rem;
    }

    .help-content {
        grid-template-columns: 1fr;
    }
}
</style>