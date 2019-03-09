import * as types from './types.js'

// actions常用于异步更改状态。也就是说它一般用来先发送请求，然后再commit
export default {
  UserLogin ({commit}, data) {
    commit(types.LOGIN, data)
  },
  UserLogout ({commit}) {
    commit(types.LOGOUT)
  }
}
