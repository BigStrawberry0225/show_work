<template>
  <div class="mwork">
    <h2> {{ work.title }}</h2>
    <el-link icon="el-icon-edit" v-if="ownWork">
      <router-link :to="{name: 'FileUp', params: {workId: work.id}}" >
      编辑
      </router-link>
    </el-link>
    <el-divider></el-divider>
    <div class="markdown-body" v-html="work.content"></div>

  </div>
</template>

<script>
import 'github-markdown-css'

export default {
  name: 'WorkDetail.vue',
  data () {
    return {
      work: {
        id: null,
        sid: null,
        title: '',
        description: '',
        cname: '',
        content: ''
      },
      ownWork: false
    }
  },
  created () {
    const workId = this.$route.params.workId
    const _this = this
    this.$axios.get('api/work?pid=' + workId).then(res => {
      console.log(res)
      const work = res.data
      _this.work.id = work.pid
      _this.work.title = work.title

      var MardownIt = require('markdown-it')
      var md = new MardownIt()

      var result = md.render(work.content)
      _this.work.content = result
      _this.ownWork = (work.sid === _this.$store.getters.getUser.sid)
    })
  }
}
</script>

<style scoped>
  .mwork {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 98%;
    min-height: 700px;
    padding: 20px 15px;
  }
</style>
