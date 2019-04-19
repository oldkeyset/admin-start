import Vue from "vue";
import Router from "vue-router";
import store from "../store";
Vue.use(Router);

import baseRouter from './base'
import businessRouter from './business'

import Home from '../views/common/Home'
import Login from '../views/common/Login'
import Test from '../views/common/Test'
import Excel from '../components/Excel'

import _404 from '../views/common/404'


const childrenRouter = [...baseRouter,...businessRouter];


const router =  new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      component: Login
    },
    {
      path: "/test",
      component: Test
    },
    {
      path: "/excel",
      component: Excel
    },
    {
      path:'/index',
      component:Home,
      children:childrenRouter
    },
    {
      path:'*',
      component:_404
    }
  ]
});
//init
let peerid = localStorage.getItem('peerid') || ''
let sessionid = localStorage.getItem('sessionid') || ''
let username = localStorage.getItem('username') || ''

peerid && store.commit('auth_info', {
  peerid
})
sessionid && store.commit('auth_info', {
  sessionid
})
username && store.commit('auth_info', {
  username
})


router.beforeEach((to,from,next)=>{
  let peerid = store.state.auth_info.peerid;
  let sessionid = store.state.auth_info.sessionid;
  let login_status = localStorage.getItem('login_status');
  next();
})

export default router;
