<template>
  <div>
    <side-menu id="side-menu"></side-menu>
      <div class="home">
        <div id="header-div">
          <div style="height: 150px"></div>
          <carousel></carousel>
          <quick-nav style="float: right;margin-top: -450px;margin-right: 480px"></quick-nav>
        </div>
        <update-card id="update-card"></update-card>
        <slogan id="slogan"></slogan>
        <about id="about"></about>
      </div>
  </div>
</template>

<script>
  import Carousel from '@/components/home/Carousel'
  import QuickNav from '@/components/home/QuickNav'
  import Slogan from '@/components/home/Slogan'
  import About from '@/components/common/About'
  import UpdateCard from '@/components/home/UpdateCard'
  import SideMenu from '@/components/home/SideMenu'
  export default {
    name: 'AppIndex',
    components: {Carousel, QuickNav, Slogan, About, UpdateCard, SideMenu}
  }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;

  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
    /*background: url("../../assets/img/bg/bg3.jpg");*/
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -700px;
    top: 100px;
  }
</style>
