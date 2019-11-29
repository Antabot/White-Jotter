<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="books"
        stripe
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          prop="id"
          label="选择"
          width="150">
        </el-table-column>
        <el-table-column
          fixed
          prop="title"
          label="id"
          width="100">
        </el-table-column>
        <el-table-column
          prop="category.name"
          label="用户名"
          width="100">
        </el-table-column>
        <el-table-column
          prop="author"
          label="真实姓名"
          width="150">
        </el-table-column>
        <el-table-column
          prop="date"
          label="手机号"
          width="120">
        </el-table-column>
        <el-table-column
          prop="press"
          label="出版社"
          width="180">
        </el-table-column>
        <el-table-column
          prop="abs"
          label="状态"
          width="100">
        </el-table-column>
        <el-table-column
          label="操作"
          width="120">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="editBook(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
            <el-button
              @click.native.prevent="deleteBook(scope.row.id)"
              type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
    export default {
        name: 'UserProfile'
    }
</script>

<style scoped>

</style>
