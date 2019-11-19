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
      <template v-for="(item,i) in adminMenus">
        <!--index 没有用但是必需字段-->
        <el-submenu :key="i" :index="i + ''" style="text-align: left">
          <span slot="title" style="font-size: 17px;">
            <i :class="item.iconCls"></i>
            {{item.nameZh}}
          </span>
          <el-menu-item v-for="child in item.children" :key="child.path" :index="child.path">
            <i :class="child.icon"></i>
            {{ child.nameZh }}
          </el-menu-item>
        </el-submenu>
      </template>
    </el-menu>
  </div>
</template>

<script>
    export default {
      name: 'AdminMenu',
      computed: {
        adminMenus () {
          return this.$store.state.adminMenus
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
