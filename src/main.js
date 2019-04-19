import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementUI,{ Message } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import api from "@/api";



Vue.config.productionTip = false;
Vue.use(ElementUI);

Vue.prototype.$api = api;
//统一消息提示框
Vue.prototype.$error = function (msg) {
  Message({
    showClose: true,
    message: msg,
    type: 'error'
  })
};
Vue.prototype.$success = function (msg) {
  Message({
    showClose: true,
    message: msg,
    type: 'success'
  })
};


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
