<template>
  <div>
    <el-menu
      :default-active="'/appindex'"
      router="true"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <span style="float: right;padding: 20px"><a href="#nowhere" style="color: #fff">登录/注册</a></span>
      <i class="el-icon-menu" style="float:right;font-size: 45px;color: aliceblue;padding-top: 8px"></i>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/appindex', navItem: '首页'},
          {name: '/jotterindex', navItem: '笔记本'},
          {name: '/libraryindex', navItem: '图书馆'},
          {name: '#nowhere', navItem: '个人中心'}
        ]
      }
    },
    methods: {
      handleSelect (key, keyPath) {
        console.log(key, keyPath)
      }
    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }
</style>
