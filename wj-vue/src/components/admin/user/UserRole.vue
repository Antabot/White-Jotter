<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>角色配置</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="roles"
        stripe
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="id"
          label="id"
          width="100">
        </el-table-column>
        <el-table-column
          prop="name"
          label="角色名"
          fit>
        </el-table-column>
        <el-table-column
          prop="nameZh"
          label="角色描述"
          fit>
        </el-table-column>
        <el-table-column
          label="状态"
          width="100">
          <template slot-scope="scope">
            <el-switch
              v-model="scope.row.enabled"
              active-color="#13ce66"
              inactive-color="#ff4949"
              @click.native="beforeUpdate"
              @change="(value) => commitChange(value, scope.row)">
            </el-switch>
          </template>
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
      <div style="margin: 20px 0 20px 0;float: left">
        <el-button>取消选择</el-button>
        <el-button>批量删除</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'UserRole',
    data () {
      return {
        roles: []
      }
    },
    mounted () {
      this.listRoles()
    },
    computed: {
      tableHeight () {
        return window.innerHeight - 320
      }
    },
    methods: {
      listRoles () {
        var _this = this
        this.$axios.get('/admin/role').then(resp => {
          if (resp && resp.status === 200) {
            _this.roles = resp.data
          }
        })
      },
      beforeUpdate () {
      },
      commitChange (value, role) {
        if (role.id !== 1) {
          this.$confirm('是否更改角色状态？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$axios.put('/admin/role', {
              enabled: value,
              id: role.id
            }).then(resp => {
              if (resp && resp.status === 200) {
                if (value) {
                  this.$message('角色 [' + role.nameZh + '] 已启用')
                } else {
                  this.$message('角色 [' + role.nameZh + '] 已禁用')
                }
              }
            })
          }).catch(() => {
            role.enabled = !role.enabled
            this.$message({
              type: 'info',
              message: '已取消'
            })
          })
        } else {
          role.enabled = true
          this.$alert('无法禁用系统管理员！')
        }
      }
    }
  }
</script>

<style scoped>

</style>
