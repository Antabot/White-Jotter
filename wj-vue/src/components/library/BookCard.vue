<template>
<div class="book">
  <!--<el-row>-->
    <!--<el-col :span="8" class="cover">-->
      <!--<img src="book.png">-->
    <!--</el-col>-->
  <!--</el-row>-->
  <div class="cover">
    <a href="#nowhere">
      <img src="https://img3.doubanio.com/view/subject/m/public/s29958602.jpg" alt="">
    </a>
  </div>
  <div class="info">
    <div class="title">
      <a href="">且在人间</a>
    </div>
    <div class="author">余秀华</div>
  </div>
</div>
</template>

<script>
    export default {
        name: 'BookCard'
    }
</script>
<style scoped>
  .book {
  width: 115px;
  height: 220px;
}

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
  }

  img {
    width: 115px;
    height: 172px;
  }

  .title {
    font-size: 14px;
    text-align: left;
  }

  .author {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }
</style>
