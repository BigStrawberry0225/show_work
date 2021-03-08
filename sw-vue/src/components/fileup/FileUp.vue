<template>
  <div class="m-content">

    <el-form :model="ruleform" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="标题" prop="title">
        <el-input v-model="ruleform.title"></el-input>
      </el-form-item>

      <el-form-item label="摘要" prop="description">
        <el-input type="textarea" v-model="ruleform.description"></el-input>
      </el-form-item>

      <el-form-item label="类别" prop="course"  style="text-align: left">
        <el-select v-model="ruleform.cname" placeholder="请选择">
          <el-option
            v-for="(item,index) in courses"
            :key=index
            :label=item.cname
            :value=item.cname>
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="内容" prop="content">
        <mavon-editor v-model="ruleform.content"></mavon-editor>
      </el-form-item>

      <el-form-item label="作品上传" prop="formdata" style="text-align: left">
        <input type="file" ref="inputer" enctype="multipart/form-data">
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即上传</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: 'FileUp',
  data () {
    return {
      ruleform: {
        pid: null,
        id: '',
        sid: null,
        title: '',
        description: '',
        cname: '',
        content: ''
      },
      formData: {},
      rules: {
        title: [
          {require: true, message: '请输入标题', trigger: 'blur'},
          {min: 3, max: 25, message: '长度在3到25个字符', trigger: 'blur'}
        ],
        description: [
          {require: true, message: '请输入摘要', trigger: 'blur'}
        ],
        content: [
          {require: true, message: '请输入摘要', trigger: 'blur'}
        ]
      },
      courses: ['数据结构', 'web课程设计', '软件工程', '数据库']
    }
  },
  methods: {
    file2formdata () {
      let inputDOM = this.$refs.inputer
      let file = inputDOM.files[0]// 通过DOM取文件数据
      let formData = new FormData()
      formData.append('file', file)
      console.log(formData)
      this.formData = formData
    },
    submitForm (formName) {
      this.file2formdata()
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.ruleform.sid = this.$store.getters.getUser.sid
          const _this = this
          // 文件上传
          if (this.formData !== null) {
            this.$axios.post('api/fileup', this.formData)
              .then(res => {
                _this.$alert('操作成功', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push('/profile')
                  }
                })
              }).catch(fail => {
                console.log('fail to upfile')
              })
          }
          this.$axios.post('api/fileup2', this.ruleform)
            .then(res => {
              this.$router.push('/profile')
            }).catch(fail => {
              console.log('fail to upfile')
            })
        } else {
          console.log('error submit!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  },
  created () {
    const workId = this.$route.params.workId
    console.log(workId)
    this.ruleform.pid = workId
    const _this = this
    if (workId) {
      this.$axios.get('api/work?pid=' + workId).then(res => {
        const workId = res.data
        _this.ruleform.id = workId.id
        _this.ruleform.title = workId.title
        _this.ruleform.description = workId.description
        _this.ruleform.content = workId.content
        _this.ruleform.cname = workId.cname
      })
    }
    this.$axios.post('api/getCourse')
      .then(res => {
        this.courses = res.data
      })
  }
}
</script>

<style scoped>
  .m-content{
    text-align: center;
  }
</style>
