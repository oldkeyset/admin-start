import state from './state';

export default {
  auth_info: state => state.auth_info,
  user_info: state => state.user_info,
  menu: state => state.menu,
  config_err_info: state => state.config_err_info
}