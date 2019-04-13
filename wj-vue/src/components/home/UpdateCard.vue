<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">最近更新</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <div class="block">
      <el-timeline>
        <el-timeline-item timestamp="2019/4/13" placement="top">
          <el-card>
            <h4>实现上传至服务器和输入 URL 两种方式添加封面</h4>
            <p>Evan 提交于 2019/4/13 21:32</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/4/11" placement="top">
          <el-card>
            <h4>实现图书分类功能</h4>
            <p>Evan 提交于 2019/4/11 09:02</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/4/8" placement="top">
          <el-card>
            <h4>实现图书分页，修复图书添加的 BUG</h4>
            <p>Evan 提交于 2019/4/8 22:10</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/4/6" placement="top">
          <el-card>
            <h4>实现搜索框模糊查询</h4>
            <p>Evan 提交于 2019/4/6 19:51</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/4/5" placement="top">
          <el-card>
            <h4>实现图书修改功能</h4>
            <p>Evan 提交于 2019/4/5 22:52</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: 'UpdateCard'
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
