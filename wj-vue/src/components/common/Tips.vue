<template>
    <div>
      <el-row>
        <el-col span="8">
          <Card></Card>
        </el-col>
        <el-col span="8">
          <Card></Card>
        </el-col>
        <el-col span="8">
          <Card></Card>
        </el-col>
      </el-row>
    </div>
</template>

<script>
  import Card from '@/components/common/Card'
  export default {
    name: 'Tips',
    components: {Card}
  }
</script>

<style scoped>

</style>
