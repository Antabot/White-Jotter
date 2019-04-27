<template>
  <div>
    <el-row style="z-index: 1;">
      <Header style="position: absolute;width: 100%;"></Header>
    </el-row>
    <el-row style="z-index: 0;">
      <el-col style="width: 250px" >
        <admin-menu></admin-menu>
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
  }
</script>

<style scoped>

</style>
