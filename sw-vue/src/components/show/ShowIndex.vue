<template>
  <el-container>
    <el-aside style="width: 400px;margin-top: 10px;">
      <side-menu @indexSelect="listByCourse" ref="sideMenu"/>
    </el-aside>
    <el-main>
      <all-work ref="allWork"/>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import AllWork from './AllWork'
export default {
  name: 'ShowIndex',
  components: {SideMenu, AllWork},
  methods: {
    listByCourse (cname) {
      var _this = this
      _this.$refs.allWork.cname = cname
      _this.$refs.allWork.page(1)
    }
  }
}
</script>

<style scoped>

</style>
