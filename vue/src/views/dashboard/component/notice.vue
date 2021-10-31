<template>
  <div class="notice-container">
    <div class="title"> <i class="el-icon-check" />  공 지 사 항  </div>
    <div class="notice-div">
      <el-table
        :data="tableData"
        height="250"
        style="width: 100%"
        @cell-click="noticeSelect()"
      >
        <el-table-column
          prop="title"
          label="Title"
        />
        <el-table-column
          prop="name"
          label="Name"
          width="180"
        />
        <el-table-column
          prop="date"
          label="Date"
          width="180"
        />
      </el-table>
      <selectPopup
        :popup-val="popupVal"
        :vo-data="voData"
        @close:notice="popupClose"
      />
    </div>
  </div>
</template>

<script>
import selectPopup from './notice/noticeSelect'
export default {
  components: {
    selectPopup
  },
  data() {
    return {
      voData: undefined,
      popupVal: false,
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        },
        {
          date: '2016-05-03',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        },
        {
          date: '2016-05-03',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        },
        {
          date: '2016-05-03',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        },
        {
          date: '2016-05-03',
          name: 'Tom',
          title: '공지사항 알립니다 더미'
        }
      ]
    }
  },
  methods: {
    noticeSelect() {
      this.popupVal = true
    },
    popupClose(value) {
      this.popupVal = value
    }
  }

}
</script>

<style lang="scss" scoped>
.notice-container{
  padding-left: 7%;
  padding-right: 7%;
  padding-bottom: 30px;
  width: 100%;
  background-color:rgb(11, 8, 49);
  .notice-div{
    padding: 30px;
    background-color: black;
  }
}
.title{
  color: beige;
  font-size: 40px;
  font-family: 'Kirang Haerang', cursive;
  padding-top: 10px;
  padding-bottom: 20px;
}
</style>
