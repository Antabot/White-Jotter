<template>
  <div style="text-align: left">
    <el-card class="vote-header">
      <a href="#nowhere">
        <img src="../../assets/img/icon/icon2.png" alt="" width="55px" style="float: left;margin-top: -5px;">
      </a>
      <span style="font-size: 32px;font-weight: bold;position:absolute;left: 100px">投票系统</span>
      <i class="el-icon-switch-button" style="font-size: 40px;float: right;color: #ff0721"></i>
      <el-tooltip class="item" effect="dark" content="点击图片可查看大图，每个账号可为每类作品投两票，且不能投给相同单位" placement="right">
      <i class="el-icon-question" style="font-size: 20px;font-weight: bold;position:absolute;left: 230px"></i>
      </el-tooltip>
    </el-card>
    <el-menu
      class="categories"
      default-active="0"
      @select="handleSelect"
      active-text-color="red">
      <el-menu-item index="0">
        <i class="el-icon-menu"></i>
        <span slot="title">书法作品</span>
      </el-menu-item>
      <el-menu-item index="1">
        <i class="el-icon-menu"></i>
        <span slot="title">绘画作品</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">摄影作品</span>
      </el-menu-item>
    </el-menu>
    <div style="margin-left: 200px">
        <el-card class="block-card" v-for="src in srcList" :key="src">
          <el-image
            style="width: 150px; height: 150px"
            :src="src"
            :fit="fit"
            :preview-src-list="src.split(',')"></el-image>
          <el-button type="primary" round style="margin-top: 17px">投一票</el-button>
        </el-card>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'Vote',
    data () {
      return {
        fit: 'cover',
        url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        srcList: [
          'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
        ],
        list: []
      }
    },
    methods: {}
  }
</script>

<style scoped>
  .block-card {
    /*width: 135px;*/
    margin: 20px 15px 20px 0px;
    height: 250px;
    width: 200px;
    float: left;
    text-align: center;
  }
  .vote-header {
    height: 80px;
    opacity: 0.85;
    line-height: 40px;
  }

  .categories {
    position: fixed;
    margin-left: 50%;
    left: -610px;
    top: 150px;
    width: 150px;
  }
</style>
