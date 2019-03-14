<template>
  <div>
    <div style="margin-bottom: 10px;display: flex;justify-content: center;align-items: center">
      <el-input
        placeholder="默认展示部分书籍，可以通过书名搜索更多书籍..."
        prefix-icon="el-icon-search"
        size="small"
        style="width: 400px;margin-right: 10px"
        v-model="keywords">
      </el-input>
      <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>
    </div>
<el-card style="width: 135px;margin-bottom: 20px;height: 233px" class="book" bodyStyle="padding:10px" v-for="(item,index) in books" :key="item.id"
         v-loading="cardLoading[index]">
  <div class="cover">
    <a href="/details?id='{{item.id}}'">
      <img :src="item.cover" alt="">
    </a>
  </div>
  <div class="info">
    <div class="title">
      <a href="/details?id='{{item.id}}'">{{item.title}}</a>
    </div>
    <div class="author">{{item.author}}</div>
  </div>
</el-card>
  </div>
</template>

<script>
//    import ElCard from "../../../node_modules/element-ui/packages/card/src/main.vue";

    export default {
      name: 'BookCard',
      mounted: function () {
        this.loadBooks()
      },
      methods: {
        loadBooks () {
          var _this = this
          this.$axios.get('/libraryindex').then(resp => {
            if (resp && resp.status === 200) {
              _this.books = resp.data
              var length = resp.data.length
              _this.cardLoading = Array.apply(null, Array(length)).map(function (item, i) {
                return false
              })
            }
          })
        }
      },

        data: function () {
          return {
            books: [],
            cardLoading: [],
            keywords: ''
//            book: {
//              cover: '',
//              title: '',
//              author: '',
//              link: ''
//            },
//            rules: {
//              cover: [{required: true, message: '必填:封面'}],
//              title: [{required: true, message: '必填:标题'}],
//              author: [{required: true, message: '必填:作者'}]
//            }
          }
        }
      }
</script>
<style scoped>

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
  }

  img {
    width: 115px;
    height: 172px;
    margin: 0 auto;
  }

  .title {
    font-size: 14px;
    text-align: left;
  }

  .author {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }
</style>
