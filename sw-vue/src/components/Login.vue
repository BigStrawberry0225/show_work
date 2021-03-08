<template>
  <body id="poster">
    <el-form class="login-container" label-position="left" label-width="0px">
      <h3 class="login_title">系统登陆</h3>
      <el-form-item>
        <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="学号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 48%; background: #505458;border: none" @click="login">登录</el-button>
<!--        <el-divider></el-divider>-->
        <el-button type="warning" style="width: 48%; border: none" @click="mlogin">管理员登录</el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: '',
        avatar: '',
        sid: null,
        realname: ''
      }
    }
  },
  methods: {
    login () {
      var _this = this
      // console.log(this.$store.state)
      this.$axios
        .post('api/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            console.log(successResponse.data)
            this.loginForm.sid = successResponse.data.sid
            this.loginForm.avatar = successResponse.data.avatar
            this.loginForm.realname = successResponse.data.realname
            // 调用store中的方法把用户信息存起来
            _this.$store.commit('login', _this.loginForm)
            var path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
          } else if (successResponse.data.code === 400) {
            _this.$alert('账号已被封号', '提示', {
              confirmButtonText: '确定',
              callback: action => {
              }
            })
          } else {
            _this.$alert('没有此账号请联系管理员', '提示', {
              confirmButtonText: '确定',
              callback: action => {
              }
            })
          }
        })
        .catch(failResponse => {
        })
    },
    mlogin () {
      this.$axios
        .post('api/mlogin', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            // var path = this.$route.query.redirect
            // this.$router.replace({path: path === '/' || path === undefined ? '/muser' : path})
            this.$router.push('/muser')
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>

<style>
  #poster {
    background: url("../assets/image/login.jpg") no-repeat center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }

  body {
    margin: 0;
  }

  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

</style>
