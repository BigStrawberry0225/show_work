<template>
  <div>
    <div class="block">
      <el-avatar :size="150" :src="user.avatar" style="border: darkgray solid 2px"></el-avatar>
      <br/><br/>
      <input type="file" ref="inputer">
      <el-button type="primary" size="small" @click="headUp">更换头像</el-button>

    </div>
    学号:<div>{{ user.username }}</div>
    姓名:<div>{{ user.realname }}</div>
  </div>
</template>

<script>
export default {
  name: 'ImageUp',
  data () {
    return {
      hasLogin: false,
      user: {
        username: '请先登录',
        realname: '',
        avatar: '',
        sid: null
      }
    }
  },
  methods: {
    headUp (e) {
      let inputDOM = this.$refs.inputer
      this.file = inputDOM.files[0]// 通过DOM取文件数据
      this.formData = new FormData()
      this.formData.append('file', this.file)
      const _this = this
      _this.user.sid = this.$store.getters.getUser.sid
      this.$axios
        .post('api/HeadUp', this.formData)
        .then(successResponse => {
          _this.user.avatar = successResponse.data
          this.headUpp()
        })
        .catch(failResponse => {
          console.log('传输失败1')
        })
    },
    headUpp () {
      const _this = this
      this.$axios
        .post('api/HeadUpp', this.user)
        .then(successResponse => {
          console.log(successResponse)
          _this.$store.commit('upAvatar', _this.user)
        })
        .catch(failResponse => {
          console.log('传输失败2')
        })
    }
  },
  created () {
    if (this.$store.getters.getUser.username) {
      this.user.username = this.$store.getters.getUser.username
      this.user.avatar = this.$store.getters.getUser.avatar
      this.user.realname = this.$store.getters.getUser.realname
    }
  }
}
</script>

<style scoped>
.block {
  margin-top: 60px;
}
</style>
