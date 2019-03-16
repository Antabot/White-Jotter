<template>
  <el-carousel :interval="4000" type="card" height="300px" arrow="always" style="padding: 20px 5px">
    <el-carousel-item v-for="item in items" :key="item" style="box-shadow: 10px 10px 5px #888888;">
      <a :href=item.link target="_Blank">
        <img :src=item.img alt="" class="carousel_img">
      </a>
      <h3>{{item.title}}</h3>
    </el-carousel-item>
  </el-carousel>
</template>

<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    /*line-height: 300px;*/
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background: linear-gradient(black, white);
  }

  .el-carousel__item:nth-child(2n+1) {
    background: linear-gradient(black, white);
  }

  .carousel_img {
    height: 280px;
    /*width: 300px;*/
    text-align: center;
  }
</style>

<script>
  export default {
    name: 'Carousel',
    data: function () {
      return {
        items: [{
          title: 'How2J.cn',
          img: '../../../static/img/carousel/how2j.png',
          link: 'http://how2j.cn?p=50613'},
        {
          title: 'Vue',
          img: '../../../static/img/carousel/vue.png',
          link: 'https://cn.vuejs.org/'
        },
        {
          title: 'element-ui',
          img: '../../../static/img/carousel/element.png',
          link: 'http://element-cn.eleme.io/#/zh-CN'
        }]
      }
    }
  }
</script>
