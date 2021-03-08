import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

// import axios from 'axios'
// import VueAxios from 'vue-axios'
// // 使请求带上凭证信息
// axios.defaults.withCredentials = true
// axios.defaults.baseURL = 'http://192.168.43.85:8443/api'
// Vue.use(VueAxios, axios)

import Axios from 'axios'
// 设置反向代理，前端请求发送到http://localhost:8443/api
// Axios.defaults.baseUrl = 'http://192.168.43.85:8443/api'
Axios.defaults.baseUrl = 'http://localhost:8443/api'

// 使请求带上凭证信息
Axios.defaults.withCredentials = true
// 全局注册，之后可在其他组件中通过this.$axios发送数据
Vue.prototype.$axios = Axios
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(mavonEditor)

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      console.log(store.state.user.username)
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else next()
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
