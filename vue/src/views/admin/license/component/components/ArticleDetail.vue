<template>
  <div class="createPost-container">
    <el-form ref="licenseForm" :model="license" class="form-container">
      <div class="createPost-main-container">
        <h1>자격증 정보 수정</h1>
        <el-form-item label="자격증 이름">
          <el-input v-model="license.name" />
        </el-form-item>

        <el-form-item label="관리코드">
          <el-select v-model="license.code">
            <el-option
              v-for="item in codeOptions"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="주최 기관">
          <el-input
            v-model="license.agency"
          />
        </el-form-item>

        <el-form-item label="시험 구분">
          <el-radio-group v-model="license.type">
            <el-radio
              v-for="item in typeOptions"
              :key="item"
              :label="item"
              :value="item"
            />
          </el-radio-group>
        </el-form-item>
        <el-form-item label="합격 점수">
          <el-input-number
            v-model="license.passScore"
            :min="0"
            :max="100"
          />
        </el-form-item>

        <el-form-item label="사용 여부">
          <el-checkbox v-model="license.inUse">사용</el-checkbox>
        </el-form-item>

        <el-form-item>
          <el-button @click="saveLicense()">저장</el-button>
        </el-form-item>

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
    licenseInfo: {},
    typeOptions: {},
    codeOptions: {}
  }, data() {
    return {
      childData: '',
      license: {
        id: this.licenseInfo.id,
        name: this.licenseInfo.name,
        agency: this.licenseInfo.agency,
        inUse: this.licenseInfo.inUse,
        type: this.licenseInfo.type,
        code: this.licenseInfo.code,
        passScore: this.licenseInfo.passScore
      }
    }
  },
  watch: {
    'licenseInfo': function() {
      this.license = {
        id: this.licenseInfo.id,
        name: this.licenseInfo.name,
        agency: this.licenseInfo.agency,
        inUse: this.licenseInfo.inUse,
        type: this.licenseInfo.type,
        code: this.licenseInfo.code,
        passScore: this.licenseInfo.passScore
      }
    }
  },
  methods: {
    popupClose() {
      this.$emit('close:popup', false)
      this.$emit('depthChildData', this.childData)
    },
    saveLicense() {
      console.log(this.license)
      axios.put('http://localhost/licenses/' + this.license.id, this.license)
        .then(res => {
          console.log(res.data)
          const h = this.$createElement
          this.$notify({
            title: '완료',
            message: h('i', { style: 'color: teal' }, '수정이 완료되었습니다.')
          })
          this.popupClose()
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
