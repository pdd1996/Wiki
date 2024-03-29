import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import AdminEbook from '../views/admin/admin-ebook.vue';
import AdminCategory from '../views/admin/admin-category.vue';
import AdminDoc from '../views/admin/admin-doc.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/admin/ebook',
    name: 'AdminEbook',
    component: AdminEbook
  },
  {
    path: '/admin/category',
    name: 'AdminCategory',
    component: AdminCategory
  },
  {
    path: '/admin/doc',
    name: 'AdminDoc',
    component: AdminDoc
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
