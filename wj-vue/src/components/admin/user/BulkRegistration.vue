<template>
  <div style="text-align: left">
    <el-button class="add-button" type="success" @click="dialogFormVisible = true">批量添加用户</el-button>
    <el-dialog
      title="添加用户"
      :visible.sync="dialogFormVisible"
      @close="clear"
      width="25%">
      <el-form :model="loginForm" :rules="rules" label-position="left"
               label-width="0px">
        <el-form-item prop="username">
          <el-input type="text" v-model="loginForm.username"
                    auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" v-model="loginForm.password"
                    auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="text" v-model="loginForm.name"
                    auto-complete="off" placeholder="真实姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="text" v-model="loginForm.phone"
                    auto-complete="off" placeholder="电话号码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="text" v-model="loginForm.email"
                    auto-complete="off" placeholder="E-Mail"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">添加</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
    export default {
        name: 'BulkRegistration',
      data () {
        return {
          dialogFormVisible: false,
          rules: {
            username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
            password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
          },
          loginForm: {
            username: '',
            password: '',
            name: '',
            phone: '',
            email: ''
          }
        }
      },
      methods: {
        clear () {
          this.loginForm = {
            username: '',
            password: '',
            name: '',
            phone: '',
            email: ''
          }
        },
        register () {
          this.$axios
            .post('/register', {
              username: this.loginForm.username,
              password: this.loginForm.password,
              name: this.loginForm.name,
              phone: this.loginForm.phone,
              email: this.loginForm.email
            })
            .then(resp => {
              if (resp.data.code === 200) {
                this.$alert('注册成功', '提示', {
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
        }
      }
    }
</script>

<style scoped>
  .add-button {
    margin: 18px 0 0 10px;
  }
</style>
