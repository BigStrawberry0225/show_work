<template>
  <div class="m-content">
    <h3>欢迎来到HappyGiaogiao优秀作品展示网站</h3>
    <div class="block">
      <el-avatar :size="50" :src="getAvatar" style="border: darkgray solid 2px"></el-avatar>
      <div>{{ user.username }}</div>
    </div>
    <div class="m-maction">
      <span><el-link href="/home">主页</el-link></span>
      <el-divider direction="vertical"></el-divider>
      <span><el-link href="/fileup">上传作品</el-link></span>
      <el-divider direction="vertical"></el-divider>
      <span :show="hasLogin"><el-link href="/profile">个人中心</el-link></span>
      <el-divider direction="vertical"></el-divider>
      <span :show="hasLogin"><el-link type="danger" @click="logout">退出</el-link></span>
    </div>

  </div>
</template>

<script>
export default {
  name: 'Header',
  computed: {
    getAvatar () {
      return this.$store.getters.getUser.avatar
    }
  },
  data () {
    return {
      hasLogin: false,
      user: {
        username: '请先登录'
        // avatar: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605981246796&di=549af8fc7f35586f2c29d08d7a1ab41b&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimages%2F20191231%2F41f04fa7e025408eb85e056d4b4b6168.jpg'
      }
    }
  },
  methods: {
    logout () {
      const _this = this
      this.$axios.post('api/logout')
        .then((res) => {
          _this.$store.commit('logout')
          _this.$router.push('/login')
        })
        .catch(fail => {
          console.log('fail')
        })
    }
  },
  created () {
    if (this.$store.getters.getUser.username) {
      this.user.username = this.$store.getters.getUser.username
      this.user.avatar = this.$store.getters.getUser.avatar
      console.log(this.user.avatar)
      this.hasLogin = true
    }
  }
}
</script>

<style scoped>

.m-content {
  max-width: 960px;
  margin: 0 auto;
  text-align: center;
}
.m-maction {
  margin: 10px 0;
}
</style>
