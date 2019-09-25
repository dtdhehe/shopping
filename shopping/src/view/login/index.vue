<template>
  <div>
      <div class="content">
          <div class="page-form">
              <div class="bg"></div>
              <div class="form">
                <div class="fire-input">
                    <div class="lab">用户名：</div>
                     <el-input v-model="dataForm.userName" size="small" style="width:200px;" placeholder="请输入内容"></el-input>
                </div>
                 <div class="fire-input">
                    <div class="lab">密&nbsp;&nbsp;&nbsp;&nbsp;码：</div>
                     <el-input v-model="dataForm.password" size="small" style="width:200px;" placeholder="请输入密码" show-password></el-input>
                </div> 
                <div class="fire-btn" >
                    <el-button type="danger" style="width:200px" size="small" round v-on:click="handleLogin">确定登录</el-button>
                </div> 
                <div class="regist-btn"><a @click="hangleRegist">注册账户</a></div>
              </div> 
          </div>
      </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            dataForm:{
                userName:'',
                password:'',
            } 
               
        }
    },
    // mounted(){
    // },
    methods:{
        handleLogin(){
            if(!this.dataForm.userName){
                this.$message.error('用户名不能为空');
                return
            }
            if(!this.dataForm.password){
                this.$message.error('密码不能为空');
                return
            }
            this.$axios.post('/login', {
                userName: this.dataForm.userName,
                password: this.dataForm.password
              })
              .then(res => {
                if (res.data.code === 200) {
                  this.$router.push({
                     path:'/home',
                  });
                }else{
                    this.$message.error(res.data.msg)
                }
              })
              .catch(failResponse => {
              })
        },
        hangleRegist(){
            this.$router.push({
                path:'/regist'
            })
        }
    }
}

</script>
<style lang="scss" scoped>
$color:#fff;
.content{
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100vh;
    background: url('../../image/login/bg.jpg') no-repeat;
    background-size:cover;
    position: relative;
}
.page-form{
    width: 400px;
    height: 200px;
    position: absolute;
    top: 100px;
    left: 50%;
    margin-left: -200px;
    .bg{
        // background-color: #949494;
        background:rgba(148,148,148,0.2);
        width: 400px;
        height: 220px;
        // opacity: .2;
        border-radius: 12px;
    }
    .form{
        width: 400px;
        height: 220px;
        margin-top: -180px;
        max-width: 500px;
        .fire-input{
            color:$color; 
            margin-bottom: 15px;
            font-size: 14px;
            display: flex;
            justify-content: center;
            align-content: center;
            .lab{
                margin-top: 5px;
                text-align: right;
            }
        }
        .fire-btn{
            z-index: 10;
            margin-left: 50px;
        }
        .regist-btn{
            font-size: 10px;
            color: $color;
            text-decoration: underline;
            margin-top: 5px;
        }
    }
}

</style>