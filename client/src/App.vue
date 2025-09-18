<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div id="app">
    <header class="header">
      <nav class="nav">
        <div class="nav-brand">
          <router-link to="/" class="logo">
            <img src="/favicon.png" alt="Lazer" class="logo-icon"> Lazer
          </router-link>
        </div>
        <div class="nav-links">
          <RouterLink to="/" class="nav-link">Home</RouterLink>
          <RouterLink to="/about" class="nav-link">About</RouterLink>
          <RouterLink to="/playground" class="nav-link playground-link">Playground</RouterLink>
        </div>
      </nav>
    </header>

    <main>
      <RouterView />
    </main>

    <footer class="footer">
      <div class="footer-content">
        <div class="footer-section">
          <h3><img src="/favicon.png" alt="Lazer" class="footer-icon"> Lazer</h3>
          <p>Exploring impure lambda calculus through interactive programming</p>
        </div>
        <div class="footer-section">
          <h4>Quick Links</h4>
          <RouterLink to="/" class="footer-link">Home</RouterLink>
          <RouterLink to="/playground" class="footer-link">Playground</RouterLink>
          <RouterLink to="/about" class="footer-link">About</RouterLink>
        </div>
        <div class="footer-section">
          <h4>Features</h4>
          <span class="footer-text">Interactive Code Editor</span>
          <span class="footer-text">AI-Powered Explanations</span>
          <span class="footer-text">Safe Execution Environment</span>
        </div>
      </div>
      <div class="footer-bottom">
        <p>&copy; 2025 Lazer Programming Language. Built for educational purposes.</p>
      </div>
    </footer>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  width: 100%;
  margin: 0;
  padding: 0;
  background-color: white;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
  line-height: 1.6;
  color: #333;
}

#app {
  min-height: 100vh;
  width: 100%;
  display: flex;
  flex-direction: column;
  margin: 0;
  padding: 0;
}

main {
  flex: 1;
  width: 100%;
  margin: 0;
  padding: 0;
}

.header {
  background: white;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  position: sticky;
  top: 0;
  z-index: 100;
}

.nav {
  max-width: 1200px;
  margin: 0 auto;
  padding: 1rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.brand-link {
  font-size: 1.5rem;
  font-weight: 700;
  text-decoration: none;
  color: #4f46e5;
}

.nav-links {
  display: flex;
  gap: 2rem;
  align-items: center;
}

.nav-link {
  text-decoration: none;
  color: #6b7280;
  font-weight: 500;
  transition: color 0.3s ease;
  padding: 0.5rem 1rem;
  border-radius: 6px;
}

.nav-link:hover {
  color: #4f46e5;
  background-color: rgba(79, 70, 229, 0.1);
}

.nav-link.router-link-active {
  color: #4f46e5;
  font-weight: 600;
}

.playground-link {
  background: #4f46e5;
  color: white !important;
  font-weight: 600;
}

.playground-link:hover {
  background: #4338ca;
  color: white !important;
}

.playground-link.router-link-active {
  background: #4338ca;
  color: white !important;
}

/* Footer */
.footer {
  background: #1f2937;
  color: white;
  margin-top: auto;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 3rem 2rem 2rem;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
}

.footer-section h3 {
  color: #4f46e5;
  margin-bottom: 1rem;
  font-size: 1.5rem;
}

.footer-section h4 {
  color: white;
  margin-bottom: 1rem;
  font-size: 1.1rem;
}

.footer-section p {
  color: #9ca3af;
  line-height: 1.6;
}

.footer-link {
  display: block;
  color: #9ca3af;
  text-decoration: none;
  margin-bottom: 0.5rem;
  padding: 0.5rem;
  border-radius: 6px;
  transition: all 0.3s ease;
}

.footer-link:hover {
  color: #4f46e5;
  background-color: rgba(79, 70, 229, 0.1);
}

.footer-text {
  display: block;
  color: #9ca3af;
  margin-bottom: 0.5rem;
}

.footer-bottom {
  border-top: 1px solid #374151;
  padding: 1.5rem 2rem;
  text-align: center;
  max-width: 1200px;
  margin: 0 auto;
}

.footer-bottom p {
  color: #9ca3af;
  margin: 0;
}

/* Logo and favicon styles */
.logo {
  font-size: 1.5rem;
  font-weight: 700;
  text-decoration: none;
  color: #4f46e5;
  display: flex;
  align-items: center;
  gap: 0.5rem;
  background: none;
  background-color: transparent;
}

.logo:hover {
  background: none !important;
  background-color: transparent !important;
  color: #4338ca;
}

.logo-icon {
  width: 24px;
  height: 24px;
  background: none;
  background-color: transparent;
}

.footer-icon {
  width: 20px;
  height: 20px;
  vertical-align: middle;
  margin-right: 0.5rem;
}

@media (max-width: 768px) {
  .nav {
    padding: 1rem;
    flex-direction: column;
    gap: 1rem;
  }

  .nav-links {
    gap: 1rem;
  }
}
</style>