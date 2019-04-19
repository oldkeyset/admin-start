module.exports = {
  publicPath: '/',//根路径
  outputDir: 'dist',//构建输出目录 npm run build 打包存放位置
  assetsDir: 'assets',//静态资源目录 (js,css,img,fong)
  lintOnSave: false,//是否开启eslint保存检测检查语法 有效值 : true || false || 'error'
  devServer: {
    open: true,//启动项目是否自动弹出一个页面
    host: "127.0.0.1",
    port: 8081,
    https: false,
    hotOnly: false, //热更新
    proxy: null,//是否跨域,axios觉得无需配置
    // proxy: {
    //   //配置跨域
    //   '/api': {
    //     target: "http://localhost:8081/api", //目标地址
    //     ws: true,//是否跨域
    //     changOrigin: true,
    //     pathRewrite: {
    //       '^/api': ''
    //     }
    //   }
    // },
    before(app) {

    }
  }
}