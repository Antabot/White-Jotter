<template>
  <el-container>
    <el-container>
      <el-aside style="width: 200px;margin-top: 20px">
        <SideMenu></SideMenu>
      </el-aside>
      <el-container>
        <el-main>
          <el-row>
            <el-col :span="24" style="width: 100%;text-align: left;line-height: 100%;height: 40px"><Tag></Tag></el-col>
          </el-row>
          <el-row>
            <el-col :span="12"><BookCard></BookCard></el-col>
            <el-col :span="12"><BookCard></BookCard></el-col>
          </el-row>
        </el-main>
      <el-footer>
        <Pagination></Pagination>
      </el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
    import SideMenu from './SideMenu'
    import Tag from './Tag'
    import Pagination from './Pagination'
    import BookCard from './BookCard'
    export default {
        name: 'AppLibrary',
      components: {BookCard, Pagination, Tag, SideMenu}
    }
</script>

<style scoped>
  .el-header {
    color: #333;
    text-align: center;
  }

  .el-aside {
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    color: #333;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }
</style>
