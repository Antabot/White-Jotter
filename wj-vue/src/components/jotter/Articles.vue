<template>
  <div style="margin-top: 40px">
    <!--<el-button @click="addArticle()">添加文章</el-button>-->
    <div class="articles-area">
      <el-card style="text-align: left">
        <div v-for="article in articles" :key="article.id">
          <div style="float:left;width:85%;height: 150px;">
            <el-link href=""><span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span></el-link>
            <el-divider content-position="left">{{article.articleDate}}</el-divider>
            <el-link :underline="false" href=""><p>{{article.articleAbstract}}</p></el-link>
          </div>
          <el-image
            style="margin:18px 0 0 30px;width:100px;height: 100px"
            :src="article.articleCover"
            fit="cover"></el-image>
          <el-divider></el-divider>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'Articles',
    data () {
      return {
        articles: []
      }
    },
    mounted: function () {
      this.loadArticles()
    },
    methods: {
      addArticle () {
        this.$router.push('/editor')
      },
      loadArticles () {
        var _this = this
        this.$axios.get('/article').then(resp => {
          if (resp && resp.status === 200) {
            _this.articles = resp.data.content
          }
        })
      }
    }
  }
</script>

<style scoped>
  .articles-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    /*margin-top: -20px;*/
    background-color: white;
  }
</style>
