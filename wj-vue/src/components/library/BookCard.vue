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
      <el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;margin-right: 15px" class="book" bodyStyle="padding:10px" shadow="hover">
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
    <i class="el-icon-circle-plus-outline" @click="open"></i>
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
        },
        testFunc () {
          alert('hello')
        },
        open () {
          const h = this.$createElement
          this.$msgbox({
            title: '添加内容',
            message: h('p', {style: 'width: 60px'}, [
              h('span', {style: 'color: teal'}, '书名'),
              h('input', null),
              h('br'),
              h('span', null, '作者'),
              h('input', null)
            ]),
            showCancelButton: true,
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            beforeClose: (action, instance, done) => {
              if (action === 'confirm') {
                instance.confirmButtonLoading = true
                instance.confirmButtonText = '执行中...'
                setTimeout(() => {
                  done()
                  setTimeout(() => {
                    instance.confirmButtonLoading = false
                  }, 300)
                }, 3000)
              } else {
                done()
              }
            }
          }).then(action => {
            this.$message({
              type: 'info',
              message: 'action: ' + action
            })
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

  .el-icon-circle-plus-outline {
    margin: 50px 0;
    font-size: 100px;
    float: left;
    cursor:pointer;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }

</style>
