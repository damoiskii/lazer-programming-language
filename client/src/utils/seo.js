/**
 * SEO Utilities for Lazer Programming Language
 * Common functions and configurations for SEO optimization
 */

// Base URL for the application
export const BASE_URL = 'https://lazerlang.vercel.app/'

// Default meta tags
export const DEFAULT_META = {
  title: 'Lazer Programming Language - Interactive Lambda Calculus Playground',
  description: 'Learn and experiment with lambda calculus using Lazer, a modern functional programming language. Interactive playground with AI-powered explanations and real-time code execution.',
  keywords: 'lambda calculus, functional programming, programming language, code playground, computer science, mathematical logic, Lazer',
  author: 'Lazer Language Team',
  image: `${BASE_URL}/hero-img.png`,
  imageAlt: 'Lazer Programming Language Logo',
  type: 'website',
  locale: 'en_US'
}

// Generate canonical URL
export function generateCanonicalUrl(path = '') {
  return `${BASE_URL}${path}`
}

// Generate Open Graph meta tags
export function generateOGMeta(options = {}) {
  const meta = { ...DEFAULT_META, ...options }
  
  return [
    { property: 'og:title', content: meta.title },
    { property: 'og:description', content: meta.description },
    { property: 'og:type', content: meta.type },
    { property: 'og:url', content: generateCanonicalUrl(meta.path || '') },
    { property: 'og:image', content: meta.image },
    { property: 'og:image:alt', content: meta.imageAlt },
    { property: 'og:site_name', content: 'Lazer Programming Language' },
    { property: 'og:locale', content: meta.locale }
  ]
}

// Generate Twitter Card meta tags
export function generateTwitterMeta(options = {}) {
  const meta = { ...DEFAULT_META, ...options }
  
  return [
    { name: 'twitter:card', content: 'summary_large_image' },
    { name: 'twitter:title', content: meta.title },
    { name: 'twitter:description', content: meta.description },
    { name: 'twitter:image', content: meta.image },
    { name: 'twitter:image:alt', content: meta.imageAlt }
  ]
}

// Generate structured data for programming language
export function generateStructuredData(options = {}) {
  const baseData = {
    '@context': 'https://schema.org',
    '@type': 'WebApplication',
    name: 'Lazer Programming Language',
    description: 'An interactive playground for learning and experimenting with lambda calculus and functional programming concepts',
    url: BASE_URL,
    applicationCategory: 'EducationalApplication',
    operatingSystem: 'Any',
    browserRequirements: 'Requires JavaScript',
    offers: {
      '@type': 'Offer',
      price: '0',
      priceCurrency: 'USD'
    },
    author: {
      '@type': 'Organization',
      name: 'Lazer Language Team'
    },
    programmingLanguage: {
      '@type': 'ComputerLanguage',
      name: 'Lazer',
      alternateName: 'Lambda Calculus'
    }
  }
  
  return { ...baseData, ...options }
}

// SEO-friendly route configurations
export const ROUTE_SEO_CONFIG = {
  home: {
    title: 'Lazer Programming Language - Interactive Lambda Calculus Playground',
    description: 'Learn and experiment with lambda calculus using Lazer, a modern functional programming language. Interactive playground with AI-powered explanations and real-time code execution.',
    keywords: 'lambda calculus, functional programming, programming language, code playground, computer science, mathematical logic, Lazer, home',
    path: '/'
  },
  playground: {
    title: 'Lazer Playground - Interactive Lambda Calculus Code Editor',
    description: 'Try Lazer programming language in our interactive playground. Write, execute, and learn lambda calculus expressions with real-time feedback and AI-powered explanations.',
    keywords: 'lambda calculus playground, code editor, functional programming, live coding, programming exercises, computer science education, Lazer language',
    path: '/playground'
  },
  about: {
    title: 'About Lazer - Learn About Lambda Calculus Programming Language',
    description: 'Discover Lazer, an impure lambda calculus programming language designed for education and exploration. Learn about functional programming concepts, syntax, and features.',
    keywords: 'about Lazer, lambda calculus, functional programming language, programming language documentation, computer science, mathematical logic, syntax',
    path: '/about'
  }
}