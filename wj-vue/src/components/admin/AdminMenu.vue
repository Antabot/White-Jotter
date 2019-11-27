<template>
    <el-menu
      :default-active="currentPath"
      class="el-menu-admin"
      router
      @select="handleSelect"
      mode="vertical"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <div style="height: 80px;"></div>
        <!--index 没有用但是必需字段-->
        <el-submenu  v-for="(item,i) in adminMenus" :key="i" :index="(i).toString()" style="text-align: left">
          <span slot="title" style="font-size: 17px;">
            <i :class="item.iconCls"></i>
            {{item.nameZh}}
          </span>
          <el-menu-item v-for="child in item.children" :key="child.path" :index="child.path">
            <i :class="child.icon"></i>
            {{ child.nameZh }}
          </el-menu-item>
        </el-submenu>
    </el-menu>
</template>

<script>
    export default {
      name: 'AdminMenu',
      data () {
        return {
          // currentPath: this.$route.path
        }
      },
      computed: {
        adminMenus () {
          return this.$store.state.adminMenus
        },
        currentPath () {
          return this.$route.path
        }
      },
      methods: {
        handleSelect (key, keyPath) {
          console.log(this)
        }
      }
    }
</script>

<style scoped>
  .el-menu-admin {
    height: 1000px;
    border-radius: 5px;
  }
</style>
