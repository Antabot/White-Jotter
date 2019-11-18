// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import store from './store'

var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// 使请求带上凭证信息
axios.defaults.withCredentials = true

Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(mavonEditor)

// 如果前端没有登录信息则直接拦截，如果有则判断后端是否正常登录（防止构造参数绕过）
router.beforeEach((to, from, next) => {
    if (store.state.user.username && to.path.startsWith('/admin')) {
      axios.get('/authentication').then(resp => {
        console.log('菜单加载成功')
        initAdminMenu(router, store)
      })
    }
    if (to.meta.requireAuth) {
      if (store.state.user.username) {
        axios.get('/authentication').then(resp => {
          if (resp) next()
        })
        next()
      } else {
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      next()
    }
  }
)

// http request拦截器，为请求加上 token，测试用
/* axios.interceptors.request.use(
  config => {
    // 输出当前状态下的 token
    // console.log(store.state.user.token)
    if (store.state.user.token) {
      // 判断当前是否存在token，如果存在的话，则每个http header都加上token
      // config.headers.Token = `token ${JSON.stringify(store.state.user.token)}`
      config.headers.Token = JSON.stringify(store.state.user.token)
    } else {
      config.headers.Token = null
    }
    return config
  },
  err => {
    return Promise.reject(err)
  }
) */

// http response 拦截器
axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    console.log(error.response)
    if (error) {
      router.replace({
        path: 'login'
        // query: {redirect: router.currentRoute.fullPath}
      })
    }
    // 返回接口返回的错误信息
    return Promise.reject(error.response.data)
  })

export const initAdminMenu = (router, store) => {
  if (store.state.adminMenus.length > 0) {
    return
  }
  axios.get('/menu').then(resp => {
    if (resp && resp.status === 200) {
      var fmtRoutes = formatRoutes(resp.data)
      router.addRoutes(fmtRoutes)
      store.commit('initAdminMenu', fmtRoutes)
    }
  })
}

export const formatRoutes = (routes) => {
  let fmtRoutes = []
  routes.forEach(route => {
    let {
      path,
      component,
      name,
      nameZh,
      iconCls,
      children
    } = route

    if (children) {
      children = formatRoutes(children)
    }
    let fmtRoute = {
      path: path,
      component: resolve => {
        if (component.startsWith('User')) {
          require(['./components/admin/user/' + component + '.vue'], resolve)
        } else if (component.startsWith('Library')) {
          // require(['./library/' + component + '.vue'], resolve)
        } else if (component.startsWith('Admin')) {
          require(['./components/admin/' + component + '.vue'], resolve)
        }
      },
      name: name,
      nameZh: nameZh,
      meta: {
        requireAuth: true
      },
      iconCls: iconCls,
      children: children
    }
    fmtRoutes.push(fmtRoute)
  })
  return fmtRoutes
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: {App},
  template: '<App/>'
})
