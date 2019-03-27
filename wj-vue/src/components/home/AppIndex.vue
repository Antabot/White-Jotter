<template>
    <div style="width: 100%;margin-left: auto;margin-right: auto;">
      <carousel></carousel>
      <quick-nav></quick-nav>
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
  export default {
    name: 'AppIndex',
    components: {Carousel, QuickNav, Tips, Slogan, Footer}
  }
</script>

<style scoped>

</style>
