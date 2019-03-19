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
    <el-tooltip effect="dark" placement="right" v-for="(item,index) in books" :key="item.id"
                v-loading="cardLoading[index]">
      <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>
      <p slot="content"  style="font-size: 13px;margin-bottom: 6px">
        <span>{{item.author}}</span> /
        <span>{{item.date}}</span> /
        <span>{{item.press}}</span>
      </p>
      <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>
      <el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;margin-right: 3px" class="book" bodyStyle="padding:10px" shadow="hover">
        <div class="cover">
          <a href="">
            <img :src="item.cover" alt="">
          </a>
        </div>
        <div class="info">
          <div class="title">
            <a href="">{{item.title}}</a>
          </div>
          <div class="author">{{item.author}}</div>
        </div>
      </el-card>
    </el-tooltip>
    <!--测试内容-->
    <!--<el-tooltip effect="dark"  placement="right" enterable="false">-->
      <!--<p slot="content" style="font-size: 14px;margin-bottom: 6px;">且在人间</p>-->
      <!--<p slot="content"  style="font-size: 13px;margin-bottom: 6px">-->
        <!--<span>余秀华</span> /-->
        <!--<span>2019-3-15</span> /-->
        <!--<span>人民邮电出版社</span>-->
      <!--</p>-->
      <!--<p slot="content" style="width: 300px" class="abstract">简介</p>-->
  <!--<el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;margin-right: 3px" class="book" bodyStyle="padding:10px"-->
           <!--shadow="hover">-->
    <!--<div class="cover">-->
      <!--<a href="">-->
        <!--<img src="../../assets/img/books/s29958602.jpg" alt="">-->
      <!--</a>-->
    <!--</div>-->
    <!--<div class="info">-->
      <!--<div class="title">-->
        <!--<a href="">且在人间</a>-->
      <!--</div>-->
      <!--<div class="author">余秀华</div>-->
    <!--</div>-->
  <!--</el-card>-->
    <!--</el-tooltip>-->
  </div>
</template>

<script>

    export default {
      name: 'BookCard',
      mounted: function () {
        this.loadBooks()
      },
      methods: {
        loadBooks () {
          var _this = this
          this.$axios.get('/library').then(resp => {
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
    /*margin: 0 auto;*/
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

  .abstract {
    display: block;
    line-height: 17px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }

</style>
