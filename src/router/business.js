const user_list = () => import('../views/business/user/list')
const user_info = () => import('../views/business/user/info')

const role_list = () => import('../views/business/role/list');

export default [
  {
    path: "/user/user_list",
    name: "user_list",
    component: user_list,
    meta: {
      keepAlive: true
    },
    props: true
  },
  {
    path: "/user/user_info/:userid?",
    name: "user_info",
    component: user_info,
    meta: {
      keepAlive: true
    },
    props: true
  },
  {
    path: "/role/role_list",
    name: "role_list",
    component: role_list,
    meat: {
      keepAlive: true
    },
    props: true
  }
]