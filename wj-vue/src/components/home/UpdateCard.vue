<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">最近更新</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <div class="block">
      <el-timeline>
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
        <el-timeline-item timestamp="2018/4/2" placement="top">
          <el-card>
            <h4>更新 Github 模板</h4>
            <p>王小虎 提交于 2018/4/2 20:46</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2018/4/3" placement="top">
          <el-card>
            <h4>更新 Github 模板</h4>
            <p>王小虎 提交于 2018/4/3 20:46</p>
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
