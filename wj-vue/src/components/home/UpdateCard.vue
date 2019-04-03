<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">最近更新</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <div class="block">
      <el-timeline>
        <el-timeline-item timestamp="2019/4/3" placement="top">
          <el-card>
            <h4>实现图书添加功能与无空白刷新页面</h4>
            <p>Evan 提交于 2019/4/3 21:34</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/4/2" placement="top">
          <el-card>
            <h4>完善后端拦截器，使用图床存放静态图片，修改图书馆模块</h4>
            <p>Evan 提交于 2019/4/2 22:12</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/4/2" placement="top">
          <el-card>
            <h4>重构部分代码</h4>
            <p>Evan 提交于 2019/4/1 09:19</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/3/31" placement="top">
          <el-card>
            <h4>更新 README.md</h4>
            <p>Evan 提交于 2019/3/31 09:19</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/3/30" placement="top">
          <el-card>
            <h4>完善左侧导航</h4>
            <p>Evan 提交于 2019/3/30 21:59</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/3/30" placement="top">
          <el-card>
            <h4>更新首页布局</h4>
            <p>Evan 提交于 2019/3/30 21:23</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: 'Card'
  }
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 1050px;
    text-align: left;
  }
</style>
