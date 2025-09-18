import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  define: {
    __API_URL__: JSON.stringify(process.env.VITE_API_URL || 'http://localhost:8080')
  },
  server: {
    port: 3000,
    // host: true,
    // strictPort: true,
    // watch: {
    //   usePolling: true,
    // },
    // cors: true,
    // proxy: {
    //   '/api': 'http://localhost:8000/api/v1/',
    // },

  },
  build: {
    // Generate clean URLs for better SEO
    rollupOptions: {
      output: {
        manualChunks: {
          vendor: ['vue', 'vue-router']
        }
      }
    },
    // Enable source maps for better debugging
    sourcemap: false,
    // Optimize bundle size
    cssCodeSplit: true,
    // Generate clean file names
    assetsDir: 'assets',
    // Use esbuild for minification (faster and more reliable)
    minify: 'esbuild'
  },
  // SEO-friendly configuration
  base: '/',
  // Ensure proper MIME types
  assetsInclude: ['**/*.xml', '**/*.txt'],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
})
