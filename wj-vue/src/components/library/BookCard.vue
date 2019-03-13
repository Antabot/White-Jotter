<template>
<div class="book">
  <div class="cover">
    <a href="#nowhere">
      <img src="https://img3.doubanio.com/view/subject/m/public/s29958602.jpg" alt="">
    </a>
  </div>
  <div class="info">
    <div class="title">
      <a href="">{{book.title}}</a>
    </div>
    <div class="author">余秀华</div>
  </div>
</div>
</template>

<script>
    export default {
      name: 'BookCard',
      methods: {
        loadEmps () {
          var _this = this
          this.$axios.get('/libraryindex/books').then(resp => {
            if (resp && resp.status === 200) {
              var data = resp.data
              _this.books = data.books
          }
        })
      }
      },
      data: function () {
        return {
          books: [],
          book: {
            cover: '',
            title: '',
            author: '',
            link: ''
          },
          rules: {
            cover: [{required: true, message: '必填:封面', trigger: 'blur'}],
            title: [{required: true, message: '必填:标题', trigger: 'blur'}],
            author: [{required: true, message: '必填:作者', trigger: 'blur'}]
          }
        }
      }
    }
</script>
<style scoped>
  .book {
  width: 115px;
  height: 220px;
}

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
  }

  img {
    width: 115px;
    height: 172px;
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
