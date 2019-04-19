<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="date" label="日期" width="180">
    </el-table-column>
    <el-table-column prop="name" label="姓名" width="180">
    </el-table-column>
    <el-table-column prop="address" label="地址" width="300">
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button type="success" size="small" @click="userDetail(scope.$index, scope.row)">用户详情</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [{
          userid: "a1",
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          userid: "a2",
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          userid: "a3",
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          userid: "a4",
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      }
    },
    methods: {
      userDetail(index, detail) {
        this.$router.push({ 
          name: "user_info",
          params:{
            userid:detail.userid
          } 
        })
      }
    }
  }
</script>