<template>
  <div>
    <el-row>
      <el-input
        v-model="title"
        style="margin: 10px 0px;font-size: 18px;"
        placeholder="请输入标题"></el-input>
    </el-row>
    <el-row style="height: calc(100vh - 140px);">
      <mavon-editor
        v-model="value"
        style="height: 100%;"
        ref=md
        @save="saveArticles(value, render)"
        fontSize="16px"/>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'Editor',
    data () {
      return {
        title: '',
        value: ''
      }
    },
    methods: {
      saveArticles (value, render) {
        // value 是 md，render 是 html
        this.$confirm('是否保存并发布文章?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .post('/admin/content/articles/save', {value: value}).then(resp => {
              if (resp && resp.status === 200) {
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消发布'
          })
        })
      }
    }
  }
</script>
