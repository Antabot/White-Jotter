<template>
  <!--此处的 id 虽然也名为 app，但与主 html 中含义不同-->
  <div id="app">
  <router-view/>
</div>
</template>
<script>

  import NavMenu from '@/components/common/NavMenu'
export default {
  name: 'App',
  components: {NavMenu}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 10px;
}
</style>
