<template>
  <div>
    <el-row>
      <Header></Header>
    </el-row>
    <el-row>
      <el-col :span="4">
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
