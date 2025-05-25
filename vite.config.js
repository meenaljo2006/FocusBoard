import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  // base: process.env.NODE_ENV === 'production' ? '/FocusBoard/' : '/'
  base:process.env.VITE_BASE_PATH || "/FocusBoard"
})
