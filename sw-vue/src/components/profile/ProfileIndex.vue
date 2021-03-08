<template>
  <el-container>
    <el-aside style="width: 400px;margin-top: 10px;">
      <Profile/>
    </el-aside>
    <el-main>
      <my-file/>
    </el-main>
  </el-container>
</template>

<script>
import MyFile from './MyFile'
import Profile from './Profile'
// import Profile2 from './Profile'
export default {
  name: 'ProfileIndex',
  components: {MyFile, Profile}
}
</script>

<style scoped>

</style>
