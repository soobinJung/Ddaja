<template>
  <div class="main-container">

    <div class="main-title">
      <div class="div-1">
        <font class="title-font1">자격증 관리</font>
      </div>
      <el-button
        size="mini"
        @click="createPopupState(true)"
      >자격증 생성</el-button>
    </div>

    <div class="searchArea">
      <el-input v-model="searchValue" placeholder="검색 내용" class="input-with-select" @keyup.enter.native="searchBtnClick">
        <el-select slot="prepend" v-model="searchType" placeholder="검색 조건">
          <el-option
            v-for="item in searchOptions"
            :key="item.value"
            :label="item.name"
            :value="item"
          />
        </el-select>
        <el-button
          slot="append"
          icon="el-icon-search"
          plain
          @click="searchBtnClick"
        >검색</el-button>
      </el-input>
    </div>

    <div class="table-box">
      <el-table
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column
          label="자격증 ID"
          prop="item.id"
        />
        <el-table-column
          :min-width="200"
          label="자격증 명"
          prop="item.name"
        />
        <el-table-column
          label="관리 코드"
          prop="item.code"
        />
        <el-table-column
          :min-width="100"
          label="주최 기관"
          prop="item.agency"
        />
        <el-table-column
          label="시험 구분"
          prop="item.type"
        />
        <el-table-column
          label="합격 점수"
          prop="item.passScore"
        />
        <el-table-column
          :formatter="cellValueBooleanFormatter"
          label="사용 여부"
          prop="item.inUse"
        />
        <el-table-column>
          <template slot-scope="props">
            <el-button
              size="mini"
              @click="popupState(props.row.item, true)"
            >상세 보기</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <popup
      :popup-val="popupVal"
      :license-info="licenseInfo"
      @close:popup="popupClose"
      @childData="childPopup"
    />
    <api-request
      ref="apiRequest"
      @licenseInfo="getLicenseInfo"
    />
    <search-options-request
      @searchOptions="getSerachOptions"
    />
    <license-create-popup
      :create-popup-val="createPopupVal"
      @close:popup="createPopupClose"
    />

    <div class="paging-box">
      <pagination
        class="paging"
        layout="prev, pager, next"
        :total="page.totalItems"
        :page.sync="page.page"
        :limit.sync="page.size"
        @pagination="getList"
      />
    </div>
  </div>

</template>

<script>
import popup from './component/licensePopup.vue'
import apiRequest from './component/licenseApiRequest.vue'
import licenseCreatePopup from './component/licenseCreatePopup.vue'
import Pagination from '@/components/Pagination'
import axios from 'axios'
import searchOptionsRequest from './component/licenseSearchOptionsRequest.vue'

export default {
  name: '',
  components: {
    popup,
    apiRequest,
    licenseCreatePopup,
    Pagination,
    searchOptionsRequest
  },
  data() {
    return {
      tableData: [],
      page: [],
      popupVal: false,
      licenseInfo: {},
      createPopupVal: false,
      childData: '',
      name: '',
      cellValueBooleanFormatter: function(row, column, cellValue, index) {
        var value = String(cellValue)
        if (value === 'true') {
          value = '사용'
        } else if (value === 'false') {
          value = '미사용'
        }
        return value
      },
      searchValue: '',
      searchType: {},
      searchOptions: []
    }
  },
  methods: {
    popupState(licenseInfo, popupVal) {
      this.licenseInfo = licenseInfo
      this.popupVal = popupVal
    },
    createPopupState(createPopupVal) {
      this.createPopupVal = createPopupVal
    },
    popupClose(popupVal) {
      this.popupVal = popupVal
      this.$refs.apiRequest.fetchData('')
    },
    createPopupClose(createPopupVal) {
      this.createPopupVal = createPopupVal
    },
    childPopup(childData) {
      this.childData = childData
    },
    getLicenseInfo(data) {
      this.tableData = data.items
      this.page = data.page
    },
    getSerachOptions(data) {
      this.searchOptions = data.items
    },
    getList(data) {
      const page = data.page
      const size = data.limit
      axios
        .get('http://localhost/licenses?page=' + page + '&size=' + size)
        .then(res => {
          console.log(res.data)
          this.tableData = res.data.items
          this.page = res.data.page
        })
        .catch(err => {
          alert('fail')
          console.log(err)
        })
    },
    searchBtnClick() {
      const h = this.$createElement
      let searchValue = this.searchValue
      if (!this.searchType.value) {
        this.$refs.apiRequest.fetchData('')
        this.$notify({
          title: '검색결과',
          message: h('i', { style: 'color: teal' }, '전체 검색 결과 입니다.')
        })
        return
      }
      if (searchValue === '') {
        this.$notify({
          title: '검색내용 미입력',
          message: h('i', { style: 'color: teal' }, '검색 내용을 입력해주세요.')
        })
        return
      }
      if (this.searchType.value === 'INUSE') {
        if (searchValue !== '사용' && searchValue !== '미사용') {
          this.$notify({
            title: '검색내용 오류',
            message: h('i', { style: 'color: teal' }, '사용, 미사용을 입력해주세요.')
          })
          return
        }
        searchValue = searchValue === '사용'
      }
      const query = '?' + this.searchType.query + '=' + searchValue
      this.$refs.apiRequest.fetchData(query)
      this.$notify({
        title: '검색결과',
        message: h('i', { style: 'color: teal' }, this.searchType.name + ' 검색 결과 입니다.')
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
        text-align: center;
        position: fixed;
        bottom: 0;
        width: 100%;
        margin-top: 100px;
        .paging{
            display: inline-block;
        }
    }
}
.el-select .el-input {
  width: 110px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
.searchArea {
  margin-top: 15px;
  width: 100%;
  display: flex;
  justify-content: center;
}
.input-with-select {
  width:80%;
}
</style>
