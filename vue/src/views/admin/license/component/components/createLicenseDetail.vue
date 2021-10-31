<template>
  <div class="createPost-container">
    <el-form class="form-container">
      <div class="createPost-main-container">
        <h1>자격증 생성</h1>
        <el-row>
          <el-col
            :span="24"
          />
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="choice-box">
              <el-checkbox v-model="inUse" label="1" border>사용</el-checkbox>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <div class="demo-input-size">
              <el-input
                v-model="name"
                placeholder="자격증 이름"
              />
              <el-select v-model="code" placeholder="자격증 코드">
                <el-option
                  v-for="item in codeOptions"
                  :key="item"
                  :label="item"
                  :value="item"
                />
              </el-select>
              <el-input
                v-model="agency"
                size="medium"
                placeholder="운영기관"
              />
              <el-input
                v-model="passScore"
                size="medium"
                placeholder="합격 점수"
              />
              <el-select v-model="type" placeholder="시험 종류(필기/실기)">
                <el-option
                  v-for="item in typeOptions"
                  :key="item"
                  :label="item"
                  :value="item"
                />
              </el-select>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24" align="right">
            <el-button @click="createLicense()">저장</el-button>
          </el-col>
        </el-row>
      </div>

    </el-form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: '',
  props: {
    isEdit: {},
    typeOptions: {},
    codeOptions: {}
  },
  data() {
    return {
      name: '',
      inUse: false,
      agency: '',
      type: '',
      passScore: '',
      code: ''
    }
  },
  methods: {
    popupClose() {
      this.$emit('close:popup', false)
    },
    createLicense() {
      const licenseInfo = {
        'name': this.name,
        'inUse': this.inUse,
        'agency': this.agency,
        'type': this.type,
        'code': this.code,
        'passScore': this.passScore
      }
      console.log(licenseInfo)
      axios.post('http://localhost/licenses', licenseInfo)
        .then(res => {
          console.log(res.data)
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";

.createPost-container {
  position: relative;

  .createPost-main-container {
    padding: 40px 45px 20px 50px;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;

      .postInfo-container-item {
        float: left;
      }
    }
  }

  .word-counter {
    width: 40px;
    position: absolute;
    right: 10px;
    top: 0px;
  }
}

.article-textarea ::v-deep {
  textarea {
    padding-right: 40px;
    resize: none;
    border: none;
    border-radius: 0px;
    border-bottom: 1px solid #bfcbd9;
  }
}

.choice-box{
    padding: 0 5.5% 1.5% 0;
    float: right;
}
</style>
