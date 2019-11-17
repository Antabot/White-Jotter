<template>
  <div>
    <el-row style="z-index: 1;">
      <Header style="position: absolute;width: 100%;"></Header>
    </el-row>
    <el-row style="z-index: 0;">
      <el-col :span="4" >
        <admin-menu></admin-menu>
      </el-col>
      <el-col :span="20" style="margin-top: 80px">
        <router-view/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import AdminMenu from './AdminMenu'
  import Header from './Header'

  export default {
    name: 'AdminIndex',
    components: {AdminMenu, Header}
    // 配置获取菜单方法
  }
</script>

<style scoped>

</style>
