<template>
  <el-upload
    class="img-upload"
    action="http://localhost:8443/api/covers"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :before-remove="beforeRemove"
    :on-success="handleSuccess"
    multiple
    :limit="1"
    :on-exceed="handleExceed"
    :file-list="fileList">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
  </el-upload>
</template>

<script>
  export default {
    name: 'ImgUpload',
    data () {
      return {
        fileList: []
      }
    },
    methods: {
      handleRemove (file, fileList) {
        console.log(file, fileList)
      },
      handlePreview (file) {
        console.log(file)
      },
      handleExceed (files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
      },
      beforeRemove (file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`)
      },
      handleSuccess () {
        this.$message.warning('上传成功')
      }
    }
  }
</script>

<style scoped>
  .img-upload {
    /*height: 200px;*/
  }
</style>
