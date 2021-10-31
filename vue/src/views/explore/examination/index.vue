<template>
    <div class="main-container">
        <div class="main-title">
            <font class="font1">모의 고사</font><font font class="font2"> - {{ licenseInfo.licenseName }}</font>
        </div>
        <div class="div1">
            <el-radio v-model="radio1" label="1" border>필 기</el-radio>
            <el-radio v-model="radio1" label="2" border>실 기</el-radio>
        </div>
        <div class="div2">  
            <el-table
                :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                style="width: 100%; height: 100%;">
                <el-table-column
                    label="Date"
                    prop="date">
                </el-table-column>
                <el-table-column
                    label="Name"
                    prop="name">
                </el-table-column>
                <el-table-column align="right">
                    <template slot="header" slot-scope="{}">
                        <el-input
                        v-model="search"
                        size="mini"
                        placeholder="Type to search"/>
                    </template>
                    <template slot-scope="scope">
                        <el-button
                        size="mini"
                        @click="examPopupStatus(scope.$index, scope.row, true)">응시 하기</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <examinationPopup
        :popup-val="examPopupStatusVal"
        @close:examination="examPopupStatus"
        />
        <gradingPopup
        :popup-val="gradingPopupStatusVal"
        @close:examination="gradingPopupStatus"
        />
    </div>
</template>

<script>

import examinationPopup from '@/views/explore/examination/component/examinationPopup'
import gradingPopup from '@/views/explore/examination/component/gradingPopup'

export default {
    name: ''
    , components: {
        examinationPopup
        , gradingPopup
    }
    , data() {
        return {
            tableData: [ 
                { date: '2011-05-03', name: '정보처리 산업기사 필기 / 1회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2012-05-03', name: '정보처리 산업기사 필기 / 2회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2013-05-03', name: '정보처리 산업기사 필기 / 3회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2014-05-03', name: '정보처리 산업기사 필기 / 4회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2015-05-03', name: '정보처리 산업기사 필기 / 5회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2016-05-03', name: '정보처리 산업기사 필기 / 6회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2017-05-03', name: '정보처리 산업기사 필기 / 7회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2018-05-03', name: '정보처리 산업기사 필기 / 8회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2019-05-03', name: '정보처리 산업기사 필기 / 9회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2011-05-03', name: '정보처리 산업기사 필기 / 10회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2012-05-03', name: '정보처리 산업기사 필기 / 11회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
                , { date: '2013-05-03', name: '정보처리 산업기사 필기 / 12회차 모의고사', address: 'No. 189, Grove St, Los Angeles'  }
            ]
            , search: ''
            , radio1: '1'
            , examPopupStatusVal : false
            , gradingPopupStatusVal : false
        }
    }
    , created() {
        this.licenseInfo = this.$session.get('licenseInfo') 
        this.subject = this.licenseInfo.subject
    }
    , methods: {
        examPopupStatus(index, row, val) {
            // console.log(index, row); 
            if(val == true){
                this.examPopupStatusVal = val;
            }else{
                this.examPopupStatusVal = val;
                this.gradingPopupStatus(true);
            }
        }
        , gradingPopupStatus(val){
            this.gradingPopupStatusVal = val;
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
        .font1{
            font-size: 50px;   
            font-family: 'Do Hyeon', sans-serif;
        }
        .font2{
            font-size: 40px;
            padding: 0 0 0 30px; 
            font-family: 'Do Hyeon', sans-serif;
        }
    }
    .div1 { 
        padding: 0 5.5% 1.5% 0;
        float: right;
    }
    .div2{
        width: 90%;  
        margin: 0 5% 0 5%;  
    }
} 
</style>
