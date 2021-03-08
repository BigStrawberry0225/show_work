<template>
  <div>
    <span>我的作品</span>
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
  name: 'MyFile',
  data () {
    return {
      works: [],
      currentPage: 1,
      total: 0,
      pageSize: null
    }
  },
  methods: {
    page (currentPage) {
      const _this = this
      this.$axios.get('api/oneWorks?currentPage=' + currentPage + '&sid=' + this.$store.getters.getUser.sid).then(res => {
        console.log(res)
        _this.works = res.data.data
        console.log(_this.works)
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
  .mpage {
    margin: 0 auto;
    text-align: center;
  }

</style>
