<template>
  <div class="main-container">
    <div class="main-title">
      <font class="font1">Questions Manager</font>
      <el-button
        icon="el-icon-circle-plus-outline"
        style="float:right; margin: 0 58px 0 0; width:100px; height :50px"
        @click="insertDrawerStatus(true)"
      > 추가 </el-button>
      <el-button
        type="danger"
        icon="el-icon-delete"
        style="float:right; margin: 0 30px 0 0; width:100px; height :50px"
        @click="deleteWord()"
      > 삭제 </el-button>
    </div>

    <div class="div1" style="padding:0px 0px 70px 29%;">
      <div style="float:left; padding:1px 20px 0px 0px">
        <el-select v-model="param.licenseID" placeholder="Select" style="width:500px">
          <el-option
            v-for="item in licenseOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>

      </div>
      <div style="float:left; padding:0px 20px 0px 0px">
        <el-input
          v-model="param.examYear"
          style="width:500px"
          placeholder="응시 년도를 입력 하세요."
          @keyup.enter.native="clickSearch"
        />
      </div>
      <div style="float:left; padding:0px 0px 0px 0px">
        <el-button
          type="primary"
          @click="clickSearch"
        >검 색</el-button>
      </div>
    </div>


    <div style = "width: 90%; margin: 0 5% 0 5%;">
      <div style = "width: 40%; float:left;">
        <el-table
          ref   = "singleTable"
          :data = "examinationList"
          style = "width: 100%">
          <el-table-column
            type  = "index"
            width = "50">
          </el-table-column>
          <el-table-column
            property = "name"
            label    = "시험명">
          </el-table-column>
        </el-table>
      </div>
      <div style="width: 60%; float:left; padding : 0 0 0 5%">
        <el-table
          :data = "questionsList"
          style = "width: 100%">
          <el-table-column type="expand">
            <template slot-scope="props">
              <div v-for="vo in props.row.answers" v-bind:key="vo.answersID">
                <span >{{ vo.answers }}</span>
              </div>
            </template>
          </el-table-column>
          <el-table-column
            label="문제"
            prop="question">
          </el-table-column>
          <el-table-column
              label="Date"
              prop="date">
          </el-table-column>
        </el-table>
      </div>
    </div>
    <!-- <updateDrawer
      :popup-val="updateDrawerVal"
      :word-info="wordInfo"
      @refresh="fetchList()"
      @close:updatedrawer="updateDrawerStatus"
    />
    <insertDrawer
      :popup-val="insertDrawerVal"
      @refresh="fetchList()"
      @close:insertdrawer="insertDrawerStatus"
    /> -->
  </div>
</template>

<script>
import Pagination from '@/components/Pagination'
import { licenseList, fetchList } from '@/ddaja-api/admin/examination/Examination'
// import updateDrawer from './components/updateDrawer'
// import insertDrawer from './components/insertDrawer'
import _ from 'lodash'

export default {
  name: 'AdminQuestion',
  components: {
    Pagination,
    // updateDrawer,
    // insertDrawer
  },
  data() {
    return {
      licenseOptions: [],
      tableData: [],
      totalCount: 0,
      param: {
        licenseID  : 0
        , examYear : 0
      },
      selectList: [],
      updateDrawerVal: false,
      insertDrawerVal: false

      , examinationList: [],


        questionsList: [
          {
          date     : '2016-05-03',
          question : 'JAVA 의 특징',
          answers  : [
            { 
              answersID : 1
              , answers : '객체 지향 언어'
            },
            { 
              answersID : 2
              , answers : '절차 지향 언어'
            },
            { 
              answersID : 3
              , answers : '구조체'
            },
            { 
              answersID : 4
              , answers : '네트워크 언어'
            },
            { 
              answersID : 5
              , answers : '안드로이드 언어'
            }
          ]
        }
        , {
          date     : '2018-05-03',
          question : 'JAVA 의 특징',
          answers  : [
            { 
              answersID : 1
              , answers : '객체 지향 언어'
            },
            { 
              answersID : 2
              , answers : '절차 지향 언어'
            },
            { 
              answersID : 3
              , answers : '구조체'
            },
            { 
              answersID : 4
              , answers : '네트워크 언어'
            },
            { 
              answersID : 5
              , answers : '안드로이드 언어'
            }
          ]
        }]
    }
  }

  , created() {
    this.createSetting()
  }
  
  , methods: {

    async createSetting(){
      await this.getLicense().then( response => {
        this.param.licenseID = this.licenseOptions[0].value
      })
      await this.getRoundList()
    }

    , async getLicense() {
      await licenseList().then(response => {
        response.items.forEach(x => {
          var type = (x.item.type === 'WRITING') ? '필기' : '실기'
          var label = '[' + type + '] ' + x.item.name
          this.licenseOptions.push({ value: x.item.id, label: label })
        })
      })
    }
    
    , async getRoundList(){
      var param = {
        licenseID  : this.param.licenseID
        , examYear : this.param.examYear
      }

      await fetchList(param).then( response => {
        this.examinationList = []
        response.items.forEach( x => {
          
          let examDate = x.item.examDate
          let name = examDate.substring( 0, 4 ) 
                    + ' / '
                    + examDate.substring( 4, 6 )
                    + ' / '
                    + examDate.substring( 6, 8 )
                    + ' - ' + x.item.round + '회차 기출문제'

          this.examinationList.push({
            id          : x.item.id
            , examDate  : x.item.examDate
            , examYear  : x.item.examYear
            , inUse     : x.item.inUse
            , isCreated : x.item.isCreated
            , lid       : x.item.lid
            , round     : x.item.round
            , name      : name
          })
        })
      })
    } 


    ,
    
    deleteWord() {
    //   var wordIdList = _.map(this.selectList, 'id')

    //   for (var index in wordIdList) {
    //     await this.wordDelete(wordIdList[index])
    //   }

    //   console.log('====')

    //   await this.clickSearch()
    // },
    // async wordDelete(wID) {
    //   var param = {
    //     id: wID
    //   }
    //   await wordDelete(param).then(response => {
    //     console.log('DELETE')
    //     this.$message({
    //       message: 'Word Delete Success',
    //       type: 'success'
    //     })
    //   })
    },
    updateDrawerStatus(val, row) {
      this.updateDrawerVal = val
      if (val) {
        // this.wordInfo.wID = row.item.id
        // this.wordInfo.lID = row.item.license.id
        // this.wordInfo.title = row.item.title
        // this.wordInfo.wordQuestionsCount = row.item.wordQuestionsCount
      }
    },
    insertDrawerStatus(val) {
      this.insertDrawerVal = val
    },

    async clickSearch() {
      await this.getRoundList()
    }
    
    , handleSelectionChange(val) {
      this.selectList = []
      val.forEach(x => {
        this.selectList.push(x.item)
      })
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
.font1{
font-size: 50px;
font-family: 'Do Hyeon', sans-serif;
}
.font2{
font-size: 40px;
padding: 0 0 0 30px;
font-family: 'Do Hyeon', sans-serif;
}
}
.div1{
width: 90%;
margin: 0 5% 0 5%;
padding: 2% 0 3% 0;
.select1{
width: 200px;
}
.btn1{
width: 100px;
}
} 
}
</style>
