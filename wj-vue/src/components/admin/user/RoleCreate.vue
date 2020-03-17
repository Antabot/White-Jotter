<template>
  <div style="text-align: left">
    <el-button class="add-button" type="success" @click="dialogFormVisible = true">添加角色</el-button>
    <el-dialog
      title="添加角色"
      :visible.sync="dialogFormVisible"
      @close="clear"
      width="25%">
      <el-form :model="roleForm" :rules="rules" label-position="left"
               label-width="0px" v-loading="loading">
        <el-form-item prop="name">
          <el-input type="text" v-model="roleForm.name"
                    auto-complete="off" placeholder="角色名"></el-input>
        </el-form-item>
        <el-form-item prop="nameZh">
          <el-input type="text" v-model="roleForm.nameZh"
                    auto-complete="off" placeholder="角色描述"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="createRole">添加</el-button>
        </el-form-item>
        <el-form-item prop="username">
          <el-tag>初始权限：无</el-tag>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: 'RoleCreate',
    data () {
      return {
        dialogFormVisible: false,
        rules: {
          name: [{required: true, message: '角色名不能为空', trigger: 'blur'}]
        },
        checked: true,
        roleForm: {
          name: '',
          nameZh: ''
        },
        loading: false
      }
    },
    methods: {
      clear () {
        this.roleForm = {
          name: '',
          nameZh: ''
        }
      },
      createRole () {
        this.$axios
          .post('/admin/role', {
            name: this.roleForm.name,
            nameZh: this.roleForm.nameZh
          })
          .then(resp => {
            if (resp.data.code === 200) {
              this.$alert(resp.data.result, '提示', {
                confirmButtonText: '确定'
              })
              this.clear()
              this.$emit('onSubmit')
            } else {
              this.$alert(resp.data.message, '提示', {
                confirmButtonText: '确定'
              })
            }
          })
          .catch(failResponse => {})
        this.dialogFormVisible = false
      }
    }
  }
</script>

<style scoped>
  .add-button {
    margin: 18px 0 0 10px;
  }
</style>
