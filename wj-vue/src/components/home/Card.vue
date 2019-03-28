<template>
  <div style="width: 80%; margin-left: auto; margin-right: auto; height: 350px">
    <div style="position: relative">
      <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>最新内容</span>
        <el-button style="float: right; padding: 3px 0" type="text">处理</el-button>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'新增内容 ' + o }}
      </div>
    </el-card>
      <el-card class="box-card-2">
        <div slot="header" class="clearfix">
          <span>最新内容</span>
          <el-button style="float: right; padding: 3px 0" type="text">处理</el-button>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'新增内容 ' + o }}
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Card'
  }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .box-card {
    margin-top: 50px;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 50px;
    float: left;
    width: 47%;
    position: absolute;
  }
  .box-card-2 {
    margin-top: 50px;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 50px;
    right: 0;
    float: right;
    width: 47%;
    position: absolute;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
</style>
