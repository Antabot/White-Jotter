<template>
    <div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>学科名称</span>
          <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'待学内容 ' + o }}
        </div>
      </el-card>
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

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
</style>
