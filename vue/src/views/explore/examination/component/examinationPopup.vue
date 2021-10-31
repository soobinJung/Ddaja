<template>
    <div>
        <el-dialog 
        :visible.sync="popupVal" 
        title=""
        :before-close="handleClose"> 
        <div class="div1">
            <div class="div1-1">
                <span class="span1">2020년 10월 11일 3회차 모의고사</span>
            </div> 
        </div> 
        <div class="div2" v-for="(quiz) in testJson" :key="quiz.examinationNo" >
            <div class="div2-1">
                <div class="div2-1-1">
                    <span class="span1"> {{quiz.examinationNo}}. {{quiz.examinationQuestion}}  </span>  
                </div> 
                <div class="div2-1-2" v-for="(answer, index) in quiz.example" :key="answer">
                    <span class="span1"> <el-checkbox v-model="answerTest" >{{index+1}} . {{answer}}</el-checkbox> </span> 
                </div>  
            </div>
        </div>
        <span slot="footer" class="dialog-footer"> 
            <el-button type="primary" @click="popupClose(false)">채 점</el-button> 
        </span>
        </el-dialog>
        <community
            :popup-val="communityPopupVal"
            @close:community="communityPopupStatus"
        />
    </div> 
</template>

<script>
import testJson from '@/assets/jsonFile/subjectExaminationTestJson1'
import community from '@/views/explore/communication'

export default {
    name: 'examinationPopup'
    , data() {
        return { 
            testJson : testJson
            , communityPopupVal : false
            , quizType : 1
            , answerTest: false
        }
    }
    , components : {
        testJson
        , community
    }
    , props: {
        popupVal: {} 
    }
    , watch: { }
    ,methods: { 
        popupClose(val) { 
            // 시험 popup 닫는다.
            this.$emit('close:examination', val) 
        }
        , handleClose(done) {
            // 클릭 이벤트가 popup 벗어나면 확인창.
        this.$confirm('정말 끝내시겠습니까 ? 😡')
            .then(_ => {  
                this.popupClose(false);
            })
            .catch(_ => {});
        } 
        , communityPopupStatus(val){
            if(val){
                // 토론창 열기 
                this.communityPopupVal = val
            }else{
                // 토론창 닫기
                this.communityPopupVal = val
            }
        }
    }
}
</script>
<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap');
.div1{
    width: 100%;
    height: 30px; 
    .div1-1{ 
        width: 100%;
        float: left;
        .span1{
            float: left;
            font-size: 40px;
            font-family: 'Do Hyeon', sans-serif;
            color: black;
            padding: 0 0 0 5%;
        }
    }
}
.div2{
    .div2-1{
        width: 93%;
        padding: 2%;
        height: inherit; 
        float: left;
        margin: 3% 3% 3% 3%;
        .div2-1-1{ 
            float: left;
            width: inherit;
            padding: 2%;
            font-size: 15px;
            font-weight: bold;
            .span1{
                float: left;
            } 
        }
        .div2-1-2{ 
            float: left;
            width: inherit;
            padding: 2%;
            font-size: 13px;
            font-weight: bold;
            .span1{
                padding-left: 5%;
                float: left;
            }
        }
    }
}
</style>