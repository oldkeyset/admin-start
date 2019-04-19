import http from './http';

export default {
  common: {
    login(username,password,checkcode) {
      return http.post('/common/login',{
        username,
        password,
        checkcode
      });
    },
    error_msg(errorCode) {
      return http.get('/common/error', {
        errorCode
      });
    },
    captcha(peerid) {
      return http.get('/common/captcha', {
        peerid
      })
    },
    peerid() {
      return http.post('/common/peerid', {
        clienttype: 'admin'
      })
    },
  },
  config: {
    menu_list() {
      return http.get('/config/menu_list')
    }
  }
}