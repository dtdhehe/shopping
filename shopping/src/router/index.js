import Vue from 'vue'
import Router from 'vue-router'
import Login from '../../src/view/login'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/login',
      name:'登录页',
      // component:Login,
      component:()=>import('@/view/login/index')
    },
    {
      path:'/home',
      name:'首页',
      component:()=>import('@/view/home')
    },
    {
      path:'/regist',
      name:'注册',
      component:()=>import('@/view/regist')
    },
    //路由重定向
    {
      path:'/*',
      redirect:'/login'
    },
  ],
  mode:"history"
})
