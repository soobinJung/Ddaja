<template>
  <div class="main-container">
    <div class="main-title">
      <div class="div-1">
        <font class="title-font1">사용자 관리</font>
      </div>
    </div>
    <div class="table-box">
      <el-table
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column type="expand">
          <template slot-scope="props">
            <p class="title">{{ props.row.title }}</p>
            <p class="content">{{ props.row.content }}</p>
          </template>
        </el-table-column>
        <el-table-column
          label="아이디"
          prop="userId"
        />
        <el-table-column
          label="이름"
          prop="userName"
        />
        <el-table-column>
          <template slot-scope="props">
            <el-button
              size="mini"
              @click="popupState(props.row.userId, true)"
            >상세 보기{{ test }}</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="paging-box">
      <el-pagination
        class="paging"
        layout="prev, pager, next"
        :total="50"
      />
    </div>
    <popup
      :popup-val="popupVal"
      :user-id="userId"
      @close:popup="popupClose"
      @test="test111"
    />
  </div>
</template>

<script>
import popup from './component/userPopup.vue'
export default {
  name: '',
  components: {
    popup
  },
  data() {
    return {
      tableData: [
        { userName: '길', userId: 'gil' },
        { userName: '빈스', userId: 'bins' },
        { userName: '길로그', userId: 'gillog' },
        { userName: '빈', userId: 'bin' },
        { userName: '길스', userId: 'gils' }
      ],
      popupVal: false,
      userId: undefined,
      test: ''
    }
  },
  methods: {
    popupState(userId, popupVal) {
      this.userId = userId
      this.popupVal = popupVal
    },
    popupClose(popupVal) {
      alert('zzzz')
    },
    test111(test) {
      alert('parent' + test)
      this.test = test
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap');
.main-container{
    width: 100%;
    text-align: center;
    padding: 30px;
    overflow:auto;
    background-color: rgb(255, 255, 255);
    .main-title{
        text-align: left;
        margin-top: 5px;
        margin-bottom: 30px;
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 1.5% 2% 0% 4%;
        .div-1{
            width: 80%;
            float: left;
            .title-font1{
                font-size: 50px;
                font-family: 'Do Hyeon', sans-serif;
            }
            .title-font2{
                font-size: 40px;
                padding: 0 0 0 30px;
                font-family: 'Do Hyeon', sans-serif;
            }
        }
        .div-2{
            width: 20%;
            float: left;
            .btn1{
                float: right;
                height: 50px;
                width: 200px;
            }
        }
    }
    .table-box{
        padding: 1.5% 2% 0% 4%;
        margin: 0 0 30px 0 ;
        float:left;
        width: 100%;
        max-height:550px;
        .title{ font-size: 20px; font-weight: bold; }
        .scrore{ font-size: 14px; font-weight: bold; }
        .content{ padding: 1.5%; font-size: 14px; }
    }
    .paging-box{
        float:left;
        padding: 2% 11% 2% 0;
        text-align: center;
        position: fixed;
        bottom: 0;
        width: 100%;
        .paging{
            display: inline-block;
        }
    }
}
</style>
