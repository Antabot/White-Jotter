<template>
  <div>
    <nav-menu></nav-menu>
    <router-view/>
  </div>
</template>
<script>

  import NavMenu from '@/components/common/NavMenu'
  export default {
    components: {NavMenu}
  }
</script>

<style>

</style>
