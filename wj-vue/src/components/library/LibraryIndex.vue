<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
        <SideMenu></SideMenu>
    </el-aside>
    <el-main>
      <el-row>
        <books class="books-area"></books>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
    import SideMenu from './SideMenu'
    import Tag from './Tag'
    import Pagination from './Pagination'
    import Books from './Books'
    export default {
        name: 'AppLibrary',
      components: {Books, Pagination, Tag, SideMenu}
    }
</script>

<style scoped>
  .books-area {
    width: 1540px;
  }
</style>
