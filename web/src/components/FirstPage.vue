<template>
    <el-text class="mx-1" size="large" type="primary">
        {{ result.data }}
    </el-text>
</template>

<script setup>
    import { getData } from "@/api/api.js"
    import { onMounted, ref } from "vue";
    const result = ref({});
    const updateResult = async function(){
        result.value = await getData();
    }
    onMounted(()=>{
        console.log("Vue Start!");
        updateResult();
    });
</script>

<style>
</style>
    