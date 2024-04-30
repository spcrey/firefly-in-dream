import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import { createRouter, createWebHistory } from 'vue-router';
import 'element-plus/dist/index.css'
import App from './App.vue'
import Home from './views/Home.vue';
import Login from './views/Login.vue';
import Test from './views/Test.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
      { path: '/', component: Home },
      { path: '/test', component: Test },
      { path: '/login', component: Login }
      // 其他路由配置
    ]
  });

const app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.mount('#app')
app.provide('message', 'hello')
