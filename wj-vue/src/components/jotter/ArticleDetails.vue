<template>
  <div class="articles-area">
    <el-card style="text-align: left">
      <div style="float:left;width:85%;height: 150px;">
        <span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span>
        <el-divider content-position="left">{{article.articleDate}}</el-divider>
        {{article.articleHtml}}
      </div>
      <el-image
        style="margin:18px 0 0 30px;width:100px;height: 100px"
        :src="article.articleCover"
        :fit="cover"></el-image>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'ArticleDetails',
    data () {
      return {
        article: []
      }
    }
  }
</script>

<style scoped>

</style>
