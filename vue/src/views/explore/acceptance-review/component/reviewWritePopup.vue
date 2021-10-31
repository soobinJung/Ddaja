<template>
<div>
    <el-dialog 
    :visible.sync="popupVal" 
    :before-close="handleClose">  
    <div>
        <template>
            <article-detail 
                :is-edit="false" 
                @close:popup="popupClose"
            />
        </template>
    </div>
    </el-dialog>
</div> 
</template>

<script>
import ArticleDetail from './components/ArticleDetail'
export default {
    name: ''
    , components: {
        ArticleDetail
    }
    , data() {
        return {
        
        }
    } 
    , props: {
        popupVal: {} 
    }
    , created() { }
    , methods: {
        handleClose(done) {
        this.$confirm('정말 끝내시겠습니까 ? 😡')
            .then(_ => {  
                this.popupClose();
            })
            .catch(_ => {});
        }
        ,popupClose() {   
            this.$emit('close:popup', false) 
        }
    }
}
</script>