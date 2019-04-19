import axios from 'axios';
import qs from 'qs';
import { Message } from 'element-ui'
import store from '@/store'
import router from '@/router'
import err_msg from './err_msg';
//请求超时 10ms
axios.defaults.timeout = 10000;
//它会自动判断环境 取决于 nmp run (sreve,build) 
//踩坑 baseURL(URL全大写) 不要写成 baseUrl
axios.defaults.baseURL = process.env.VUE_APP_URL;


axios.get = (url, params) => {
  return axios.request({
    url: url,
    method: 'get',
    params: params || {}
  });
};
//处理客户端请求
axios.interceptors.request.use(config => {
  //qs 可以将{username:"oldkeyset",password:"123456"} 转换为 usernmae=oldkeyset&password=123456
  // config.params = qs.stringify(config.params); 
  //get 请求 一般用来获取数据 默认headers 默认为空
  let peerid = store.state.auth_info.peerid
  let sessionid = store.state.auth_info.sessionid
  let username = store.state.auth_info.username
  if (config.method === 'get') {
    //可以根据项目需求在这里添加 额外参数 优先传递过来的参数
    config.params.peerid = peerid || config.params.peerid
    config.params.sessionid = sessionid || config.params.sessionid
    config.params.username = username || config.params.username
  } else if (config.method === 'post') {

    config.data.peerid = peerid||config.data.peerid
    config.data.sessionid = sessionid || config.data.sessionid
    config.data.username = username || config.data.username
    config.data = qs.stringify(config.data);
    config.headers["Content-Type"] = "application/x-www-form-urlencoded";
  }
  console.log(config);
  return config;
},
  err => {
    return Promise.reject(err);
  }
);
//处理服务端的返回的结果
axios.interceptors.response.use(response => {
  //data 主要是服务端封装的返回结果
  //我封装的是 
  //status: 状态码
  //msg 单条的消息 或者错误消息
  //data Object类型 一般放返回的是 对象或list 或 map
  let data = response.data; //200就为正常的 可以返回data.data
  if (data.status !== 200) {
    //2051 登录态过期 2052 账号被挤出(异地登录) 4101信息过期
    if (data.status === 2051 || data.status === 2052 || data.status === 4101 || data.status === 4005) {
      //跳转到登录页
      router.replace({
        path: '/'
      })
    } else {
      //错误处理
      try {
        //获取baseURL 后面的地址 
        //其它异常进来这里适配
        //let reqUrl = response.config.url.slice(process.env.VUE_APP_URL.length, response.config.url.length).split('/');
        //用户登录后的操作 store.getters.config_err_info从数据库获取error信息,统一适配
        //字段为请求路径  对应错误信息
        //未登陆直接走catch
        let errInfo = err_msg;//store.getters.config_err_info 

        let resData = JSON.parse(JSON.stringify(data));
        // for (let i = 0; i < reqUrl.length; i++) {
        //   const e = reqUrl[i]
        //   errInfo = errInfo[e]
        // }
        resData.msg = errInfo[resData.msg] || resData.msg;
        //resData 主要将msg 修改为用户能够识别的提示信息 其它信息不变
        return Promise.reject(resData);
      } catch (error) {
        //try中人为异常会进这里
        Message({
          showClose: true,
          message: err_msg[data.msg] || data.msg,
          type: 'error'
        });
        return Promise.reject(data);
      }
    }
  }
  return data.data;
},
  error => {
    //这里拦截到的一般是http默认状态码  系统异常  例如服务器挂了
    return Promise.reject({
      msg: error.response.status || error.status
    })
  }
);

export default axios;
