<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <el-row>
        <books class="books-area" ref="booksArea"></books>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  import SideMenu from './SideMenu'
  import Tag from './Tag'
  import Books from './Books'
  import About from '../common/About'

  export default {
    name: 'AppLibrary',
    components: {Books, Tag, SideMenu, About},
    methods: {
      listByCategory () {
        var _this = this
        var cid = this.$refs.sideMenu.cid
        var url = 'categories/' + cid + '/books'
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.$refs.booksArea.books = resp.data
          }
        })
      }
    }
  }
</script>

<style scoped>
  .books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
