<script setup>
import { RouterLink } from 'vue-router'
</script>

<template>
  <main class="home">
    <!-- Hero Section -->
    <section class="hero">
      <div class="hero-content">
        <div class="hero-text">
          <h1 class="hero-title">
            <span class="logo-text">Lazer</span>
          </h1>
          <h2 class="hero-subtitle">
            Elevate your impure lambda calculus coding experience
          </h2>
          <p class="hero-description">
            Unlock deeper understanding and enhance productivity effortlessly with our innovative programming language built on mathematical foundations
          </p>
          <div class="hero-actions">
            <RouterLink to="/playground" class="btn btn-primary">
              Goto Playground →
            </RouterLink>
            <a href="#features" class="btn btn-secondary">Learn More</a>
          </div>
        </div>
        <div class="hero-visual">
          <div class="code-preview">
            <div class="code-header">
              <span class="code-title">lazer-example.lz</span>
            </div>
            <div class="code-content">
              <div class="code-line">
                <span class="code-comment">// Identity function</span>
              </div>
              <div class="code-line">
                <span class="code-keyword">#</span><span class="code-variable">x</span><span class="code-operator">.</span><span class="code-variable">x</span>
              </div>
              <div class="code-line">
                <span class="code-comment">// Church numeral for 2</span>
              </div>
              <div class="code-line">
                <span class="code-keyword">#</span><span class="code-variable">f</span><span class="code-operator">.</span><span class="code-keyword">#</span><span class="code-variable">x</span><span class="code-operator">.</span><span class="code-variable">f</span> <span class="code-variable">f</span> <span class="code-variable">x</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Features Section -->
    <section id="features" class="features">
      <div class="container">
        <h2 class="section-title">Why Choose Lazer?</h2>
        <div class="features-grid">
          <div class="feature-card">
            <div class="feature-icon">🧮</div>
            <h3>Mathematical Foundation</h3>
            <p>Built on impure lambda calculus, providing a solid mathematical foundation for functional programming concepts.</p>
          </div>
          <div class="feature-card">
            <div class="feature-icon">🎯</div>
            <h3>Educational Focus</h3>
            <p>Perfect for learning and understanding lambda calculus, variable binding, and function application principles.</p>
          </div>
          <div class="feature-card">
            <div class="feature-icon">⚡</div>
            <h3>Interactive Playground</h3>
            <p>Experiment with lambda expressions in real-time with immediate feedback and AI-powered explanations.</p>
          </div>
          <div class="feature-card">
            <div class="feature-icon">🔒</div>
            <h3>Safe Execution</h3>
            <p>Sandboxed environment ensures your code runs safely without access to system resources.</p>
          </div>
          <div class="feature-card">
            <div class="feature-icon">📚</div>
            <h3>AI Assistant</h3>
            <p>Get detailed explanations of your code with step-by-step breakdowns of expression evaluation.</p>
          </div>
          <div class="feature-card">
            <div class="feature-icon">🎨</div>
            <h3>Clean Syntax</h3>
            <p>Uses # notation for lambda expressions, making it accessible while maintaining mathematical accuracy.</p>
          </div>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="cta">
      <div class="container">
        <h2>Ready to explore lambda calculus?</h2>
        <p>Start experimenting with Lazer expressions in our interactive playground</p>
        <RouterLink to="/playground" class="btn btn-primary btn-large">
          Try the Playground
        </RouterLink>
      </div>
    </section>
  </main>
</template>

<style scoped>
.home {
  min-height: 100vh;
}

/* Hero Section */
.hero {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 4rem 2rem;
  min-height: 80vh;
  display: flex;
  align-items: center;
}

.hero-content {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
}

.logo-text {
  font-size: 3.5rem;
  font-weight: 700;
  margin-bottom: 1rem;
  display: flex;
  align-items: center;
  gap: 1rem;
}

.hero-icon {
  width: 3rem;
  height: 3rem;
}

.hero-subtitle {
  font-size: 2.5rem;
  font-weight: 600;
  margin-bottom: 1.5rem;
  line-height: 1.2;
}

.hero-description {
  font-size: 1.2rem;
  opacity: 0.9;
  margin-bottom: 2rem;
  line-height: 1.6;
}

.hero-actions {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.btn {
  padding: 1rem 2rem;
  border-radius: 8px;
  text-decoration: none;
  font-weight: 600;
  transition: all 0.3s ease;
  border: none;
  cursor: pointer;
  display: inline-block;
}

.btn-primary {
  background: #4f46e5;
  color: white;
}

.btn-primary:hover {
  background: #4338ca;
  transform: translateY(-2px);
}

.btn-secondary {
  background: transparent;
  color: white;
  border: 2px solid white;
}

.btn-secondary:hover {
  background: white;
  color: #667eea;
}

.btn-large {
  padding: 1.5rem 3rem;
  font-size: 1.2rem;
}

/* Code Preview */
.hero-visual {
  display: flex;
  justify-content: center;
}

.code-preview {
  background: #1a1a1a;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
  max-width: 400px;
  width: 100%;
}

.code-header {
  background: #2d2d2d;
  padding: 1rem;
  border-bottom: 1px solid #444;
}

.code-title {
  color: #e2e8f0;
  font-size: 0.9rem;
}

.code-content {
  padding: 1.5rem;
  font-family: 'Monaco', 'Menlo', monospace;
  font-size: 1rem;
  line-height: 1.6;
}

.code-line {
  margin-bottom: 0.5rem;
}

.code-comment {
  color: #6b7280;
}

.code-keyword {
  color: #f59e0b;
  font-weight: bold;
}

.code-variable {
  color: #10b981;
}

.code-operator {
  color: #ef4444;
}

/* Features Section */
.features {
  padding: 5rem 2rem;
  background: #f8fafc;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
}

.section-title {
  text-align: center;
  font-size: 2.5rem;
  margin-bottom: 3rem;
  color: #1f2937;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
}

.feature-card {
  background: white;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
  text-align: center;
  transition: transform 0.3s ease;
}

.feature-card:hover {
  transform: translateY(-5px);
}

.feature-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.feature-card h3 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #1f2937;
}

.feature-card p {
  color: #6b7280;
  line-height: 1.6;
}

/* CTA Section */
.cta {
  background: #1f2937;
  color: white;
  padding: 4rem 2rem;
  text-align: center;
}

.cta h2 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.cta p {
  font-size: 1.2rem;
  opacity: 0.8;
  margin-bottom: 2rem;
}

/* Responsive Design */
@media (max-width: 768px) {
  .hero-content {
    grid-template-columns: 1fr;
    gap: 2rem;
    text-align: center;
  }
  
  .logo-text {
    font-size: 2.5rem;
  }
  
  .hero-subtitle {
    font-size: 2rem;
  }
  
  .features-grid {
    grid-template-columns: 1fr;
  }
  
  .hero-actions {
    justify-content: center;
  }
}
</style>
