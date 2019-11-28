<template>
  <body id="admin-body">
    <el-row style="z-index: 1;">
      <Header style="position: absolute;width: 100%;"></Header>
    </el-row>
    <el-row style="height: 100%;">
      <el-col :span="4" style="height: 100%">
        <admin-menu></admin-menu>
      </el-col>
      <el-col :span="20" style="margin-top: 80px;height: 90%;">
        <router-view/>
      </el-col>
    </el-row>
  </body>
</template>

<script>
  import AdminMenu from './AdminMenu'
  import Header from './Header'

  export default {
    name: 'AdminIndex',
    components: {AdminMenu, Header},
    data () {
      return {
        dialogVisible: false
      }
    }
    // 配置获取菜单方法
  }
</script>

<style scoped>
  #admin-body {
  height: 100vh;
}
</style>
