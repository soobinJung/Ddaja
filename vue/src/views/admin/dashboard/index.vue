<template>
  <div class="main">
    <div class="main-logo-div">
      <img :src="Logo" class="logo" style="">
    </div>
    <el-row :gutter="20">
      <el-col :span="6">
        <router-link to="/admin/user">
          <el-button type="primary" icon="el-icon-user-solid">회원 관리</el-button>
        </router-link>
      </el-col>
      <el-col :span="6">
        <router-link to="/admin/license">
          <el-button type="primary" icon="el-icon-star-on">자격증 관리</el-button>
        </router-link>
      </el-col>
      <el-col :span="6">
        <router-link to="/admin/notice">
          <el-button type="primary" icon="el-icon-tickets">공지사항 관리</el-button>
        </router-link></el-col>
      <el-col :span="6"><router-link to="/admin/question">
        <el-button type="primary" icon="el-icon-star-on">문제 관리</el-button>
      </router-link></el-col>
    </el-row>
    <el-calendar v-model="CalendarDate" @click="clickClendar" />

    <div class="main-bottom">
      <el-timeline>
        <el-timeline-item timestamp="2018/4/12" placement="top">
          <el-card>
            <h4>Update Github log</h4>
            <p>G committed 2018/4/12 20:46</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2018/4/3" placement="top">
          <el-card>
            <h4>시험 문제 에러</h4>
            <p>[정보처리기사][2.전자계산기][194] dasfsfsf 저쩌고 에러 2018/4/3 20:46</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2018/4/2" placement="top">
          <el-card>
            <h4>서버 이상 상태</h4>
            <p>[Tomcat Server] Ooops! Memory Inbouded 80% ! 2018/4/2 20:46</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>

</template>
<script>
import mainLogo from '@/assets/DDaJa-Logo/logo.png'
// import question from '../question'
// import notice from '../notice'
// import license from '../license'
// import user from '../user'

export default {
//    components: {
//   question,
//   notice,
//   license,
//   user
// },
  data() {
    return {
      Logo: mainLogo,
      CalendarDate: new Date()
    }
  },
  methods: {
    clickClendar() {
      alert('달력 누름')
    }
  }

}
</script>

<style lang="scss" scoped>
.main{
  background-color: rgb(11, 8, 49);
}
.main-logo-div{
  padding-left: 44%;
  width: 100%;
  float: left;
  background-color: rgb(197, 241, 232);
  .logo{
        width: 200px;
        height: 200px;
  }
}
.main-bottom{
  width: 80%;
  float: left;
  background-color: rgb(197, 241, 232);
}

  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
