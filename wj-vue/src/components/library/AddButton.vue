<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog title="添加图书" :visible.sync="dialogFormVisible">
      <el-form :model="form" style="text-align: left">
        <el-form-item label="书名" :label-width="formLabelWidth">
          <el-input v-model="form.title" autocomplete="off" placeholder="不加《》"></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="formLabelWidth">
          <el-input v-model="form.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版日期" :label-width="formLabelWidth">
          <el-input v-model="form.date" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" :label-width="formLabelWidth">
          <el-input v-model="form.press" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="formLabelWidth">
          <el-input v-model="form.cover" autocomplete="off" placeholder="请输入 URL"></el-input>
        </el-form-item>
        <el-form-item label="简介" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="form.abs" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="功能完善中">
            <el-option label="分类一" value="shanghai"></el-option>
            <el-option label="分类二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: 'AddButton',
    data () {
      return {
        dialogFormVisible: false,
        form: {
          name: '',
          author: '',
          date: '',
          press: '',
          cover: '',
          abs: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
      }
    },
    mounted: {
    },
    methods: {
      onSubmit () {
        console.log('submit!')
        this.$axios
          .post('/library', {
            cover: this.form.cover,
            title: this.form.title,
            author: this.form.author,
            date: this.form.date,
            press: this.form.press,
            abs: this.form.abs
          }).then(resp => {
            if (resp && resp.status === 200) {
              this.dialogFormVisible = false
              this.$emit('onSubmit')
            }
        })
      }
    }
  }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>
