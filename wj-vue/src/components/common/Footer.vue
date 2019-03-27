<template>
  <div class="footer">
    <!--<div class="alt">-->
      <!--<div class="foot">-->
        <!--<p>关于我们</p>-->
        <!--<a href="###">企业简介</a>-->
        <!--<a href="###">企业文化</a>-->

      <!--</div>-->
      <!--<div class="foot">-->
        <!--<p>新闻中心</p>-->
        <!--<a href="###">公司新闻</a>-->
        <!--<a href="###">行业新闻</a>-->
      <!--</div>-->
      <!--<div class="foot">-->
        <!--<p>产品及解决方案</p>-->
        <!--<a href="###">产品系列</a>-->
        <!--<a href="###">解决方案</a>-->
      <!--</div>-->
      <!--<div class="foot">-->
        <!--<p>研发与创新</p>-->
        <!--<a href="###">核心技术</a>-->
        <!--<a href="###">技术创新</a>-->
      <!--</div>-->
      <!--<div class="foot">-->
        <!--<p>经典案例</p>-->
        <!--<a href="###">智慧城市</a>-->
        <!--<a href="###">智慧高速</a>-->
      <!--</div>-->
      <!--<div class="foot">-->
        <!--<p>服务支持</p>-->
        <!--<a href="###">技术支持</a>-->
        <!--<a href="###">服务网络</a>-->
      <!--</div>-->
      <!--<div class="foot" style="margin-top: -10px">-->
        <!--<img src="http://placehold.it/60x60" />-->
      <!--</div>-->
    <!--</div>-->
    <div style="border-top:1px #1F1F1F solid;">
      <p class="alt" style="color:#999; line-height:0;">&copy; 版权所有：Evan-Nightly &nbsp;
        <span>技术支持：</span>
        <a href="###" target="_blank" style="color:#999;">Evan & MMK</a>
        <span style="float:right;">联系方式：Evan_Nightly@163.com</span>
      </p>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Footer'
  }
</script>

<style scoped>

  /*通用开始*/

  * {
    margin: 0;
    padding: 0;
    font-family: '微软雅黑', Arial, Helvetica, sans-serif;
  }

  a {
    text-decoration: none;
  }

  img {
    border: none;
  }

  li {
    list-style: none;
  }

  body {
    font-size: 12px;
  }

  div {
    font-size: 12px;
  }

  span {
    font-size: 12px;
  }
  /*通用结束*/

  .footer {
    background: #2b2e33;
    /*background: black;*/
  }

  .footer .alt {
    overflow: hidden;
    padding: 20px 0;
    width: 1160px;
    margin: auto;
  }

  .footer .alt .foot {
    width: 138px;
    float: left;
  }

  .footer .alt .foot p {
    color: #FFF;
    line-height: 28px;
  }

  .footer .alt .foot a {
    color: #999;
    display: block;
    line-height: 24px;
  }

  .footer .alt .foot a:hover {
    color: #CCC;
  }

  .footer .alt .foot img {
    padding-top: 20px;
  }
</style>
