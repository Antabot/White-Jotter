<template>
  <div>
    <el-menu
      :default-active="'/admin/users'"
      class="el-menu-admin"
      router
      mode="vertical"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <div style="height: 80px;"></div>
      <!--<template v-for="(item,i) in navList">-->
        <!--index 没有用但是必需字段-->
        <!--<el-submenu :key="i" index="i + ''">-->
          <!--<span slot="title">测试</span>-->
          <!--<el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name" style="font-size: 18px">-->
            <!--<i :class="item.icon"></i>-->
            <!--{{ item.navItem }}-->
          <!--</el-menu-item>-->
        <!--</el-submenu>-->
      <!--</template>-->
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name" style="font-size: 18px">
        <i :class="item.icon"></i>
        {{ item.navItem }}
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
      name: 'AdminMenu',
      data () {
        return {
          navList: [
            {name: '/admin/users', navItem: '用户管理', icon: 'el-icon-user'},
            {name: '/admin/library', navItem: '图书管理', icon: 'el-icon-tickets'},
            {name: '/admin/news', navItem: '新闻管理', icon: 'el-icon-news'},
            {name: '/system', navItem: '系统设置', icon: 'el-icon-s-tools'}
          ],
          keywords: ''
        }
      }
    }
</script>

<style scoped>
  .el-menu-admin {
    height: 1200px;
    font-size: 30px;
    border-radius: 5px;
  }
</style>
