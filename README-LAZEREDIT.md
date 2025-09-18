# LazerEdit - Impure Lambda Calculus Programming Language

A modern web application for learning and experimenting with impure lambda calculus expressions, featuring an interactive playground with AI-powered explanations.

## 🔥 Features

- **Interactive Landing Page**: Modern, engaging design showcasing the Lazer programming language
- **Code Playground**: Real-time lambda calculus expression evaluation with syntax highlighting
- **AI Explanations**: Detailed explanations of code execution and lambda calculus concepts
- **Safe Execution**: Sandboxed environment that only executes valid Lazer syntax
- **Educational Focus**: Built specifically for learning functional programming concepts

## 🏗️ Architecture

### Frontend (Vue.js)
- **Home Page**: Landing page with hero section, features, and call-to-action
- **Playground**: Interactive code editor with syntax highlighting and execution
- **About**: Comprehensive information about the Lazer programming language
- **Responsive Design**: Mobile-friendly interface with modern styling

### Backend (Spring Boot)
- **Playground API**: REST endpoint for code execution and AI explanations
- **ANTLR Integration**: Uses existing ANTLR4 parser for lambda calculus
- **Safety Features**: Implements safeguard guidelines from safeguard.md
- **AI Integration**: Provides fallback explanations when AI service is unavailable

## 🚀 Getting Started

### Prerequisites
- Node.js 20+ (for frontend)
- Java 17+ (for backend)
- Maven (for backend build)

### Running the Application

1. **Start the Backend Server**:
   ```bash
   cd server
   ./mvnw spring-boot:run
   ```
   The server will start on `http://localhost:8080`

2. **Start the Frontend Development Server**:
   ```bash
   cd client
   npm install
   npm run dev
   ```
   The frontend will start on `http://localhost:5173`

3. **Access the Application**:
   Open your browser to `http://localhost:5173`

## 🎯 Language Syntax

Lazer uses `#` notation instead of `λ` for lambda expressions:

- **Identity Function**: `#x.x`
- **Constant Function**: `#x.#y.x`
- **Church Numeral 0**: `#f.#x.x`
- **Church Numeral 1**: `#f.#x.f x`
- **Church Numeral 2**: `#f.#x.f (f x)`

## 🔒 Safety Features

The application implements several safety measures based on the safeguard.md guidelines:

- Only valid Lazer syntax is accepted
- No system access or external resource manipulation
- Automatic conversion of `λ` to `#` notation
- Comprehensive input validation
- Sandboxed execution environment

## 🎨 Design Features

- **Modern UI**: Clean, professional design with intuitive navigation
- **Syntax Highlighting**: Real-time highlighting for lambda expressions
- **Responsive Layout**: Works seamlessly on desktop and mobile devices
- **Interactive Examples**: Pre-built examples to help users get started
- **Error Handling**: Clear error messages and feedback

## 📚 Educational Value

The application is designed to help users understand:

- Lambda calculus fundamentals
- Function composition and currying
- Church encoding of numbers and booleans
- Variable binding and scope
- Expression evaluation and reduction

## 🛠️ Technical Implementation

### Frontend Technologies
- Vue.js 3 with Composition API
- Vue Router for navigation
- Modern CSS with Flexbox/Grid
- Responsive design principles

### Backend Technologies
- Spring Boot 3
- ANTLR4 for parsing
- RESTful API design
- Cross-origin resource sharing (CORS)

### Key Files Added/Modified

**Frontend:**
- `src/views/HomeView.vue` - Landing page
- `src/views/PlaygroundView.vue` - Interactive playground
- `src/views/AboutView.vue` - About page
- `src/App.vue` - Main application layout
- `src/router/index.js` - Navigation routing

**Backend:**
- `controller/PlaygroundController.java` - API endpoint
- `dto/PlaygroundExecutionRequest.java` - Request DTO
- `dto/PlaygroundExecutionResponse.java` - Response DTO

## 🌟 Next Steps

The application is now ready for use! Users can:

1. Visit the landing page to learn about Lazer
2. Navigate to the playground to try lambda expressions
3. Get AI-powered explanations of their code
4. Explore the about page for detailed information

The backend integrates with your existing ANTLR4 parser and can be extended with additional AI services as needed.