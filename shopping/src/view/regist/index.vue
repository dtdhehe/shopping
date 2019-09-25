<template>
  <div>
       <div class="content">
          <div class="page-form">
              <div class="bg">
                <p class="title">用户注册</p>
                <el-form :model="userForm" :rules="rules" ref="userForm" size="small" label-width="100px" class="demo-userForm">
                    <el-form-item label="用户名：" prop="ueseName" style="width:300px" >
                            <el-input  v-model="userForm.ueseName" placeholder="请输入用户名"></el-input>
                    </el-form-item>
                    <el-form-item label="密码：" prop="password" ref="password" style="width:300px">
                        <el-input type="password" v-model="userForm.password"  placeholder="请输入密码" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码：" prop="checkPass" ref="checkPass" style="width:300px">
                        <el-input type="password" v-model="userForm.checkPass"  placeholder="请输入确认密码" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="gender">
                        <el-radio-group v-model="userForm.gender" style="width:200px">
                            <el-radio label="男"></el-radio>
                            <el-radio label="女"></el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item prop="email" label="邮箱" style="width:300px">
                        <el-input v-model="userForm.email" placeholder="请输入邮箱"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('userForm')">提交</el-button>
                         <el-button @click="resetForm('userForm')">重置</el-button>
                    </el-form-item>
                </el-form>
                
              </div>
              
          </div>
       </div>
  </div>
</template>

<script>
export default {
    data(){
          const validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.checkPass !== '') {
                    this.$refs.userForm.validateField('checkPass');
                }
                callback();
            }
        };

        const validatePass2 = (rule, value, callback) => {
            if (this.userForm.checkPass === '') {
                callback(new Error('请再次输入密码'));
            } else if (this.userForm.checkPass !== this.userForm.password) {
             callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        return{ 
            userForm:{
                ueseName:'',
                password:'',
                checkPass:'',
                gender:'男',
                phone:'',
                email:'',
            },
            rules:{
                ueseName:[
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    {  max:12, message: '长度12个字符以内', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { validator: validatePass, trigger: 'blur' }
                ],
                checkPass: [
                    { required: true, message: '请再次确认密码', trigger: 'blur' },
                    { validator: validatePass2, trigger: 'blur' }
                ],
                email: [
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
                ]
            }
        }

      
    },
    methods:{
    submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            this.$message.error('请将信息填写完整');
            return false;
          }
        //   请求
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
}

</script>
<style lang='scss' scoped>
$color:#fff;
.content{
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100vh;
    background: url('../../image/login/bg.jpg') no-repeat;
    background-size:cover;
    position: relative;
    background-attachment: fixed
}
.page-form{
    width: 400px;
    height: 100%;
    position: absolute;
    top: 20px;
    left: 50%;
    margin-left: -200px;
    .bg{
        background:rgba(148,148,148,0.2);
        width: 400px;
        height: 100vh;
        border-radius: 12px;
        .title{
            padding-top: 10px;
            color: $color;
        }
    }
}
</style>