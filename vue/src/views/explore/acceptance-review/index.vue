<template>
<div class="main-container">
    <div class="div1 main-title">
        <div class="div1-1">
            <font class="title-font1">
                합격 리뷰
            </font>
            <font font class="title-font2"> 
                - {{ licenseInfo.licenseName }}
            </font>
        </div>
        <div class="div1-2">
            <el-button type="success" class="btn1" @click="popupState(true)">
                합격 후기 쓰러 가기
            </el-button>  
        </div>
    </div>
    <div class="div2">
        <el-table
        :data="tableData"
        style="width: 100%"
        >
            <el-table-column type="expand">
                <template slot-scope="props">
                    <p class="p1">
                        {{ props.row.title }}
                    </p>
                    <p class="p2">
                        <i class="el-icon-caret-right"></i> 합격 점수: {{ props.row.scrore }}
                    </p>
                    <p class="p3">
                        {{ props.row.content }}
                </p> 
                </template>
            </el-table-column>
            <el-table-column
                label="REVIEW TITLE"
                prop="title">
            </el-table-column>
            <el-table-column
                label="시험명"
                prop="name">
            </el-table-column>
            <el-table-column
                label="후기 작성일"
                prop="date">
            </el-table-column>
        </el-table>
    </div>
    <div class="div3">
        <el-pagination
            class="paging"
            layout="prev, pager, next"
            :total="50">
        </el-pagination>
    </div>
    <popup 
        :popup-val="popupVal" 
        @close:popup="popupState"
    />
</div>
</template>

<script>
import popup from './component/reviewWritePopup.vue'
export default {
    name: ''
    , components: {
        popup
    }
    , data() {
        return {
        tableData: [
            { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '80'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '90'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '85'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '84'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '87'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '95'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '82'}
            , { date: '2016-05-03',  name: '정보처리 산업기사 2회차', title: '저는 따자만 주구장창 풀고 합격했어요', content: '비 전공자인 저는 따자만 주구장창 풀고 합격했어요 너무 유용하게 잘 사용 했습니다', scrore: '86'}
        ]
        , popupVal : false
        }
    }
    , created() {
        this.licenseInfo = this.$session.get('licenseInfo') 
        this.subject = this.licenseInfo.subject
    }
    , methods: { 
        popupState(value) {  
            this.popupVal = value
        }
    }
}
</script>

<style lang="scss" scoped>

@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap'); 

.main-container{
    width: 100%;
    text-align: center; 
    padding: 30px;
    overflow:auto;
    background-color: rgb(255, 255, 255);
    .main-title{
        text-align: left;  
        margin-top: 5px;
        margin-bottom: 30px; 
        color: rgb(0, 0, 0);
        margin-left: 1%;
        margin-right: 1%;
        padding: 1.5% 2% 0% 4%;
        .div1-1{
            width: 80%;
            float: left; 
            .title-font1{
                font-size: 50px;   
                font-family: 'Do Hyeon', sans-serif;
            }
            .title-font2{
                font-size: 40px;
                padding: 0 0 0 30px; 
                font-family: 'Do Hyeon', sans-serif;
            }
        }
        .div1-2{
            width: 20%;
            float: left; 
            .btn1{
                float: right;
                height: 50px;
                width: 200px;
            }
        } 
    }
    .div2{
        padding: 1.5% 2% 0% 4%;
        margin: 0 0 30px 0 ;  
        float:left;
        width: 100%;
        max-height:550px;
        .p1{ font-size: 20px; font-weight: bold; }
        .p2{ font-size: 14px; font-weight: bold; }
        .p3{ padding: 1.5%; font-size: 14px; }
    }
    .div3{
        float:left;
        padding: 2% 11% 2% 0;
        text-align: center;
        position: fixed; 
        bottom: 0; 
        width: 100%; 
        .paging{ display: inline-block;}
    }
} 
</style>