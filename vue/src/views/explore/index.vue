<template>
  <div class="cotegory-container">
    <div class="title-style">
      <font class="title-font">{{ licenseInfo.name }} - {{ licenseInfo.type === 'WRITING' ? "필기" : licenseInfo.type === "PERFORM" ? "실기" : "" }}</font>
    </div>

    <div class="block1">
      <div class="block4"> <i class="el-icon-edit" /> <span class="demonstration">기출 문제 - 모든 문제</span></div>
      <el-carousel height="200px">
        <el-carousel-item v-for="item in exploreAllOptions" :key="item.id">
          <router-link to="/explore/examination">
            <div style="text-align: center; ">
              <div style="padding : 60px 0 0 0 "><span class="span1">{{ item.title }}</span></div>
              <div style="padding : 20px 0 0 0 "><span class="span2">{{ item.count }}</span></div>
            </div>
          </router-link>
        </el-carousel-item>
      </el-carousel>

      <div class="block3">
        <div class="block4"> <i class="el-icon-info" /> <span class="span4"> {{ licenseInfo.licenseName }} 자격증의 정보입니다. 오류가 존재할 수 있습니다.</span></div>
        <el-carousel height="240px">
          <div style="text-align: left;">
            <div style="padding : 0 3% 3% 3%">
              <span class="span3">
                {{ licenseInfo.name }} 자격증은 <el-button size="small">{{ licenseInfo.agency }}</el-button> 에서 주최하며,

                <span v-if="licenseIfs.length > 0">
                  응시 조건은
                  <span v-for="item, index in licenseIfs" :key="item.id">
                    <el-button size="small">{{ item.name }}</el-button>
                    <span v-if="index != licenseIfs.length-1">, </span>
                  </span>
                  입니다.
                </span>
                <span v-else>응시 조건은 없습니다.</span>

                평균 점수가 <el-button size="small">{{ licenseInfo.passScore }}</el-button> 를 넘어야 하며,
                응시료는 <el-button size="small">{{ licenseInfo.examFee }}</el-button> 이며
                합격률은 <el-button size="small">5,000,000 / 453,250</el-button> 입니다.
                <br>
                공부해야 하는 과목들은
                <span v-for="item, index in licenseInfo.subjects" :key="item.id">
                  <el-tooltip :content="item.minScoreMsg" placement="top">
                    <el-button size="small">{{ item.name }}</el-button>
                  </el-tooltip>
                  <span v-if="index != licenseInfo.subjects.length-1">, </span>
                </span>
                입니다.
                <br>
              </span>
            </div>
          </div>
        </el-carousel>
      </div>
    </div>

    <div class="block1">
      <div class="block4"> <i class="el-icon-edit" /> <span class="demonstration">기출 문제 - 한 문제</span></div>
      <el-carousel height="200px">
        <el-carousel-item v-for="item in exploreOneOptions" :key="item.id">
          <router-link to="/explore/examination-one">
            <div style="text-align: center; ">
              <div style="padding : 60px 0 0 0 "><span class="span1">{{ item.title }}</span></div>
              <div style="padding : 20px 0 0 0 "><span class="span2">{{ item.count }}</span></div>
            </div>
          </router-link>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="block1">
      <div class="block4"> <i class="el-icon-edit" /> <span class="demonstration">단어 암기</span></div>
      <el-carousel height="200px">
        <el-carousel-item v-for="item in exploreWordOptions" :key="item.id">
          <router-link to="/explore/examination-one">
            <div style="text-align: center; ">
              <div style="padding : 60px 0 0 0 "><span class="span1">{{ item.title }}</span></div>
              <div style="padding : 20px 0 0 0 "><span class="span2">{{ item.count }}</span></div>
            </div>
          </router-link>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="block2">
      <div class="block4"><i class="el-icon-success" /><span class="demonstration"> BEST 합격 후기 </span></div>
      <el-carousel height="525px">
        <el-carousel-item>
          <router-link to="/explore/acceptance-review">
            <h3 class="small">sss</h3>
          </router-link>
        </el-carousel-item>
      </el-carousel>
    </div>

    <!-- <div>
        <router-link to="/explore/examination-one">
          <div class="div1 div-common">
            <font class="font1"> 한 문 제 씩 탐 험 해 보 기 </font>
          </div>
        </router-link>
        <router-link to="/explore/examination-word">
        <div class="div2 div-common">
          <font class="font1">단 어 암 기</font>
        </div>
        </router-link>
        <router-link to="/explore/examination">
        <div class="div3 div-common">
          <font class="font1">모 의 고 사</font>
          </div>
      </router-link>
    </div>
    <div>
      <router-link to="/explore/acceptance-review">
      <div class="div4 div-common">
        <font class="font1">합 격 후 기</font>
        </div>
        </router-link>
      <router-link to="/explore/license-information">
        <div class="div5 div-common">
          <font class="font1">자 격 증 정 보</font>
        </div>
      </router-link>
      <router-link to="">
        <div class="div6 div-common">
          <font class="font1">-</font>
        </div>
      </router-link>
    </div>  -->
  </div>
</template>

<script>
import { fetchLicense, fetchLicenseIf } from '@/ddaja-api/user/explore/explore/explore'

export default {
  name: '',
  components: { },
  data() {
    return {
      licenseInfo: [],
      licenseIfs: [],
      exploreAllOptions: [
        {
          id: 1,
          title: '나의 도전 횟수',
          count: 34
        },
        {
          id: 2,
          title: '모든 도전 횟수',
          count: 2000
        }
      ],

      exploreOneOptions: [
        {
          id: 1,
          title: '나의 도전 횟수',
          count: 5
        },
        {
          id: 2,
          title: '모든 도전 횟수',
          count: 2012
        }
      ],

      exploreWordOptions: [
        {
          id: 1,
          title: '나의 도전 횟수',
          count: 20
        },
        {
          id: 2,
          title: '모든 도전 횟수',
          count: 5001
        }
      ],

      infoOptions: [
        {
          id: 1,
          title: '주최',
          content: 'Qnet'
        },
        {
          id: 2,
          title: '응시자 수 / 합격자 수',
          content: '100000 / 524'
        },
        {
          id: 3,
          title: '필요한 학점',
          content: '400'
        }
      ]
    }
  },
  created() {
    this.licenseInfo = this.$session.get('licenseInfo')
    this.setLicenseInfo()
    this.setLicenseIf()
  },
  methods: {
    async setLicenseInfo() {
      var param = {
        licenseID: this.licenseInfo.licenseID
      }

      await fetchLicense(param).then(response => {
        var subjects = []
        // console.log(response.item)
        response.item.subjects.forEach(x => {
          x.minScoreMsg = '최소 점수 : ' + x.minScore
          subjects.push(x)
        })
        this.licenseInfo = {
          id: response.item.id,
          name: response.item.name,
          code: response.item.code,
          type: response.item.type,
          agency: response.item.agency,
          examFee: response.item.examFee,
          passScore: response.item.passScore,
          inUse: response.item.inUse,
          createdDate: response.item.createdDate,
          modifiedDate: response.item.modifiedDate,
          subjects: subjects
        }
      })
    },

    async setLicenseIf() {
      var param = {
        licenseID: this.licenseInfo.licenseID
      }

      await fetchLicenseIf(param).then(response => {
        var licenseIfs = []
        response.items.forEach(x => {
          licenseIfs.push({
            name: x.item.licenseIf,
            id: x.item.id
          })
        })
        this.licenseIfs = licenseIfs

        console.log(this.licenseIfs)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap');
.cotegory-container {
  text-align: left;
  padding: 30px;
  overflow:auto;
  .title-style{
    margin-top: 5px;
    margin-bottom: 5px;
    color: rgb(0, 0, 0);
    margin-left: 1%;
    margin-right: 2%;
    padding: 1.5% 2% 1.5% 2%;
    .title-font{
      font-size: 50px;
      font-family: 'Do Hyeon', sans-serif;}
  }
  .div-common{
    border-radius: 40px 80px / 80px 40px;
    float: left; width: 31%;
    height: 230px;
    margin: 1%;
    text-align: center;
    padding-top:85px
  }
  .div1{ border: 10px solid rgb(255, 255, 255); background-color:#e9bcc5;}
  .div1:hover { background-color:#f75273;}
  .div2{ border: 10px solid rgb(255, 255, 255);  background-color:#f5da9f;}
  .div2:hover { background-color:#fcc141;}
  .div3{ border: 10px solid rgb(255, 255, 255);  background-color:#ecf7b3;}
  .div3:hover { background-color:#daf74b;}
  .div4{ border: 10px solid rgb(255, 255, 255);  background-color:#b7ffa9;}
  .div4:hover { background-color:#6af34e;}
  .div5{ border: 10px solid rgb(255, 255, 255);  background-color:#a1cff5;}
  .div5:hover { background-color:#4caaf7;}
  .div6{ border: 10px solid rgb(255, 255, 255);  background-color:#5a70ee;}
  .div6:hover { background-color:#2645f7;}
  .font1{ font-size: 40px;  font-family: 'Do Hyeon', sans-serif; }
}

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #e2ecfa;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #ffeceb;
  }

  .block1{
    width: 200px;
    float: left;
    margin: 2%;
  }

    .block2{
    width: 900px;
    float: left;
    margin: 2%;
  }

  .block3{
    width: 750px;
    float: left;
    margin: 20% 2% 2% 2%;
  }

  .block4{
    padding: 10px 10px 20px 0;

      .demonstration{
        font-size: 17px;
        font-weight: bold;
      }
  }

.span1{
    font-weight: bold;
    color: #000000;
    font-size: 18px;
    opacity: 0.75;
}

.span2{
    color: #3b3b3b;
    font-size: 20px;
    opacity: 0.75;
    font-weight: bold;
}

.span3{
    color: #3b3b3b;
    font-size: 20px;
    opacity: 0.75;
    font-weight: bold;
    line-height : 50px;
}

.span4{
    color: #000000;
    font-size: 15px;
    font-weight: bold;
    line-height : 50px;
}
</style>
