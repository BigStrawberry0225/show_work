<template>
<div>
  <span>{{cname}}</span>
  <el-button style="position: absolute; right: 3%" type="success" @click="getAllProject">显示全部作品</el-button>
  <el-divider></el-divider>

  <div class="block">
    <el-timeline>
      <el-timeline-item :timestamp="work.date" placement="top" v-for="(work, key) in works" :key="key">
        <el-card>
          <h4>
            <router-link :to="{name: 'WorkDetail', params: {workId: work.pid}}">
              {{work.title}}
            </router-link>
          </h4>
          <p>{{work.description}}</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>

    <el-pagination class="mpage"
                   layout="prev, pager, next, total"
                   :current-page="currentPage"
                   :page-size="pageSize"
                   :total="total"
                   @current-change=page>
    </el-pagination>
  </div>
</div>
</template>

<script>
export default {
  name: 'AllWork',
  data () {
    return {
      works: {},
      currentPage: 1,
      total: 0,
      pageSize: null,
      cname: '全部作品'
    }
  },
  methods: {
    page (currentPage) {
      const _this = this
      console.log(this.cname)
      this.$axios.get('api/works?currentPage=' + currentPage + '&cname=' + this.cname).then(res => {
        console.log(res)
        _this.works = res.data.data
        console.log(_this.works)
        _this.currentPage = res.data.currentPage
        _this.total = res.data.total
        _this.pageSize = res.data.pageSize
      })
    },
    getAllProject () {
      this.$axios.get('api/works?currentPage=1&cname=全部作品').then(res => {
        const _this = this
        _this.works = res.data.data
        _this.cname = '全部作品'
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
