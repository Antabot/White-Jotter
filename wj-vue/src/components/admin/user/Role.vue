<template>
  <div>
    <el-dialog
      title="修改角色信息"
      :visible.sync="dialogFormVisible">
      <el-form v-model="selectedRole" style="text-align: left" ref="dataForm">
        <el-form-item label="角色名" label-width="120px" prop="username">
          <el-input v-model="selectedRole.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色描述" label-width="120px" prop="name">
          <el-input v-model="selectedRole.nameZh" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="功能配置" label-width="120px" prop="perms">
          <el-checkbox-group v-model="selectedPerms">
            <el-checkbox v-for="(perm,i) in perms" :key="i" :label="perm.id">{{perm.desc_}}</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="菜单配置" label-width="120px" prop="menus">
          <el-checkbox-group v-model="selectedMenus">
            <el-checkbox v-for="(menu,i) in menus" :key="i" :label="perm.id">{{menu.nameZh}}</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit(selectedRole)">确 定</el-button>
      </div>
    </el-dialog>
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
              @change="(value) => commitStatusChange(value, scope.row)">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column
          label="操作"
          width="120">
          <template slot-scope="scope">
            <el-button
              type="text"
              size="small"
              @click="editRole(scope.row)">
              编辑
            </el-button>
            <el-button
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
        dialogFormVisible: false,
        roles: [],
        perms: [],
        menus: [],
        selectedRole: [],
        selectedPerms: [],
        selectedMenus: []
      }
    },
    mounted () {
      this.listRoles()
      this.listPerms()
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
      listPerms () {
        var _this = this
        this.$axios.get('/admin/perm').then(resp => {
          if (resp && resp.status === 200) {
            _this.perms = resp.data
          }
        })
      },
      commitStatusChange (value, role) {
        if (role.id !== 1) {
          this.$confirm('是否更改角色状态？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$axios.put('/admin/role/status', {
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
      },
      onSubmit (role) {
        let _this = this
        // 根据视图绑定的角色 id 向后端传送角色信息
        let perms = []
        for (let i = 0; i < _this.selectedPerms.length; i++) {
          for (let j = 0; j < _this.perms.length; j++) {
            if (_this.selectedPerms[i] === _this.perms[j].id) {
              perms.push(_this.perms[j])
            }
          }
        }
        this.$axios.put('/admin/role', {
          id: role.id,
          name: role.name,
          nameZh: role.nameZh,
          enabled: role.enabled,
          perms: perms
        }).then(resp => {
          if (resp && resp.status === 200) {
            this.$alert(resp.data.data)
            this.dialogFormVisible = false
            this.listRoles()
          }
        })
      },
      editRole (role) {
        this.dialogFormVisible = true
        this.selectedRole = role
        let permIds = []
        for (let i = 0; i < role.perms.length; i++) {
          permIds.push(role.perms[i].id)
        }
        this.selectedPerms = permIds
      }
    }
  }
</script>

<style scoped>

</style>
