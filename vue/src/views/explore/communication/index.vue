<template>
    <div class="main-container">
        <el-drawer title="I am the title"
                :visible.sync="popupVal"
                :with-header="false"
                :before-close="handleClose">
            <div class="div1">
                <span class="span1">토론</span>
            </div>
            <div class="div2">
                <div class="div2-1"><span>1. SQL 쿼리에서 DATA 를 가지고 올 때 사용하는 명령문은 ?</span></div>
                <div class="div2-2"><span>1. SELECT</span></div>
                <div class="div2-2"><span>2. SELECT</span></div>
                <div class="div2-2"><span>3. SELECT</span></div>
                <div class="div2-2"><span>4. SELECT</span></div>
            </div>
            <div class="div3">
                <span class="span1"> 의견을 함께해주세요 <i class="el-icon-edit"></i> </span> 
            </div> 
            <div class="div4">
                <el-input
                type="textarea"
                clear="textarea1"
                :autosize="{ minRows: 3, maxRows: 3}"
                placeholder="Please input"
                v-model="reply">
                </el-input>
                <el-button class="btn">저장</el-button>
            </div>
            <div class="div5">
                <!-- forEach 돌리세요.-->
                <div v-for="item in items" :key="item.key" class="div5-1"> 
                    <div class="div5-1-1">
                        <div class="div5-1-1-1">
                            <i class="el-icon-s-custom"></i>
                        </div>
                        <div class="div5-1-1-2">
                            <span class="span1"> {{item.name}} ( {{item.date}} )</span>
                        </div>
                        <div class="div5-1-1-3">
                            <span style="float:left; padding-left:10px;"   class="pointer"> 👍 200 </span>
                            <span style="float:right; padding-right:10px;" class="pointer">👎 100 </span>
                        </div> 
                    </div>
                    <div class="div5-1-2"> 
                        <div class="div5-1-2-1">
                            <span class="span1">저는 아니라고 생긱 합니다. 왜냐하면 ~~~~~~저는 아니라고 생긱 합니다. 왜냐하면 ~~~~~~~~ 이기 때문이죠. 안그렇습니까 ? 제 생각에는 그렇다고 셍각합니다. SELECT 나 DELETE 나 UPDATE 나 내가 오또케 알아요</span>
                        </div>
                        <div class="div5-1-2-2 pointer">
                            <i class="el-icon-delete"></i>
                        </div>
                    </div>
                </div>
            <!-- forEach 돌리세요.--> 
            </div>
        </el-drawer>
    </div>
</template>

<script>

export default {
    name: 'community'
    , data() {
        return { 
            reply : ""
            ,  items: [ 
                {  name: 'Binsoo' , date: '20200102' }
                , { name: 'Yubin' , date: '20200213' }
                , { name: 'Enji' , date: '20200521'  }
                , { name: 'Boeun' , date: '20200631' }
            ]
        }
    }
    , props: {
        popupVal: false
    }
    , methods: {
        popupClose() {  
            this.$emit('close:community', false) 
        }
        , handleClose(){
            this.popupClose()
        }
    }
}

</script>

<style lang="scss" scoped>

@import url('https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap');

.main-container{
    width: 100%; 
    .div1{
        float: left;
        margin: 3% 3% 0px 3%;
        border: 3px solid rgb(175, 175, 175);
        border-radius: 40px 80px / 80px 40px;
        background-color: rgb(236, 231, 231);
        width: 93%;
        height: 70px; 
        padding-top: 8px;
        .span1{
            font-size: 30px; 
            padding: 15px; 
            font-size: 50px;
            font-family: "Kirang Haerang", cursive;
        }
    }
    .div2{  
        width: 93%;
        padding: 2%;
        height: inherit; 
        float: left;
        margin: 3% 3% 3% 3%;
        .div2-1{ 
            float: left;
            width: inherit;
            padding: 2%;
            font-size: 15px;
            font-weight: bold;
            span{
                float: left;
            } 
        }
        .div2-2{ 
            float: left;
            width: inherit;
            padding: 2%;
            font-size: 13px;
            font-weight: bold;
            span{
                padding-left: 5%;
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
            height:auto;
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
</style>
