<template>
  <div class="main-container">
    <div class="main-title">
      <div class="div-1">
        <font class="title-font1">공지사항 관리</font>
      </div>
      <div class="div-2">
        <el-button type="success" class="btn1" @click="popupState(true)">공지사항 작성</el-button>
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
          label="제목"
          prop="title"
        />
        <el-table-column
          label="작성자"
          prop="writer"
        />
        <el-table-column
          label="작성일"
          prop="date"
        />
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
      @close:popup="popupState"
    />
  </div>
</template>

<script>
import popup from './component/noticeWritePopup.vue'
export default {
  name: '',
  components: {
    popup
  },
  data() {
    return {
      tableData: [
        { date: '2021-06-11', writer: '길', title: '공지사항 1번 제목', content: '공지사항 1' },
        { date: '2016-06-02', writer: '빈', title: '공지사항 2번 제목', content: '공지사항 3' },
        { date: '2016-06-01', writer: '길', title: '공지사항 3번 제목', content: '공지사항 4' },
        { date: '2016-06-03', writer: '빈', title: '공지사항 4번 제목', content: '공지사항 2' },
        { date: '2016-06-04', writer: '길', title: '공지사항 5번 제목', content: '공지사항 5' }
      ],
      popupVal: false
    }
  },
  methods: {
    popupState(value) {
      this.popupVal = value
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
