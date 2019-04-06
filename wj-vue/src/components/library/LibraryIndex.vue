<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
        <SideMenu></SideMenu>
    </el-aside>
    <el-main>
      <el-row>
        <!--<el-col :span="24" style="width: 100%;text-align: left;line-height: 100%;height: 40px"><Tag></Tag></el-col>-->
      </el-row>
      <el-row>
        <books></books>
      </el-row>
      <el-row>
        <!--<pagination></pagination>-->
      </el-row>
    </el-main>
      <!--<el-footer>-->
        <!--<Pagination></Pagination>-->
      <!--</el-footer>-->
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

</style>
