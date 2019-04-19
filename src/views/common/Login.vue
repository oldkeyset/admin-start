<template>
  <div class="warp">
    <div class="login-container">
      <img src="../../assets/login-left.png" alt="" class="img-bg">
      <el-form class="login-form" :model="loginForm" autoComplete="on" status-icon :rules="loginRules" ref="loginForm"
        label-position="left">
        <p class="title">后台管理系统</p>

        <el-tabs v-model="status.activeName" stretch>
          <el-tab-pane label="账户密码" name="first" class="tab">

            <el-form-item prop="username">
              <!-- <span class="svg-container svg-container_login">
                  <svg-icon icon-class="phone" />
                </span> -->
              <el-input name="username" type="text" v-model="loginForm.username" :maxlength='15' autoComplete="on"
                placeholder="请输入手机号" />
            </el-form-item>
            <el-form-item prop="password">
              <!-- <span class="svg-container">
                  <svg-icon icon-class="password"></svg-icon>
                </span> -->
              <el-input name="password" :type="pwdType" :maxlength="20" v-model="loginForm.password"
                placeholder="请输入密码"></el-input>
              <!-- <span class="show-pwd" @click="showPassword">
                  <svg-icon icon-class="eye"></svg-icon>
                </span> -->
            </el-form-item>

            <el-form-item prop="checkcode">

              <!-- <span class="svg-container">
                  <svg-icon icon-class="code"></svg-icon>
                </span> -->
              <el-input type="text" class="lastInput" style="widows: 225px;" placeholder="请输入验证码"
                @keyup.enter.native="login('loginForm')" :maxlength="4" v-model="loginForm.checkcode">
              </el-input>
              <div class="captcha_dialog">
                <img :src="captcha_url" alt="" @click="captcha()" class="captcha-img">
              </div>
            </el-form-item>
            <el-button type="primary" :loading="loading" @click.native.prevent="login('loginForm')"
              class="login-button">
              登录
            </el-button>
            <p class="resetPassword" @click="status.resetPassword = true">忘记密码?</p>
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        captcha_url: '../../assets/code.jpg',
        pwdType: 'password',
        loading: false,
        status: {
          index: 0,
          time: 20,
          timeClick: false,
          resetPassword: false,
          activeName: 'first'
        },
        loginForm: {
          username: '13000000001',
          password: '123456',
          checkcode: ''
        },
        //提示消息
        loginRules: {
          username: [
            { required: true, message: "请输入手机号" }
          ],
          password: [
            { required: true, message: "请输入密码" }
          ],
          checkcode: [
            { required: true, message: "请输入验证码" }
          ]
        }
      };
    },
    created() {
      if (!this.$store.state.auth_info.peerid) {
        this.$api.common.peerid().then((data) => {
          this.$store.commit("auth_info", {
            peerid: data
          });
          localStorage.setItem("peerid", data, 30);
          this.captcha();
        });
      } else {
        this.captcha();
      }
      this.getDataCookie();
    },
    methods: {
      setInfo(sessionid, username) {
        this.$store.commit("auth_info", {
          sessionid: sessionid
        });
        this.$store.commit("auth_info", {
          username: username
        });
        localStorage.setItem("sessionid", sessionid, 30);
        localStorage.setItem("username", username, 30);
      },
      login(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.loading = true;
            this.$api.common.login(
              this.loginForm.username,
              this.loginForm.password,
              this.loginForm.checkcode
            ).then(res => {
              this.loading = false;
              this.saveDataCookie(this.loginForm.username);
              this.setInfo(res.sessionid, res.username);
              this.$router.push({
                path:'index'
              });
            }).catch((err) => {
              this.loading = false;
              this.captcha();
              this.$error(err.msg);
            })
          } else {
            return false;
          }
        });
      },

      // 将手机号保存至cookie，当断开退出时自动填写
      saveDataCookie(username) {
        let date = new Date();
        date.setDate(date.getDate() + 7);
        document.cookie = "username=" + username + ";expires=" + date.toString();
      },
      getDataCookie() {
        if (document.cookie.match(/username=.*/)) {
          let username = document.cookie.match(/username=.*/)[0].slice(9)
          this.loginForm.username = username.slice(0, 11)
        }
      },
      showPassword() {
        this.pwdType = 'text';
      },
      captcha() {
        let peerid = this.$store.state.auth_info.peerid;
        this.$api.common.captcha(peerid).then(data => {
          this.captcha_url = data.base64;
        }).catch((err) => {
        });
      },
    }
  }
</script>
<style scopen>
  .warp {
    width: 100vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    overflow: hidden;
    background: url('../../assets/login-bg.png') no-repeat center center;
    background-size: cover;
  }

  .login-container {
    height: 600px;
    width: 750px;
    z-index: 1;
    overflow: hidden;
  }

  .img-bg {
    width: 45%;
    height: 100%;
    float: left;
  }

  .login-form {
    width: 55%;
    height: 100%;
    float: right;
    background-color: #ffffff;
    box-sizing: border-box;
    overflow-y: hidden;
    /* 滚动条样式 */
  }

  .login-form::-webkit-scrollbar {
    background-color: rgba(0, 0, 0, 0);
  }

  .title {
    font-size: 26px;
    color: #333333;
    margin: 40px auto 20px;
    text-align: center;
  }

  .tab {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 20px;
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7xp;
    font-size: 16px;
    color: #889aa4;
    cursor: pointer;
    user-select: none;
  }

  .login-button {
    width: 260px;
    height: 50px;
    margin: 25px 0 0 0;
    background-color: #3182af;
    border-color: #3182af;
    font-size: 20px;
  }

  .resetPassword {
    font-size: 14px;
    cursor: pointer;
  }

  .resetPassword:hover {
    color: #3182AF;
  }

  .chatcha {
    height: 40px;
    margin-top: 6px;
    display: inline-block;
    border-left: 1px solid #e5e5e5;
  }

  /* .......改变 el 默认........ */
  .el-input__inner {
    background-color: transparent;
  }

  .el-tabs {
    width: 85%;
    height: 100%;
    margin: 0 auto;
  }

  .el-tab-pane {
    height: 100%;
    box-sizing: border-box;
  }

  .el-form-item {
    width: 100%;
    height: 55px;
    padding: 2%;
    border: none;
  }

  .el-form-item .el-form-item__content {
    height: 100%;
    border: 1px solid #DCDFE6;
  }

  .el-form-item__content .el-input {
    width: 100%;
    height: 100%;
  }

  .el-form-item__content .lastInput {
    width: 80%;
  }

  .el-input .el-input__inner {
    height: 100%;
    border: none;
  }

  .captcha_dialog {
    float: right;
    height: 99%;
    width: 19%;
    border-left: 1px solid #DCDFE6;
  }

  .captcha-img {
    width: 80%;
    height: 85%;
    margin: 5px;
  }
</style>