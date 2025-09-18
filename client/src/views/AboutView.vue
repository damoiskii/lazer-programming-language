<template>
  <div class="about">
    <div class="about-container">
      <div class="about-header">
        <h1>About Lazer</h1>
        <p class="about-subtitle">
          Exploring the beauty of impure lambda calculus through interactive programming
        </p>
      </div>

      <div class="about-content">
        <section class="about-section">
          <h2><img src="/favicon.png" alt="Lazer" class="hero-icon"> What is Lazer?</h2>
          <p>
            Lazer is a programming language built on the foundations of <strong>impure lambda calculus</strong>. 
            It provides a safe, educational environment for exploring functional programming concepts 
            while maintaining mathematical rigor and computational expressiveness.
          </p>
        </section>

        <section class="about-section">
          <h2>📚 Educational Focus</h2>
          <p>
            Our primary goal is to make lambda calculus accessible and understandable. Whether you're 
            a student learning functional programming concepts or a developer exploring the mathematical 
            foundations of computation, Lazer provides:
          </p>
          <ul>
            <li>Interactive code execution with step-by-step explanations</li>
            <li>AI-powered analysis of lambda expressions</li>
            <li>Real-time feedback on syntax and semantics</li>
            <li>Safe sandboxed environment for experimentation</li>
          </ul>
        </section>

        <section class="about-section">
          <h2>🔧 Language Features</h2>
          <div class="feature-grid">
            <div class="feature-item">
              <h3># Notation</h3>
              <p>Uses # instead of λ for better accessibility and typing convenience</p>
            </div>
            <div class="feature-item">
              <h3>Church Encoding</h3>
              <p>Full support for Church numerals and boolean operations</p>
            </div>
            <div class="feature-item">
              <h3>Function Composition</h3>
              <p>Natural function composition and currying support</p>
            </div>
            <div class="feature-item">
              <h3>Safe Evaluation</h3>
              <p>Controlled execution environment with resource limits</p>
            </div>
          </div>
        </section>

        <section class="about-section">
          <h2>🎯 Core Principles</h2>
          <div class="principles">
            <div class="principle">
              <h3>Safety First</h3>
              <p>
                All code execution is sandboxed and restricted to valid Lazer syntax. 
                No system access or external resource manipulation is permitted.
              </p>
            </div>
            <div class="principle">
              <h3>Educational Value</h3>
              <p>
                Every feature is designed to enhance understanding of functional programming 
                and lambda calculus concepts through hands-on experimentation.
              </p>
            </div>
            <div class="principle">
              <h3>Mathematical Foundation</h3>
              <p>
                Built on solid mathematical principles, ensuring that concepts learned 
                here translate directly to theoretical computer science.
              </p>
            </div>
          </div>
        </section>

        <section class="about-section">
          <h2>🚀 Getting Started</h2>
          <p>
            Ready to dive in? Head over to our <RouterLink to="/playground" class="link">Playground</RouterLink> 
            and start experimenting with lambda expressions. Try the examples provided, or create your own 
            expressions to see how they evaluate.
          </p>
          <p>
            Each execution comes with detailed AI explanations to help you understand 
            what's happening at each step of the evaluation process.
          </p>
        </section>

        <section class="about-section">
          <h2>📖 Example Expressions</h2>
          <div class="examples">
            <div class="example">
              <code>#x.x</code>
              <span>Identity function</span>
            </div>
            <div class="example">
              <code>#x.#y.x</code>
              <span>Constant function</span>
            </div>
            <div class="example">
              <code>#f.#x.f x</code>
              <span>Church numeral 1</span>
            </div>
            <div class="example">
              <code>#f.#x.f (f x)</code>
              <span>Church numeral 2</span>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router'
</script>

<style scoped>
.hero-icon {
  width: 1.5rem;
  height: 1.5rem;
}

.about {
  min-height: 100vh;
  background: #f8fafc;
  padding: 2rem;
}

.about-container {
  max-width: 1000px;
  margin: 0 auto;
}

.about-header {
  text-align: center;
  margin-bottom: 4rem;
}

.about-header h1 {
  font-size: 3rem;
  color: #1f2937;
  margin-bottom: 1rem;
}

.about-subtitle {
  font-size: 1.2rem;
  color: #6b7280;
  max-width: 600px;
  margin: 0 auto;
}

.about-content {
  display: flex;
  flex-direction: column;
  gap: 3rem;
}

.about-section {
  background: white;
  padding: 2.5rem;
  border-radius: 12px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
}

.about-section h2 {
  color: #1f2937;
  margin-bottom: 1.5rem;
  font-size: 1.8rem;
}

.about-section h3 {
  color: #374151;
  margin-bottom: 0.5rem;
  font-size: 1.2rem;
}

.about-section p {
  color: #6b7280;
  line-height: 1.6;
  margin-bottom: 1rem;
}

.about-section ul {
  color: #6b7280;
  line-height: 1.6;
  margin-left: 1.5rem;
}

.about-section li {
  margin-bottom: 0.5rem;
}

.feature-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1.5rem;
  margin-top: 1.5rem;
}

.feature-item {
  background: #f8fafc;
  padding: 1.5rem;
  border-radius: 8px;
  border-left: 4px solid #4f46e5;
}

.feature-item h3 {
  color: #4f46e5;
  margin-bottom: 0.5rem;
}

.feature-item p {
  margin: 0;
  font-size: 0.9rem;
}

.principles {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
  margin-top: 1.5rem;
}

.principle {
  padding: 1.5rem;
  border: 1px solid #e5e7eb;
  border-radius: 8px;
}

.principle h3 {
  color: #4f46e5;
  margin-bottom: 1rem;
}

.examples {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1rem;
  margin-top: 1.5rem;
}

.example {
  background: #1f2937;
  padding: 1rem;
  border-radius: 8px;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.example code {
  color: #10b981;
  font-family: 'Monaco', 'Menlo', monospace;
  font-size: 1.1rem;
}

.example span {
  color: #9ca3af;
  font-size: 0.9rem;
}

.link {
  color: #4f46e5;
  text-decoration: none;
  font-weight: 600;
}

.link:hover {
  text-decoration: underline;
}

@media (max-width: 768px) {
  .about {
    padding: 1rem;
  }
  
  .about-header h1 {
    font-size: 2.5rem;
  }
  
  .about-section {
    padding: 1.5rem;
  }
  
  .feature-grid,
  .principles,
  .examples {
    grid-template-columns: 1fr;
  }
}
</style>
