<template>
  <el-aside class="siderbar">
    <el-menu :default-active="nowTag" @select="clickMenu" unique-opened router background-color="#1e3a4b"
      text-color="#bfcbd9" active-text-color="#409EFF">
      <!-- index=href -->
      <el-menu-item index="/index">
        首页
      </el-menu-item>

      <el-submenu v-for="item in menu" :index="item.menuid">
        <template slot="title">{{item.name}}</template>
        <el-menu-item v-if="item.items" v-for="subitem in item.items" :key="subitem.menuid"
          :index="'/'+item.menuid+'/'+subitem.menuid">{{subitem.name}}</el-menu-item>
      </el-submenu>

    </el-menu>
  </el-aside>
</template>

<script>
  import menuList from '../../data/menu'
  export default {
    data() {
      return {
        menu: [],
        nowTag: ''
      }

    },
    methods: {
      clickMenu(index, path) {
      },
    },
    created() {
      this.nowTag = this.$route.path;
      this.menu = menuList;
      this.$api.config.menu_list().then(res => {
        console.log(res);
      }).catch(err => {
        console.log(err);
      });
    },

  }
</script>

<style scoped>
  .el-menu {
    height: 100%;
    color: #333;
    border: none;
    padding: 0px;
    margin: 0px;
  }

  .siderbar::-webkit-scrollbar {
    width: 0 !important;
    overflow: -moz-scrollbars-none;
  }
</style>