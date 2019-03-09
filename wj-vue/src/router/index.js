import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import AppIndex from '@/components/home/AppIndex'
import JotterIndex from '@/components/jotter/JotterIndex'
import Editor from '@/components/jotter/Editor'
import LibraryIndex from '@/components/library/LibraryIndex'
import Login from '@/components/Login'
import Home from '@/components/Home'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      redirect: '/login',
      component: Login
    },
    {
      // 表面是appindex，实际上是先访问了home然后跳转的。home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: 'appindex',
      children: [
        {
          path: '/appindex',
          name: 'AppIndex',
          component: AppIndex
        },
        {
          path: '/jotterindex',
          name: 'JotterIndex',
          component: JotterIndex
        },
        {
          path: '/editor',
          name: 'Editor',
          component: Editor
        },
        {
          path: '/libraryindex',
          name: 'LibraryIndex',
          component: LibraryIndex
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
