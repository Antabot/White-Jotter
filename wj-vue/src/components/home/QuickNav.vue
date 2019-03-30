<template>
    <div class="quick-nav">
      <img src="../../assets/img/icon/icon2.png" alt="" class="monster">
      <!--<img src="../../assets/img/icon/icon5.png" alt="" class="readme">-->
      <img src="../../assets/img/icon/icon7.png" alt="">
    </div>
</template>

<script>
  export default {
    name: 'QuickNav'
  }
</script>

<style scoped>
  .quick-nav {
    width: 303px;
    height: 318px;
    background-color: transparent;
  }

  .monster {
    width: 280px;
    height: 260px;
    /*position: absolute;*/
    top: 150px;
    left: 700px;
  }

  .readme {
    width: 180px;
    height: 170px;
    /*position: absolute;*/
    top: 200px;
    left: 400px;
  }

</style>
