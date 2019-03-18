<template>
    <div>
      <carousel></carousel>
      <!--<tips></tips>-->
      <quick-nav></quick-nav>
      <slogan></slogan>
    </div>
</template>

<script>
  import Carousel from '@/components/home/Carousel'
  import QuickNav from '@/components/home/QuickNav'
  import Tips from '@/components/home/Tips'
  import Slogan from '@/components/home/Slogan'
  export default {
    name: 'AppIndex',
    components: {Carousel, QuickNav, Tips, Slogan}
  }
</script>

<style scoped>

</style>
