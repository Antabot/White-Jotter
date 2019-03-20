<template>
  <div id="book-bg">
  <div class="subject">
    <el-card style="margin-top: 30px;width: 680px">
    <el-row>
      <h1>且在人间</h1>
    </el-row>
    <el-row>
        <div class="content">
              <div class="cover">
                <a href="">
                  <img src="../../../assets/img/books/s29958602.jpg" alt="">
                </a>
              </div>
              <div class="info">
                <span>作者：<a href="" style="text-decoration: none;color: blue">余秀华</a></span><br>
                <span>出版社：湖南文艺出版社</span><br>
                <span>出版日期：2019-2-1</span><br>
                <span>页数：248</span><br>
                <span>装帧：精装</span><br>
                <span>ISBN：9787540488949</span><br>
              </div>
        </div>
    </el-row>
      <el-button style="float: right; padding: 3px 0" type="text">修改</el-button>
    <div class="abstract">
      <h2><span>内容简介</span>&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·</h2>
      <div class="intro">
        <p>诗人余秀华中篇小说首次结集出版。

          《且在人间》——以余秀华为生活原型，讲述一个残疾女人悲苦倔强、向死而生的故事。

          女主人公周玉生活在乡村，患有“脑瘫”，她几乎被所有人漠视，甚至被整个社会抛弃，但是她渴望被当成一个普通的健康人,而不是带着怜悯或不屑，她只要求平等。爱情的缺 失，家庭的不幸，生活的种种际遇让周玉用诗歌的方式把 情感抒发出来，最终她用诗歌创作出了一个文学的世界，得到了人们的认可。作者用平静的笔调书写残疾人的底层生活,将堆积在心底的黑暗与爱化作成长的养分,达到了一种真实而达观、勇敢而平静的生命境界。

          ...</p>
      </div>
    </div>
    </el-card>
    <!--<div style="min-height:100px;"> </div>-->
  </div>
  </div>
</template>

<style scoped>
  #book-bg {
    width: 100%;
    height: 700px;
    position: absolute;
    background: url("../../../assets/img/bg/bg2.jpg") no-repeat;
    background-size: cover%;
    background-position: center;
    /*margin: 0;*/
  }
  .subject{
    /*min-width: 500px;*/
    /*实现把主体内容放在页面的中间偏左位置*/
    position: absolute;
    left:20%;
    top: 5%;
    margin-left: -60px;
  }

  .cover {
    width: 135px;
    height: 200px;
    margin-bottom: 20px;
    overflow: hidden;
    float: left;
  }

  img {
    width: 135px;
    height: 200px;
    /*margin: 0 auto;*/
  }

  h1 {
    font-size: 26px;
    font-weight: bold;
    color: #494949;
    line-height: 1.1;
    padding: 15px 0 0 0;
    float: left;
  }

  .info {
    text-align: left;
    font: 14px Arial, Helvetica, sans-serif;
    line-height: 150%;
    color: #666666;
    float: left;
    margin-left: 15px;
   }

  .abstract {
    text-align: left;
    margin-left: 10px;
  }

  h2 {
    font-size: 16px;
    color: #007722;
    line-height: 150%;
  }

  .intro {
    width: 600px;
  }
</style>
