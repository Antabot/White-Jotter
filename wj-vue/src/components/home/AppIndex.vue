<template>
  <div class="index-body">
    <div class="home">
      <div class="header-div">
      <div style="height: 150px"></div>
      <carousel></carousel>
      <quick-nav style="float: right;margin-top: -450px;margin-right: 480px"></quick-nav>
      </div>
      <Card></Card>
      <slogan></slogan>
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
  import Carousel from '@/components/home/Carousel'
  import QuickNav from '@/components/home/QuickNav'
  import Tips from '@/components/home/Tips'
  import Slogan from '@/components/home/Slogan'
  import Footer from '@/components/common/Footer'
  import Card from '@/components/home/Card'
  export default {
    name: 'AppIndex',
    components: {Carousel, QuickNav, Tips, Slogan, Footer, Card}
  }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;

  }
  .index-body {
    background: url("../../assets/img/bg/4.jpg");
    /*background-size: cover;*/
    background-position: center;
  }

  .header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: #ffe55c;
    background: url("../../assets/img/bg/bg4.jpg");
  }
</style>
