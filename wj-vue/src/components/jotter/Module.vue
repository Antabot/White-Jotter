<template>
    <div>
      <a href="/editor" class="module">
        <img src="../../assets/img/icon/icon1.png" alt="">
        <span class="sub-name">[HelloWorld]</span>
        <br>
        <br>
        <br>
        <span class="desc">开启程序人生！</span>
      </a>
    </div>
</template>

<script>
  export default {
    name: 'Module'
  }
</script>

<style scoped>
  a.module {
    display: block;
    width: 280px;
    height: 150px;
    margin: 30px;
    padding: 15px;
    background-color: #DCDFE6;
    float: left;
    border-radius: 18px;
    position: relative;
    text-decoration: none;
    font-family: "PingFang SC";
    color: rgb(84, 92, 100);

  }
  a.module img {
    float: left;
  }
  span.sub-name {
    float: right;
    font-size: 20px;
  }
  span.desc {
   font-size: 20px;
  }
</style>
