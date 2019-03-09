<template>
  <elmain>
  <el-row class="proto-card-list">
    <el-col :span="8" class="picture">
      <img src="book.png">
    </el-col>
    <el-col :span="8" class="body">
      <!--<el-row>-->
        <!--<el-col :span="24">-->
          <h1 class="header">书名</h1>
        <!--</el-col>-->
      <!--</el-row>-->
      <!--<el-row>-->
        <!--<el-col :span="24">-->
          <p class="text">简介 啊啊啊啊啊编程好难啊</p>
        <!--</el-col>-->
      <!--</el-row>-->
    </el-col>
    <el-col :span="8" class="footer"></el-col>
  </el-row>
  </elmain>
</template>

<script>
    export default {
        name: 'BookCard'
    }
</script>
<style scoped>
  .proto-card-list {
    height: 150px;
    background: #99a9bf;
    line-height: 100px;
    margin: 0;
  }
  .picture {
    background: #e5e9f2;
    margin: 0px;
    width: 25%;
    height: 100%;
  }
  .header {
    background: #99a9bf;
    margin: 0px;
    line-height: 50px;
  }
  .text {
    background: #e5e9f2;
    margin: 0px;
    line-height: 100px;
  }
  .footer {
    background: #d3dce6;
    line-height: 100px;
  }
  .body{
    width: 40%;
    background: blue;
    margin: 0px;
    height: 100%;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
