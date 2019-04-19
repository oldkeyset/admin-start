<template>
  <div class="user_info">
    <h1>user_info</h1>
    <br><br>
    <div>userid {{$route.query}}</div>
    <div>userid {{$route.params}}</div>
    <el-button @click="getInfo">userid</el-button>
  </div>
</template>
<script>
  export default{
    props:{
      userid:{
        type:String,
        required:true
      }
    },
    data(){
      return{
        userInfo:{}
      }
    },
    methods:{
      getInfo(){
      }
    }
  }
</script>