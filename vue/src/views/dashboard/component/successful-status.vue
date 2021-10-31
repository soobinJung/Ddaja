<template>
  <div class="successful-status-container">
    <div class="title"> <i class="el-icon-check" /> 합 격 률</div>
    <!-- 차트 -->
    <div class="chart-container">
      <chart height="100%" width="100%" />
    </div>
    <!-- 차트 버튼 -->
    <div class="successful-status-btn-box">
      <div class="btn-box">
        <el-row :gutter="20">
          <el-col :span="6"><div class="grid-content bg-purple"><span class="successful-status-span" @click="test"><i class="el-icon-menu" />  자격증별 합격률 </span></div></el-col>
        </el-row>
        <div v-for="item in categoryTitle" :key="item.id">
          <el-row :gutter="20">
            <el-col :span="6"><div class="grid-content bg-purple"><span class="successful-status-span" @click="test(item.id)"><i class="el-icon-check" />  {{ item.title }}</span></div></el-col>
          </el-row>
        </div>
      </div>
    </div>
    <div />
  </div>
</template>

<script>
import chart from './charts/MixChart'

export default {
  name: 'MixChart',
  components: { chart },
  data() {
    return {
      categoryTitle: [
        { id: 4,
          title: '정보 처리 산업기사'
        },
        { id: 1,
          title: '정보처리 기사'
        },
        {
          id: 2,
          title: '컴퓨터 활용 자격증 1급'
        },
        {
          id: 3,
          title: '컴퓨터 활용 자격증 2급'
        }
      ]
    }
  },
  methods: {
    test() {
      alert('개발자님 차트 변형해서 개발 해주세요 😁')
    }
  }
}
</script>

<style lang="scss" scoped>
.title{
  color: beige;
  font-size: 40px;
  font-family: 'Kirang Haerang', cursive;
  padding-top: 10px;
  padding-bottom: 20px;
}
.successful-status-container{
  width: 100%;
  float: left;
  padding-left: 8%;
  height: 100%;
  background-color:rgb(11, 8, 49);
  width: 100%;
  .chart-container{
    position: relative;
    height: calc(100vh - 84px);
    width: 60%;
    float: left;
    height: calc(100vh - 84px);
  }
  .successful-status-btn-box{
    height: 100%;
    width: 30%;
    float: left;
    padding-left: 20px;
    .btn-box{
      width: 100%;
      .el-row {
        margin-bottom: 20px;
        width: 100%;
        &:first-child{
          margin-top: 30px;
        }
        &:last-child {
          margin-bottom: 0;
        }
      }
      .el-col {
        border-radius: 4px;
      }
      .grid-content {
        border-radius: 4px;
        min-height: 50px;
        min-width:  500px;
        background: #2a3068;
        border: 5px solid white;
        color: #f9fafc;
        padding: 10px;
        .successful-status-span{
          font-size: 30px;
          font-family: 'Kirang Haerang', cursive;
        }
      }
      .grid-content:hover{
        background: #5268ca;
        font-weight: bold;
        font-size: 28px;
        color: black;
      }
      .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
      }
    }
  }
}
</style>

successful-status.vue
