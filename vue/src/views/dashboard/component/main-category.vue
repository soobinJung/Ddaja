<template>
  <div class="main-category-div">
    <div class="category-div">
      <div>
        <router-link to="/explore/">
          <img
            :src="LOGO_JCSG"
            class="mans-img"
            @click="sessionSave(jeongboCheoliSanupGisa)"
            @mouseenter="LOGO_JCSG = JCSG_H"
            @mouseleave="LOGO_JCSG = JCSG"
          >
        </router-link>
      </div>
      <div>
        <router-link to="/explore">
          <img
            :src="LOGO_JCG"
            class="mans-img"
            @click="sessionSave(jeongboCheoliGisa)"
            @mouseenter="LOGO_JCG = JCG_H"
            @mouseleave="LOGO_JCG = JCG"
          >
        </router-link>
      </div>
      <div>
        <router-link to="/explore">
          <img
            :src="LOGO_CUO"
            class="mans-img"
            @click="sessionSave(computerUtilizeOne)"
            @mouseenter="LOGO_CUO = CUO_H"
            @mouseleave="LOGO_CUO = CUO"
          >
        </router-link>
      </div>
      <div>
        <router-link to="/explore">
          <img
            :src="LOGO_CUT"
            class="mans-img"
            @click="sessionSave(computerUtilizeTwo)"
            @mouseenter="LOGO_CUT = CUT_H"
            @mouseleave="LOGO_CUT = CUT"
          >
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>

import CUO from '@/assets/mascot/computer-utilize-one.png'
import CUT from '@/assets/mascot/computer-utilize-two.png'
import JCG from '@/assets/mascot/jeongbo-cheoli-gisa.png'
import JCSG from '@/assets/mascot/jeongbo-cheoli-sanup-gisa.png'
import CUO_H from '@/assets/mascot/computer-utilize-one-hover.png'
import CUT_H from '@/assets/mascot/computer-utilize-two-hover.png'
import JCG_H from '@/assets/mascot/jeongbo-cheoli-gisa-hover.png'
import JCSG_H from '@/assets/mascot/jeongbo-cheoli-sanup-gisa-hover.png'

export default {
  data() {
    return {
      LOGO_CUO: CUO,
      LOGO_CUT: CUT,
      LOGO_JCG: JCG,
      LOGO_JCSG: JCSG,
      CUO_H: CUO_H,
      CUT_H: CUT_H,
      JCG_H: JCG_H,
      JCSG_H: JCSG_H,
      CUO: CUO,
      CUT: CUT,
      JCG: JCG,
      JCSG: JCSG,
      jeongboCheoliGisa: {
        licenseName: '정보처리 기사',
        licenseSeq: '1',
        licenseID: '2',
        subject: [
          { 'subjectid': 1,
            'subjectName': '소프트웨어 설계'
          },
          { 'subjectid': 2,
            'subjectName': ' 소프트웨어 개발'
          },
          { 'subjectid': 3,
            'subjectName': '데이터베이스 구축'
          },
          { 'subjectid': 4,
            'subjectName': '프로그래밍 언어 활용'
          },
          { 'subjectid': 5,
            'subjectName': '정보시스템 구축 관리'
          }
        ]
      },
      jeongboCheoliSanupGisa: {
        licenseName: '정보처리 산업기사',
        licenseSeq: '3',
        licenseID: '3',
        subject: [
          { 'subjectid': 1,
            'subjectName': '데이터베이스'
          },
          { 'subjectid': 2,
            'subjectName': '전자계산기구조'
          },
          { 'subjectid': 3,
            'subjectName': '시스템분석 설계'
          },
          { 'subjectid': 4,
            'subjectName': '운영체제'
          },
          { 'subjectid': 5,
            'subjectName': '정보통신개론'
          }
        ]
      },
      computerUtilizeOne: {
        licenseName: '컴퓨터 활용 1급',
        licenseSeq: '5',
        licenseID: '5',
        subject: [
          { 'subjectid': 1,
            'subjectName': '컴퓨터 일반'
          },
          { 'subjectid': 2,
            'subjectName': '스프레드 시트'
          },
          { 'subjectid': 3,
            'subjectName': '데이터 베이스 일반'
          }
        ]
      },
      computerUtilizeTwo: {
        licenseName: '컴퓨터 활용 2급',
        licenseSeq: '7',
        licenseID: '7',
        subject: [
          { 'subjectid': 1,
            'subjectName': '컴퓨터 일반'
          },
          { 'subjectid': 2,
            'subjectName': '스프레드 시트'
          }
        ]
      }
    }
  },
  methods: {
    sessionSave(licenseInfo) {
      this.$session.set('licenseInfo', licenseInfo)
    }
  }
}
</script>

<style lang="scss" scoped>
* {
  background-color: rgb(11, 8, 49);
}
.main-category-div {
  padding: 300px 0 500px 0;
  .category-div {
    padding-right: 5.8%;
    padding-left: 5.8%;
    max-width: 100%;
    float: left;
    height: 100%;
    div {
      width: 25%;
      height: 25%;
      float: left;
    }
  }
}
.mans-img{
  width: 420px;
  height: 420px;
}
</style>
