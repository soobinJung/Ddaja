<template>
  <div class="cotegory-container">
    <div class="title-style"><font class="title-font">{{ licenseInfo.licenseName }}</font></div>
    <div>
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
    </div> 
  </div>
</template>

<script>

export default {
  name: '',
  components: { },
  data() {
    return {
      licenseInfo: []
    }
  },
  created() {
    this.licenseInfo = this.$session.get('licenseInfo') 
  },
  methods: { }
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

</style>
