<template>
  <div class="index-body">
    <div class="home">
      <carousel></carousel>
      <Card></Card>
      <!--<quick-nav></quick-nav>-->
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
    width: 960px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;

  }
  .index-body {
    background: url("../../assets/img/bg/4.jpg");
    /*background-size: cover;*/
    background-position: center;
  }
</style>
