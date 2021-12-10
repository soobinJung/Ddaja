<template>
    <div>
        <el-dialog 
        :visible.sync="popupVal" 
        title=""
        :before-close="handleClose"> 
        <div class="div1">
            <div class="div1-1">
                <span class="span1">{{rName}}</span>
            </div> 
        </div> 
        <div 
            class = "div2" 
            v-for = "(quiz) in questionList" 
            :key  = "quiz.id" >
            <div class="div2-1">
                <div class="div2-1-1">
                    <span class="span1"> {{quiz.no}}. {{quiz.title}}  </span>  
                </div> 
                <div class="div2-1-2" v-if="quiz.answerOne != ''">
                    <span class="span1"> <el-checkbox v-model="quiz.answer[0]" @change="checkAnswer(quiz, 0)">1 . {{quiz.answerOne}}</el-checkbox> </span> 
                </div>  
                <div class="div2-1-2" v-if="quiz.answerTwo != ''">
                    <span class="span1"> <el-checkbox v-model="quiz.answer[1]" @change="checkAnswer(quiz, 1)" >2 . {{quiz.answerTwo}}</el-checkbox> </span> 
                </div>  
                <div class="div2-1-2" v-if="quiz.answerThr != ''">
                    <span class="span1"> <el-checkbox v-model="quiz.answer[2]" @change="checkAnswer(quiz, 2)" >3 . {{quiz.answerThr}}</el-checkbox> </span> 
                </div>  
                <div class="div2-1-2" v-if="quiz.answerFour != ''">
                    <span class="span1"> <el-checkbox v-model="quiz.answer[3]" @change="checkAnswer(quiz, 3)" >4 . {{quiz.answerFour}}</el-checkbox> </span> 
                </div>  
                <div class="div2-1-2" v-if="quiz.answerFive != ''">
                    <span class="span1"> <el-checkbox v-model="quiz.answer[4]" @change="checkAnswer(quiz, 4)" >5 . {{quiz.answerFive}}</el-checkbox> </span> 
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
import { fetchListByQuestions } from '@/ddaja-api/user/explore/examination/Examination.js'
import community from '@/views/explore/communication'

export default {
    name: 'examinationPopup'
    , data() {
        return { 
            communityPopupVal : false
            , quizType : 1
            , answerTest: false
            , questionList : []
        }
    }
    , components : {
        community
    }
    , props: {
        popupVal : {
            type : Boolean
            , defalut: false
        } 
        , rID    : {
            type : Number
            , defalut : 0
        }
        , rName    : {
            type : String
            , defalut : ''
        } 
    }
    
    , watch: {
        rID ( val ){
            if(val != 0){
                this.fetchList()
            }
        }
    }
    
    , methods: { 
        async fetchList(){
            let param = {
                licenseID : 0,
                roundID   : this.rID || 0,
                SubjectID :  0,
            }
            await fetchListByQuestions(param).then( response => {
                response.items.forEach( x => {
                    this.questionList.push({
                        id           : x.item.id
                        , no         : x.item.no
                        , title      : x.item.title
                        , content    : x.item.content
                        , answerOne  : x.item.answerOne
                        , answerTwo  : x.item.answerTwo
                        , answerThr  : x.item.answerThr
                        , answerFour : x.item.answerFour
                        , answerFive : x.item.answerFive
                        , answer     : [false, false, false, false, false]
                        , created    : x.item.created
                        , createdDate: x.item.createdDate
                        , inUse      : x.item.inUse
                        , isCreated  : x.item.isCreated
                        , score      : x.item.score
                        , lid        : x.item.lid
                        , rid        : x.item.rid
                        , sid        : x.item.sid
                    })
                })
            })
        }

        , checkAnswer (quiz, index){
            let answer = []
            quiz.answer.forEach( (x, i) => {
                answer.push(index === i ? true : false)
            })
            quiz.answer = answer
        }

        , popupClose(val) { 
            // 시험 popup 닫는다.
            this.$emit('close:examination', val) 
        }

        , handleClose(done) {
            // 클릭 이벤트가 popup 벗어나면 확인창.
        this.$confirm('정말 끝내시겠습니까 ?')
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