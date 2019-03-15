<template>
    <div id="pro-div">
      <el-row id="introduce">
        <el-col :span="24">
          <i class="el-icon-time" style="font-size: 300px;color: azure;margin-top: 50px"></i>
          <span style="font-size: 30px;color: azure;">How much time do you left?</span><br>
          <span style="color: azure;margin-left: 280px">Little ugly mmk</span>
        </el-col>
      </el-row>
      <el-row id="quick-nav">
        <el-col :span="6" class="nav-item"></el-col>
        <el-col :span="6" class="nav-item"></el-col>
        <el-col :span="6" class="nav-item"></el-col>
        <el-col :span="6" class="nav-item"></el-col>
      </el-row>
    </div>
</template>

<script>
  export default {
    name: 'QuickNav'
  }
</script>

<style scoped>

#pro-div{
  height: 800px;
  background-image: url("../../assets/img/bg/topo.png"), linear-gradient(70deg, #313375, #696cd2);
}

#introduce{
  position: absolute;
  height: 400px;
  width: 60%;
  margin-left: 20%;
  margin-top: 100px;
  background-color:black;
}

#quick-nav{
  position: absolute;
  height: 200px;
  width: 60%;
  margin-left: 20%;
  margin-top: 501px;
  /*background-color: black;*/
}

.nav-item{
  height: 150px;
  background-color: black;
  border-color: transparent;
  border: 2px solid;
  }
</style>
