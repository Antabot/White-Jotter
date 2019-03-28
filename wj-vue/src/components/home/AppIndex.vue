<template>
    <div style="width: 100%;margin-left: auto;margin-right: auto;">
      <carousel></carousel>
      <Card></Card>
      <!--<quick-nav></quick-nav>-->
      <slogan></slogan>
      <Footer></Footer>
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
</style>
