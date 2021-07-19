<template>
<div>
<el-card class="box-card">
  <div slot="header" class="clearfix">
    <span></span>
    <el-button style="float: left; " type="primary" class="" @click="adduser">添加用户</el-button>
  </div>
   <!-- 用户列表 -->
      <el-table :data="tableData" border stripe>
        <el-table-column type="index"></el-table-column>

         <el-table-column label="编号" prop="id"></el-table-column>

        <el-table-column label="姓名" prop="username"></el-table-column>
        
        <el-table-column label="密码" prop="password"></el-table-column>

        <!-- scope.row 就是当前行的信息 -->
        <!-- <el-table-column label="状态" prop="state">
        
          <template slot-scope="scope">
            <el-switch v-model="scope.row.state" @change="userStateChanged(scope.row)"></el-switch>
          </template>
        </el-table-column> -->

        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- 修改 -->
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
            <!-- 删除 -->
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteUser(scope.row.id)"></el-button>
            <!-- 权限 -->
            <el-tooltip effect="dark" content="分配权限" placement="top-start" :enterable="false">
              <el-button type="warning" icon="el-icon-setting" size="mini"  @click="toPower(scope.row.id)"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <!-- <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNum"
        :page-sizes="[1, 2, 5, 100]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination> -->

      <el-pagination class="mypagination"
      background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="queryInfo.navigatePages"
      :page-sizes="[10, 20, 30, 40]"
      :page-size= queryInfo.pageSize
      layout="sizes, prev, pager, next"
      :total= total >
    </el-pagination>

</el-card>


   <!-- 创建新用户对话框 -->
    <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="50%"
    @close="addDialogClosed">
      <!-- 内容主体区域 -->
      <el-form :model="addForm" :rules="addFormRules"
        ref="addFormRef" label-width="70px">
        <!-- 用户名 -->
        <el-form-item label="用户名" prop="username">
          <el-input v-model="addForm.username"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item label="密码" prop="password">
          <el-input v-model="addForm.password"></el-input>
        </el-form-item>
       
      </el-form>
      <!-- 内容底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="comfirmUser">确 定</el-button>
      </span>
    </el-dialog>

    </div>
</template>

<script>
export default {
    created(){
        //   console.log('created');
        // const user = this.getAllUser();
        this.getAllUser();
        
        // console.log(user)
       
       
    },

     data() {
      return {
        tableData: [],
        addForm:{
          username:'',
          password:''
        },
        addDialogVisible:false,
        addFormRules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 5, max: 8, message: "长度在 5 到 8 个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 5, max: 8, message: "密码为 5~8 位", trigger: "blur" }
        ]
      },

      queryInfo:{
        pageNum:1,
        pageSize:10,
        navigatePages:1,
       


      },
      total:10,
    
     
     
      
      
      
      }
    },
    methods: {

    



      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      showEditDialog(obj){
        this.$message.info(obj+'')
      //  console.log(obj)
     
      },
      deleteUser(obj){
        this.$message.warning(obj+'')

      },
      toPower(obj){
        this.$message.success(obj+'')

      },
      adduser(){
        this.addDialogVisible = true

      },
      handleSizeChange(newSize){
        this.queryInfo.pageSize = newSize;
        this.getAllUser()

        


      },
      handleCurrentChange(newPage){
        // alert(newPage)
        this.queryInfo.pageNum = newPage

       this.getAllUser()

      },
      // 提交注册表单
      async comfirmUser(){
        // this.tableData.splice(1,0,this.addForm)
        // const {data:res}  = await this.$http.put('addUser',this.addForm);
        console.log(this.addForm)

        this.addDialogVisible = false

      },
      addDialogClosed(){
        this.$refs.addFormRef.resetFields();// 重置表单项
      },



      async getAllUser(){

        console.log(this.queryInfo)
          const {data:res}  = await this.$http.post('all',this.queryInfo);
           console.log(res)
    //   const red = {
    //       id : res[0].id,
    //       name : res[0].username
    //   }
    //   return red;
    for(var i = 0 ;i < res.length;i++){
        console.log(res[i])
       



    }

     this.tableData  = res.list;
     this.total = res.total


      }
    }
    
}
</script>
<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .mypagination{
    margin:  10px auto;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin: auto 10px;
    width: 98%;
  }
</style>