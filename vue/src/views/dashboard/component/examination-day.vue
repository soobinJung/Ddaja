<template>
  <div>
    <div class="title"> <i class="el-icon-check" />  D-DAY  </div>
    <div class="dday-div">
      <el-table
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column type="expand">
          <template slot-scope="props">
            <p>시험명: {{ props.row.name }}</p>
            <p>날  짜: {{ props.row.date }}</p>
            <p>준비물: {{ props.row.supplies }}</p>
          </template>
        </el-table-column>
        <el-table-column
          label="D - day"
          prop="dday"
        />
        <el-table-column
          label="Name"
          prop="name"
        />
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        dday: 'D-1',
        date: '2016-05-03',
        name: '정보처리 산업기사',
        supplies: '볼펜, 컴퓨터 싸인펜, 이면지, 신분증, 응시표'
      }, {
        dday: 'D-2',
        date: '2016-05-02',
        name: '정보처리 기사',
        supplies: '볼펜, 컴퓨터 싸인펜, 이면지, 신분증, 응시표'
      }, {
        dday: 'D-5',
        date: '2016-05-04',
        name: '컴퓨터 활용 능력 1급',
        supplies: '볼펜, 컴퓨터 싸인펜, 이면지, 신분증, 응시표'
      }, {
        dday: 'D-6',
        date: '2016-05-01',
        name: '컴퓨터 활용 능력 2급',
        supplies: '볼펜, 컴퓨터 싸인펜, 이면지, 신분증, 응시표'
      }, {
        dday: 'D-7',
        date: '2016-05-01',
        name: '컴퓨터 활용 능력 2급',
        supplies: '볼펜, 컴퓨터 싸인펜, 이면지, 신분증, 응시표'
      }, {
        dday: 'D-10',
        date: '2016-05-01',
        name: '컴퓨터 활용 능력 2급',
        supplies: '볼펜, 컴퓨터 싸인펜, 이면지, 신분증, 응시표'
      }]
    }
  }
}
</script>

<style lang="scss" scoped>
.title{
  color: beige;
  font-size: 50px;
  font-family: 'Kirang Haerang', cursive;
  padding-top: 10px;
  padding-bottom: 20px;

}
.dday-div{
  padding: 30px;
  background-color: white;
}
</style>
