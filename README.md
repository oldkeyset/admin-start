# integration-vue3.0
# 根节点 App.vue
#结构(src)
* api
  1.http.js 封装的 axios的请求  封装见 src-->api-->http.js  
  安装 npm install axios --save 这里使用原生的axios(自己进行封装) 弃用vue-axios
  安装 npm install qs --save　它的作用是能把json格式的直接转成data所需的格式
  http.js中
  import axios from 'axios';
  import qs from 'qs'; 
  import { Message } from 'element-ui'
  import err_msg from './err_msg';
  方法 axios.interceptors.request和axios.interceptors.response
#axios http://www.axios-js.com/zh-cn/docs/#axios-config
#element-ui http://element-cn.eleme.io/#/zh-CN
  2.err_msg.js 异常信息配置
  3.index.js  主要写接口  其它接口也导入到这里面
  3.Message主要用来消息提示 它是element-ui中的一个方法
  在main.js中
  import api from "@/api";  //导入默认选项是 index.js 注意的是axios默认使用了Promise
  Vue.prototype.$api = api; //在全局都可以使用 this.$api.common.login(params).then((data)=>console.log(data)).catch((err)=>console.log(err));
#封装axios end  
* assets
  静态资源 json img css icon
* components
  组件  一般放置通用的
* store
  actions.js
  getters.js  通过store.getter.config_err_info  (config_err_info是在state中定义的)
  mutations.js  相当于commit  this.$store.commit("config_err_info", data);
  state.js  相当于一个容器,也就是初始的data  
  index.js 汇总,公开,导出 
  在import store from "./store"; 默认导入index.js
* router
  路由配置 
  模块化配置 
  在index.js集中 
  在main.js中引入
* views
  放置vue 组件 
  模块化配置 html script css

* .env 测试环境
* .envdevelopment 开发环境
* .env.production 生产环境

* .package.json 待更新 就说成组件管理吧
  生产环境 dependencies 项目上线时用到这里面的组件
  开发环境 devDependencies

* vue.config.js 
  vue3.0的一个鸡肋,相当于2.0中 config中的默认的index.js  



## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
# admin-start
