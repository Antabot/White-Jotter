import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      name: window.localStorage.getItem('user' || '[]') == null ? '未登录' : JSON.parse(window.localStorage.getItem('user' || '[]')).name,
      // userface: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userface,
      username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username,
      // roles: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).roles
      token: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).token
    },
    routes: []
  },
  mutations: {
    initMenu (state, menus) {
      state.routes = menus
    },
    login (state, data) {
      state.user = data
      window.localStorage.setItem('user', JSON.stringify(data))
    },
    logout (state) {
      window.localStorage.removeItem('user')
      state.user = null
      state.routes = []
    }
  },
  actions: {
  }
})
