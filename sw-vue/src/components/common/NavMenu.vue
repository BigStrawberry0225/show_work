<template>
  <el-menu
    :default-active="'/muser'"
    router
    mode="horizontal"
    background-color="#24292e"
    text-color="white"
    active-text-color="#fff"
    style="min-width: 1000px;height: 60px">

    <el-menu-item index="/muser" >用户管理</el-menu-item>
    <el-menu-item index="/mcourse" >课程管理</el-menu-item>
    <el-menu-item index="/mproject">项目管理</el-menu-item>
    <el-avatar style="position:absolute; left: 36%;margin-top: 12px" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605981246796&di=549af8fc7f35586f2c29d08d7a1ab41b&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimages%2F20191231%2F41f04fa7e025408eb85e056d4b4b6168.jpg" :size="38"></el-avatar>
    <span style="position: absolute;padding-top: 17px;right: 35%;font-size: 20px;font-weight: bold;color: #eaeaea">HappyGiaogiao优秀作品展示网管理平台</span>

  </el-menu>
</template>

<script>
export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [
        {name: '/muser', navItem: '用户管理'},
        {name: '/mcourse', navItem: '课程管理'},
        {name: '/mproject', navItem: '项目管理'}
      ]
    }
  }
}
</script>

<style>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
  .el-input__inner {
    background-color: #24292e;
    height: 30px;
    border: 1px solid #e1e4e8;
  }
  .search :focus {
    background-color: white;
  }
</style>

<!--// methods: {-->
<!--//   handleFileChange (e) {-->
<!--//     let inputDOM = this.$refs.inputer-->
<!--//     this.file = inputDOM.files[0]// 通过DOM取文件数据-->
<!--//     // let size = Math.floor(this.file.size / 1024)// 计算文件的大小-->
<!--//     this.formData = new FormData()-->
<!--//     this.formData.append('file', this.file)-->
<!--//     // this.formData = new FormData()// new一个formData事件-->
<!--//     // this.formData.append('file', this.file) // 将file属性添加到formData里-->
<!--//     // 此时formData就是我们要向后台传的参数了-->
<!--//     // var _this = this-->
<!--//     console.log(this.file)-->
<!--//     console.log(this.formData)-->
<!--//     var _this = this-->
<!--//     this.$axios-->
<!--//       .post('api/fileUpDqy', this.formData)-->
<!--//       .then(successResponse => {-->
<!--//         console.log('成功')-->
<!--//         if (successResponse.data.code === 200) {-->
<!--//           console.log('传输成功')-->
<!--//         }-->
<!--//       })-->
<!--//       .catch(failResponse => {-->
<!--//         console.log('传输失败')-->
<!--//         _this.returnd = 'false'-->
<!--//       })-->
<!--//   }-->
<!--// }-->
