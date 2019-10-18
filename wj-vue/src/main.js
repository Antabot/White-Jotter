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

Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(mavonEditor)

// 页面刷新时，重新赋值token，也可直接在 store 里设置 token 默认值
// if (window.localStorage.getItem('token')) {
//   store.commit('login', window.localStorage.getItem('token'))
// }

router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
      if (store.state.user.token) {
        console.log(store.state.user.token)
        axios.post('/authentication')
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

// http request 拦截器
axios.interceptors.request.use(
  config => {
    if (store.state.user.token) {
      // 判断是否存在token，如果存在的话，则每个http header都加上token
      // config.headers.Token = `token ${JSON.stringify(store.state.user.token)}`
      config.headers.Token = JSON.stringify(store.state.user.token)
    }
    return config
  },
  err => {
    return Promise.reject(err)
  })

// http response 拦截器
axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          // 返回 401 清除token信息并跳转到登录页面
          store.commit('logout')
          router.replace({
            path: 'login',
            query: {redirect: router.currentRoute.fullPath}
          })
      }
    }
    // 返回接口返回的错误信息
    return Promise.reject(error.response.data)
  })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
