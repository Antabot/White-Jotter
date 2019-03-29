<template>
  <el-carousel  class="push" :interval="4000" arrow="always">
    <el-carousel-item v-for="item in items" :key="item">
      <a :href=item.link target="_blank">
        <img :src=item.img alt="" class="carousel_img">
      </a>
      <h3>{{item.title}}</h3>
    </el-carousel-item>
  </el-carousel>
</template>

<style>
  .el-carousel__item h3 {
    color: #375669;
    font-size: 14px;
    /*line-height: 300px;*/
    margin: 0px;
  }

  .push {
    padding:20px 0;
    width: 900px;
    height: 373px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 20px;
  }

  .el-carousel__item:nth-child(2n) {
    background: linear-gradient(black, gainsboro);
  }

  .el-carousel__item:nth-child(2n+1) {
    background: linear-gradient(black,gainsboro);
  }

  .carousel_img {
    height: 92%;
    width: 100%;
    text-align: center;
  }
</style>

<script>
  export default {
    name: 'Carousel',
    data: function () {
      return {
        items: [{
          title: 'How2J.cn - Java 全栈学习网站',
          img: '../../../static/img/carousel/how2j.png',
          link: 'http://how2j.cn?p=50613'},
        {
          title: 'Vue.js - 渐进式 JavaScript 框架',
          img: '../../../static/img/carousel/vue.png',
          link: 'https://cn.vuejs.org/'
        },
        {
          title: 'element-ui - 网站快速成型工具',
          img: '../../../static/img/carousel/element.png',
          link: 'http://element-cn.eleme.io/#/zh-CN'
        }]
      }
    }
  }
</script>
