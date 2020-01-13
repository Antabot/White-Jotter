<template>
  <div id="main">
    <mavon-editor
      v-model="value"
      style="height: 100%;width: 100%;position: fixed"
      ref=md
      @save="saveArticles(value, render)"
      fontSize="20px"/>
  </div>
</template>

<script>
  export default {
    name: 'Editor',
    data () {
      return {
        value: ''
      }
    },
    methods: {
      saveArticles (value, render) {
        // 将 value 写入数据库即可
        window.alert('保存测试')
      }
    }
  }
</script>
