<template>
    <div>
      <carousel></carousel>
      <tips></tips>
      <quick-nav></quick-nav>
    </div>
</template>

<script>
  import Carousel from '@/components/home/Carousel'
  import QuickNav from '@/components/home/QuickNav'
  import Tips from '@/components/home/Tips'
  export default {
    name: 'AppIndex',
    components: {Carousel, QuickNav, Tips}
  }
</script>

<style scoped>

</style>
