<template>
  <el-container class="base-container">
    <v-asidebar></v-asidebar>
    <el-container direction="vertical">
      <v-header></v-header>
      <el-main>
          <!-- <keep-alive :include="$router.user_list"> -->
              <router-view></router-view>
            <!-- </keep-alive> -->
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import vAsidebar from './Asidebar.vue'
  import vHeader from './Header.vue'
  export default {
    data() {

      return {

      }
    },
    components: {
      vAsidebar,
      vHeader
    }

  };
</script>

<style>
.base-container{
  width: 100vw;
  height: 100vh;
  /* background: #fff; */
  border: none;
}
.el-container{
  margin: 0;
  padding: 0;
  border: none;
}

</style>