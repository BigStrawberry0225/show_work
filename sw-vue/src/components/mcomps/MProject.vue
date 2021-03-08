<template>
  <div>
    <el-table
      :data="projectTable"
      stripe
      style="width: 100%">
      <el-table-column
        prop="pid"
        label="序号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="title"
        label="题目"
        width="170">
      </el-table-column>
      <el-table-column
        prop="username"
        label="学号"
        width="170">
      </el-table-column>
      <el-table-column
        prop="realname"
        label="姓名"
        width="170">
      </el-table-column>
      <el-table-column
        prop="cname"
        label="课程"
        width="170">
      </el-table-column>
      <el-table-column
        prop="date"
        label="日期"
        width="170">
      </el-table-column>
      <el-table-column
        align="right">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.pid)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination class="mpage"
                   layout="prev, pager, next, total"
                   :current-page="currentPage"
                   :page-size="pageSize"
                   :total="total"
                   @current-change=page>
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: 'MProject',
  data () {
    return {
      projectTable: [
        {
          pid: '',
          username: '',
          realname: '',
          title: '',
          cname: '',
          date: ''
        }
      ],
      currentPage: 1,
      total: 0,
      pageSize: null
    }
  },
  methods: {
    handleDelete (id) {
      const _this = this
      this.$axios.post('api/deleteProject', {pid: id})
        .then(res => {
          _this.$alert('操作成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              this.page(1)
            }
          })
        }).catch(fail => {
          console.log('删除失败')
        })
    },
    page (currentPage) {
      this.$axios.get('api/mWorks?currentPage=1')
        .then(res => {
          console.log(res)
          const _this = this
          _this.projectTable = res.data.data
          _this.currentPage = res.data.currentPage
          _this.total = res.data.total
          _this.pageSize = res.data.pageSize
        })
    }
  },
  created () {
    this.page(1)
  }
}
</script>

<style scoped>

</style>
