<template>
  <div>
    <el-dialog
      :visible.sync="popupVal"
      :before-close="handleClose"
    >
      <div>
        <template>
          <article-detail
            :is-edit="isEdit"
            :license-info="licenseInfo"
            :type-options="typeOptions"
            :code-options="codeOptions"
            @close:popup="popupClose"
            @depthChildData="depthChildPopup"
          />
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ArticleDetail from './components/ArticleDetail'
import axios from 'axios'
export default {
  name: '',
  components: {
    ArticleDetail
  },
  props: {
    popupVal: {},
    licenseInfo: {}
  },
  data() {
    return {
      isEdit: false,
      typeOptions: [],
      codeOptions: []
    }
  },
  created() {
    this.requestTypeList()
    this.requestCodeList()
  },
  methods: {
    handleClose(done) {
      this.$confirm('작성을 취소 하시겠습니까 ?')
        .then(_ => {
          this.popupClose()
        })
        .catch(_ => {})
    },
    popupClose(popupVal) {
      this.popupVal = popupVal
      this.$emit('close:popup', popupVal)
    },
    depthChildPopup(childData) {
      this.$emit('childData', childData)
    },
    requestTypeList() {
      axios.get('http://localhost/licenses/type')
        .then(res => {
          this.typeOptions = res.data
        })
        .catch(err => {
          console.log(err)
        })
    },
    requestCodeList() {
      axios.get('http://localhost/licenses/code')
        .then(res => {
          this.codeOptions = res.data
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
