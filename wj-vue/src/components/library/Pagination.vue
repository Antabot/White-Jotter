<template>
  <el-pagination
    :page-size="20"
    :pager-count="11"
    layout="prev, pager, next"
    :total="1000">
  </el-pagination>
</template>

<script>
    export default {
        name: 'Pagination'
    }
</script>

<style scoped>

</style>
