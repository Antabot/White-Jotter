<template>
  <el-button @click="addArticle()">添加文章</el-button>
</template>

<script>

  export default {
    name: 'Articles',
    methods: {
      addArticle () {
        this.$router.push('/editor')
      }
    }
  }
</script>
