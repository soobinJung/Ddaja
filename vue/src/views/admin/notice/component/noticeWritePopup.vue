<template>
  <div>
    <el-dialog
      :visible.sync="popupVal"
      :before-close="handleClose"
    >
      <div>
        <template>
          <article-detail
            :is-edit="false"
            @close:popup="popupClose"
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
  }, props: {
    popupVal: {}
  },
  data() {
    return {

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
    popupClose() {
      this.$emit('close:popup', false)
    }
  }
}
</script>
