<template>
  <el-pagination
    background
    layout="prev, pager, next"
    :current-page="currentPage"
    :page-size="pagesize"
    :total="total"
    @current-change="handleCurrentChange">
  </el-pagination>
</template>

<script>
    export default {
      name: 'Pagination',
      data () {
        return {
          currentPage: 1,
          pagesize: 2,
          total: ''
        }
      },
      methods: {
        handleCurrentChange: function (currentPage) {
          this.currentPage = currentPage
          console.log(this.currentPage)
        }
      }
    }
</script>

<style scoped>

</style>
