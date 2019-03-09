const state = {
  currentUser: {
    get UserName () {
      return localStorage.getItem('name')
    },
    get UserToken () {
      return localStorage.getItem('token')
    },
    get UserRefreshToken () {
      return localStorage.getItem('refresh_token')
    }
  }
}

export default state
