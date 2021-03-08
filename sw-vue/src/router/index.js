import Vue from 'vue'
import Router from 'vue-router'

import Login from '../components/Login'
import Home from '../components/Home'
import ShowIndex from '../components/show/ShowIndex'
import ProfileIndex from '../components/profile/ProfileIndex'
import FileUp from '../components/fileup/FileUp'
import MHome from '../components/MHome'
import MUser from '../components/mcomps/MUser'
import MCourse from '../components/mcomps/MCourse'
import MProject from '../components/mcomps/MProject'
import WorkDetail from '../components/profile/WorkDetail'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/index',
          name: 'ShowIndex',
          component: ShowIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/profile',
          name: 'Profile',
          component: ProfileIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/fileup',
          name: 'FileUp',
          component: FileUp,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/workdetail',
          name: 'WorkDetail',
          component: WorkDetail,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/mhome',
      name: 'MHome',
      component: MHome,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/muser',
          name: 'MUser',
          component: MUser,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/mcourse',
          name: 'MCourse',
          component: MCourse,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/mproject',
          name: 'MProject',
          component: MProject,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})
