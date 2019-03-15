<template>
  <el-carousel :interval="4000" type="card" height="300px">
    <el-carousel-item v-for="item in items" :key="item">
      <h3>{{item.title}}</h3>
      <!--<a href="">-->
        <!--<img :src=item.src alt="">-->
      <!--</a>-->
    </el-carousel-item>
  </el-carousel>
</template>

<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>

<script>
  export default {
    name: 'Carousel',
    mounted: function () {
      this.setItems()
    },
    methods: {
      setItem (title, img, link) {
        var item
        item.title = title
        item.img = img
        item.link = link
        return item
      },
      setItems () {
        var item1, item2, item3
//        item1 = this.setItem('How2J 学习网站', 'src1', 'link1')
//        item2 = this.setItem('Vue', 'src2', 'link2')
//        item3 = this.setItem('Element-ui', 'src3', 'link3')
//        item1 = {
//          title: 'How2J 学习网站',
//          img: 'src1',
//          link: 'link1'}
        item2 = ['Vue', 'src2', 'link2']
        item3 = ['Element-ui', 'src3', 'link3']
        this.items = [item1, item2, item3]
      }
    },
    data: function () {
      return {
        items: [{
          title: 'How2J 学习网站',
          img: 'src1',
          link: 'link1'},
        {
          title: 'Vue',
          img: 'src1',
          link: 'link1'
        },
        {
          title: 'element-ui',
          img: 'src1',
          link: 'link1'
        }]
      }
    }
  }
</script>
