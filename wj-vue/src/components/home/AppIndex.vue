<template>
    <div>
      <!--<nav-menu></nav-menu>-->
      <carousel></carousel>
      <tips></tips>
      <!--<Card></Card>-->
      <quick-nav></quick-nav>
    </div>
</template>

<script>
//  import NavMenu from '@/components/common/NavMenu'
  import Carousel from '@/components/common/Carousel'
  import QuickNav from '@/components/common/QuickNav'
  import Tips from '@/components/common/Tips'
//  import Card from '@/components/common/Card'
  export default {
    name: 'AppIndex',
    components: {Carousel, QuickNav, Tips}
  }
</script>

<style scoped>

</style>
