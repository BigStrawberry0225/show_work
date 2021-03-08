<template>

  <el-table
    :data="userTable"
    stripe
    style="width: 100%">
    <el-table-column
      prop="sid"
      label="序号"
      width="260">
    </el-table-column>
    <el-table-column
      prop="username"
      label="学号"
      width="260">
    </el-table-column>
    <el-table-column
      prop="realname"
      label="姓名"
      width="260">
    </el-table-column>
    <el-table-column
      prop="address"
      label="仓库地址"
      width="260">
    </el-table-column>
    <el-table-column
      label="状态">
      <template slot-scope="{row,$index}">
        <el-switch
          v-model="row.status"
          active-color="#13ce66"
          inactive-color="#ff4949"
          @change="statusChange($event,row.username,$index)">
        </el-switch>
      </template>
    </el-table-column>
  </el-table>

</template>

<script>
export default {
  name: 'MUser',
  data () {
    return {
      userTable: [
      ]
    }
  },
  methods: {
    statusChange ($event, username, $index) {
      // const _this = this
      // _this.userTable[$index].status = $event
      console.log($event)
      console.log(username)
      // console.log(_this.userTable[$index].status)
      this.$axios.post('api/statusChange', {
        username: username,
        status: $event
      }).catch(fail => {
        console.log('状态修改失败了')
      })
    }
  },
  created () {
    const _this = this
    this.$axios.post('api/getUser').then(res => {
      console.log('成了')
      console.log(res)
      _this.userTable = res.data
    }).catch(fail => {
      console.log('用户获取失败了')
    })
  }
}
</script>

<style scoped>
body{
  text-align: center;
}
</style>
