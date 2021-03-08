<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect">
    <template v-for="(item, index) in courses">
      <el-menu-item :index="item.cname" :key="index">
        <i class="el-icon-menu"></i>
        <span slot="title">{{item.cname}}</span>
      </el-menu-item>
    </template>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu',
  data () {
    return {
      courses: ['数据结构', 'web课程设计', '软件工程', '数据库']
    }
  },
  methods: {
    handleSelect (cname) {
      console.log(cname)
      this.$emit('indexSelect', cname)
    }
  },
  created () {
    this.$axios.post('api/getCourse')
      .then(res => {
        this.courses = res.data
        console.log(this.courses)
      })
  }
}
</script>

<style scoped>
  .categories {
    margin-left: 25%;
  }
</style>
