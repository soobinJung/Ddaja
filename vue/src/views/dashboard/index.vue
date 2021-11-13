<template>
  <div style="margin : 10px 30px 100px 30px; padding : 0 0 100px 0; overflow:hidden; ">
    <div class="main-logo-div" style="height:150px;">
      <div style="float:left; width:20%; padding: 3% 0 1% 7%; height:100px;">
        <img :src="Logo" class="logo">
      </div>
      <!-- <panel-group @handleSetLineChartData="handleSetLineChartData" /> -->
      <div style="float:right; width: 80%; height:100px; padding:4% 10% 0 0">
        <div style="float:right; padding:0 0 0 3% ">
          <el-button type="primary" @click="setLisenseList()">검 색</el-button>
        </div>
        <div style="float:right; padding:0 0 0 0">
          <el-input v-model="param.name" style="width:500px" placeholder="자격증 명을 검색할 수 있습니다" @keyup.enter.native="setLisenseList()" />
        </div>
      </div>
    </div>
    <div style="margin:0 0 100px 0; padding:0 0 100px 0">
      <div
        v-for="item in licenseOption"
        :key="item.id"
        class="clearfix"
        style="float:left; margin:50px 100px 50px 100px; width:19%; height:120px;"
        @click="sessionSave(item)"
      >
        <router-link to="/explore">
          <el-card class="box-card" style="margin:10px 30px 20px 30px;">
            <div style="margin: 8% 10px 8% 10%">
              <span style="font-size:15px; font-weight:bold"><i class="el-icon-success" style="margin:0 10px 0 0" />{{ item.name }}<br></span>
            </div>
            <div style="margin:10px 10px 10px 10%">
              <span style="font-size:13px">주최 : {{ item.agency }}<br></span>
            </div>
            <div style="margin:10px 10px 40px 10%">
              <span style="font-size:13px">유형 : {{ item.type === 'WRITING' ? "필기" : item.type === "PERFORM" ? "실기" : "" }}<br></span>
            </div>
          </el-card>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import mainLogo from '@/assets/DDaJa-Logo/main_logo.png'
import { fetchLicenseList } from '@/ddaja-api/user/dashboard/dashboard'
import PanelGroup from './component/PanelGroup'

export default {
  components: {
    PanelGroup
  },

  data() {
    return {
      Logo: mainLogo,
      licenseOption: [],
      param: {
        name: ''
      }
    }
  },

  created() {
    this.setLisenseList()
  },

  beforeCreate: function() {

  },

  methods: {
    async setLisenseList() {
      await fetchLicenseList(this.param).then(response => {
        this.licenseOption = []
        response.items.forEach(x => {
          this.licenseOption.push(x.item)
        })
      })
    },

    sessionSave(licenseInfo) {
      var info = {
        licenseID: licenseInfo.id,
        licenseName: licenseInfo.name,
        licenseCode: licenseInfo.code,
        subject: licenseInfo.subjects
      }
      this.$session.set('licenseInfo', info)
    }
  }
}
</script>

<style lang="scss" scoped>
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>
