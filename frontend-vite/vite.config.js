import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'

const backendHost = process.env.BACKEND_HOST ?? "localhost"

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [react()],
    server: {
        proxy: {
            '/api': {
                target: `http://${backendHost}:8080/`,
                changeOrigin: true,
            }
        },
        host: "0.0.0.0"
    },
})
