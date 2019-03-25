<template>
    <div style="width: 1300px;margin-left: auto;margin-right: auto;background-color: #FAF9DE">
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
