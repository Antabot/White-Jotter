<template>
  <div id="main">
    <mavon-editor v-model="value" style="height: 100%;width: 100%;position: fixed" ref=md @imgAdd="$imgAdd" @imgDel="$imgDel" fontSize="20px"/>
  </div>
</template>

<script>
  export default {
    name: 'Editor'
  }
</script>
