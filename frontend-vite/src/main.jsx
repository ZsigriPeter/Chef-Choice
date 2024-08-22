import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import UserProvider from "./context/UserProvider";


createRoot(document.getElementById('root')).render(
  <StrictMode>
      <UserProvider>
          <App/>
      </UserProvider>
  </StrictMode>,
)