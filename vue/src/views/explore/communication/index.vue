<template>
    <div class="main-container">
        <el-drawer title="I am the title"
                :visible.sync="popupVal"
                :with-header="false" 
                :before-close="handleClose">
            <div class="div1">
                <span class="span1">토론</span>
            </div>
            <div style = "float:left; width: 100%;">
                <div style = "float:left; width: 40%; height: 100%;">
                    <div class = "div2">
                        <div class = "div2-1"><span> {{question.no}} .  {{question.title}} ( {{question.score}} 점 )  </span></div>
                        <div 
                            v-if = "question.answerOne != '' " 
                            class = "div2-2">
                            <span>1 . {{question.answerOne}} </span>
                        </div>
                        <div 
                            v-if = "question.answerTwo != '' " 
                            class = "div2-2">
                            <span>2 .  {{question.answerTwo}} </span>
                        </div>
                        <div 
                            v-if = "question.answerThr != '' " 
                            class = "div2-2">
                            <span>3 .  {{question.answerThr}} </span>
                        </div>
                        <div 
                            v-if = "question.answerFour != '' " 
                            class = "div2-2">
                            <span>4 .  {{question.answerFour}} </span>
                        </div>
                        <div 
                            v-if = "question.answerFive != '' " 
                            class = "div2-2">
                            <span>5 .  {{question.answerFive}} </span>
                        </div>                                                                
                    </div>
                </div>
                <div style = "float:left; width: 60%; height: 100%;">
                    <div style = "overflow:scroll; height: 750px; overflow-x: hidden">
                        <div v-for="item in items" :key="item.key" style = "padding: 2%;"> 
                            <div style = "">
                                <div style = "text-align:left; padding: 0 1% 1% 0;">
                                    <span style="span1"> {{item.name}} ( {{item.date}} )</span>
                                </div>
                                <div style = "width: 100%; float:left; padding: 1% 1% 1% 0;">
                                    <span style="float:left; padding-left:10px;" class="pointer"> 👍 200 </span>
                                    <span style="float:left; padding-left:10px;" class="pointer"> 👎 100 </span>
                                </div> 
                                <div>
                                    <span style="">
                                    저는 아니라고 생긱 합니다. 왜냐하면 ~~~~~~저는 아니라고 생긱 합니다. 왜냐하면 ~~~~~~~~ 이기 때문이죠. 안그렇습니까 ? 제 생각에는 그렇다고 셍각합니다. SELECT 나 DELETE 나 UPDATE 나 내가 오또케 알아요
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="width: 100%; margin : 2%">
                        <div style="width:78%; float: left">
                            <el-input placeholder = "생각을 공유해보세요" v-model = "replyInput"></el-input>
                        </div>
                        <div style="width: 20%; float: left">
                            <el-button> 의견 저장 </el-button>
                        </div>
                    </div>
                </div>
            </div> 
        </el-drawer>
    </div>
</template>

<script>
import { getQuestion } from '@/ddaja-api/user/explore/communication/Communication.js'

export default {
    name: 'community'

    , data() {
        return { 
            reply : ""
            , question : {
                    id            : 0
                    , no          : 2
                    , score       : 3
                    , answer      : 2
                    , title       : "UML 모델에서 한 사물의 명세가 ㄴㄴㄴㄴ?"
                    , content     : ""
                    , answerOne   : "Association"
                    , answerTwo   : "Dependency"
                    , answerThr   : "Realization"
                    , answerFour  : "Generalization"
                    , answerFive  : ""
                    , created     : false
                    , createdDate : 1639175966000
                    , inUse       : true
                    , isCreated   : false
                    , lid         : 1
                    , sid         : 1
                    , rid         : 26
                }
            ,  items: [ 
                {  name: 'Binsoo' , date: '20200102' }
                , { name: 'Yubin' , date: '20200213' }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Enji'  , date: '20200521'  }
                , { name: 'Boeun' , date: '20200631' }
            ]
            , replyInput : ''
        }
    }
    , props: {
        popupVal : {
            type : Boolean
            , defalut: false
        }
        , questionData    : {
            type : Object
            , defalut : function (){
                return {
                    id            : 0
                    , no          : 2
                    , score       : 3
                    , answer      : 2
                    , title       : "UML 모델에서 한 사물의 명세가 ?"
                    , content     : ""
                    , answerOne   : "Association"
                    , answerTwo   : "Dependency"
                    , answerThr   : "Realization"
                    , answerFour  : "Generalization"
                    , answerFive  : ""
                    , created     : false
                    , createdDate : 1639175966000
                    , inUse       : true
                    , isCreated   : false
                    , lid         : 1
                    , sid         : 1
                    , rid         : 26
                }
            }
        }
    }

    , methods: {
        async fetchList (){
            await this.setQuestion()
            await this.setReply()
        }

        , async setQuestion(){
            await getQuestion({id : this.questionData.id}).then( response => {
                this.question = response.item
            })
        }
        
        , setReply(){

        }

        , popupClose() {  
            this.$emit('close:community', false) 
        }
        , handleClose(){
            this.popupClose()
        }
    }

    , watch : {
        popupVal ( val ){
            if(val){
                this.fetchList();
            }
        }
    }
}

</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap');

.main-container{
    width: 100%; 
    .div1{
        float: left;
        margin: 3% 0 0px 0%;
        width: 93%;
        height: 70px; 
        padding: 8px 0 0 5%;
        text-align: left;
        .span1{
            padding: 15px; 
            font-family: 'Do Hyeon', sans-serif;
            font-size: 50px;
        }
    }
    .div2{  
        width: 93%;
        padding: 2%;
        height: inherit; 
        float: left;
        margin: 1% 3% 1% 3%;
        .div2-1{ 
            float: left;
            width: inherit;
            padding: 7% 1% 7% 1%;
            font-size: 20px;
            text-align: left;
            font-weight: bold;
            span{
                float: left;
            } 
        }
        .div2-2{ 
            float: left;
            width: inherit;
            padding: 1.3%;
            font-size: 13px;
            font-weight: bold;
            text-align: left;
            span{
                padding: 2.5% 0 0 1%;
                font-size: 16px;
                float: left;
            } 
        }
    }
    .div3{
        width: 93%;
        padding: 2%;
        height: inherit; 
        float: left;
        margin: 3% 3% 0% 3%; 
            text-align: left;
        border: 1px solid rgb(226, 226, 226); 
        .span1{
            font-weight: bold;
            font-size: 15px;
        }
    }
    .div4{
        width: 93%; 
        height: inherit; 
        padding: 2% 2% 2% 2%;
        float: left;
        margin: 0% 3% 3% 3%;
        border: 1px solid rgb(226, 226, 226); 
        .textarea1{ 
            width: inherit;
            outline: none; 
            height: 50px;
            border: 1px solid rgb(179, 29, 29);  
        }
        .btn{
            margin:12px 0 0 0; 
            float:right;
        }
    }
    .div5{
        width: 93%; 
        height:400px;
        padding: 3% 3% 3% 3%;
        float: left;
        margin: 0% 0 3% 3%;
        overflow:scroll;
        .div5-1{
            margin : 0 0 3px 0;
            border: 1px solid rgb(226, 226, 226);
            overflow:hidden;
            height :auto;
            float: left;
            .div5-1-1{ 
                width: 28%;
                float: left; 
                .div5-1-1-1{
                    height: 100px;
                    width: 135px;
                    padding: 0 15px 0 15px;
                    border: 1px solid rgb(162, 199, 255);
                    width: 100%; 
                    float: left;
                    padding: 5% 0 0 5%; 
                }
                .div5-1-1-2, .div5-1-1-3{
                    width: 100%; 
                    float: left;
                    padding: 5% 0 0 5%; 
                    .span1{
                        float: left;
                        font-size: 13px;
                        font-weight: bold;
                    }
                }
            }
            .div5-1-2{ 
                width: 70%;
                float: left;
                padding: 3%;
                .span1 {
                    float: left;
                    font-size: 14px;
                    font-weight: bold;
                }
                .div5-1-2-2{
                    padding: 7% 0 0 0;
                    float: right; 
                }
            }
        }
    }
    .pointer{
        cursor:pointer;
    }
}  

::v-deep .el-drawer{
    width: 85% !important;
}
</style>
