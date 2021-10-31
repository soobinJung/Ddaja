<template>
  <div>
    <el-dialog
      title="공지 사항"
      :visible.sync="popupVal"
      width="30%"
      :before-close="handleClose"
    >
      <span>This is a message</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="popupClose()">Cancel</el-button>
        <el-button type="primary" @click="popupClose()">Confirm</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
export default {
  name: 'NoticePopup',
  props: {
    popupVal: false
  },
  data() {
    return {

    }
  }, methods: {
    popupClose() {
      this.$emit('close:notice', false)
    },
    handleClose(done) {
      this.$confirm('정말 끝내시겠습니까 ?')
        .then(_ => {
          this.popupClose()
        })
        .catch(_ => {})
    }
  }
}
</script>
