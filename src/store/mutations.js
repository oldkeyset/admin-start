export default {
  auth_info: (state, data) => {
    data.peerid && (state.auth_info.peerid = data.peerid)
    data.sessionid && (state.auth_info.sessionid = data.sessionid)
    data.username && (state.auth_info.username = data.username)
  },
  user_info: (state, data) => {
    state.user_info.userid = data.userid
    state.user_info.username = data.username
  },
  menu: (state, data) => {
    state.menu = data
  },
  config_err_info: (state, data) => {
    state.config_err_info = data
  }
}