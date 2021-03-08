<template>
  <el-table
    :data="courseTable"
    stripe
    style="width: 100%">
    <el-table-column
      prop="cid"
      label="序号"
      width="260">
    </el-table-column>
    <el-table-column
      prop="cname"
      label="课程名"
      width="260">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          style="width: 200px;"
          v-model="coursename"
          size="mini"
          placeholder="输入课程名字"/>
        <el-button type="primary" size="mini" @click="addCourse">添加课程</el-button>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row.cname)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'MCourse',
  data () {
    return {
      coursename: '',
      courseTable: [
        {
          cid: '1',
          cname: '数据库课程设计'
        }
      ]
    }
  },
  methods: {
    handleDelete (coursename) {
      const _this = this
      this.$axios.post('api/deleteCourse', {cname: coursename})
        .then(res => {
          _this.$alert('操作成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              this.getCourse()
            }
          })
        }).catch(fail => {
          console.log('删除失败')
        })
    },
    addCourse () {
      const _this = this
      this.$axios.post('api/addCourse', {cname: this.coursename})
        .then(res => {
          _this.$alert('操作成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              this.getCourse()
            }
          })
        }).catch(fail => {
          console.log('添加失败')
        })
    }
  },
  created () {
    this.$axios.post('api/getCourse')
      .then(res => {
        this.courseTable = res.data
      })
  }
}
</script>

<style scoped>

</style>
