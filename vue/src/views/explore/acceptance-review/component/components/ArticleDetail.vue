<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" class="form-container">
      <div class="createPost-main-container">
        <el-row>
          <Warning />
          <el-col :span="24">
            <el-form-item style="margin-bottom: 20px;" prop="successTitle">
              <MDinput v-model="postForm.successTitle" :maxlength="100" name="name" required>
                Title
              </MDinput>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item style="margin-bottom: 40px;" prop="successScore">
              <MDinput v-model="postForm.successScore" :maxlength="100" name="name" required>
                합격 점수
              </MDinput>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item prop="successComment" style="margin-bottom: 30px;">
          <Tinymce ref="editor" v-model="postForm.successComment" :height="400" />
        </el-form-item>
        <el-row>
          <el-col :span="24" align="right">
            <el-button @click="saveSuccessComment(false)">저장 하기</el-button>
          </el-col>
        </el-row>
      </div>
    </el-form>
  </div>
</template>

<script>
import Tinymce from '@/components/Tinymce'
import MDinput from '@/components/MDinput'
import Warning from './Warning'
import { insertSuccessComment } from '@/ddaja-api/user/explore/acceptance-review/acceptanceReview'

export default {
  name: 'ArticleDetail',
  components: { Tinymce, MDinput, Warning },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      postForm: {
        id: 0,
        lID: 0,
        uID: 0,
        likeCount: 0,
        successTitle: '',
        successComment: '',
        successScore: 0
      }
    }
  },

  methods: {
    async saveSuccessComment() {
      var param = {
        lID: this.$session.get('licenseInfo').licenseID,
        uID: 3,
        likeCount: 0,
        inUse: true,
        successTitle: this.postForm.successTitle,
        successComment: this.postForm.successComment,
        successScore: this.postForm.successScore
      }

      await insertSuccessComment(param).then(response => {
        console.log(response)
      })
    },

    popupClose(val) {
      this.$emit('close:popup', val)
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
</style>
