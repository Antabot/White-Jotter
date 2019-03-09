import * as types from './types.js'

const mutations = {
  [types.LOGIN]: (state, data) => {
    localStorage.setItem('userName', data.username)
    localStorage.setItem('token', data.token)
    localStorage.setItem('refresh_token', data.refresh_token)
  },
  [types.LOGOUT]: (state) => {
    localStorage.removeItem('userName')
    localStorage.removeItem('token')
    localStorage.removeItem('refresh_token')
  }
}

export default mutations
