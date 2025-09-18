// API configuration for different environments
const API_BASE_URL = typeof __API_URL__ !== 'undefined' ? __API_URL__ : 'http://localhost:8080'

export const apiConfig = {
  baseUrl: API_BASE_URL,
  endpoints: {
    playground: {
      execute: `${API_BASE_URL}/api/playground/execute`
    },
    editor: {
      runCode: `${API_BASE_URL}/api/v1/run-code`,
      aiExplanation: `${API_BASE_URL}/api/v1/ai-explanation`,
      testAi: `${API_BASE_URL}/api/v1/test-ai`
    }
  }
}

export default apiConfig