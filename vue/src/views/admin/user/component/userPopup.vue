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
            :user-id="userId"
            @close:popup="popupClose"
            @test="test"
          />
        </template>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import ArticleDetail from './components/ArticleDetail'
export default {
  name: '',
  components: {
    ArticleDetail
  },
  props: {
    popupVal: {},
    userId: {}
  },
  data() {
    return {
      isEdit: false
    }
  },
  created() { },
  methods: {
    handleClose(done) {
      this.$confirm('작성을 취소 하시겠습니까 ?')
        .then(_ => {
          this.popupClose()
        })
        .catch(_ => {})
    },
    popupClose(popupVal) {
      alert(`aaaa`)
      this.popupVal = popupVal
      this.$emit('close:popup', popupVal)
      alert(`asfs`)
    },
    test(test) {
      alert('bb' + test)
      this.$emit('test', test)
    }
  }
}
</script>
