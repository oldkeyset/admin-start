<template>
  <el-button @click="getMenu">获取菜单列表</el-button>
</template>
<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

<script>
  export default {
    data() {

      return {

      }
    },
    methods: {
      getMenu() {
        this.$api.config.menu_list().then(res => {
          console.log(res);
        }).catch(err => {
          console.log(err);
        });
      }
    }
  };
</script>