<template>

    <div class="common-layout">
        <el-container>
            <el-header>User Login</el-header>
            <el-main>
                <div style="margin: 10px;">
                    <el-input v-model="username" style="width: 240px" placeholder="username" />
                </div>
                <div style="margin: 10px;">
                    <el-input
                        v-model="password"
                        style="width: 240px"
                        type="password"
                        placeholder="password"
                        show-password
                    />
                </div>
                <el-button style="width: 240px" v-on:click="login" type="primary">Submit</el-button>
                <el-text class="mx-1">{{ message }}</el-text>
            </el-main>
        </el-container>
    </div>
</template>

<script setup>
    import { userLogin } from "@/api/login.js"
    import { onMounted, ref } from "vue";
    const username = ref('');
    const password = ref('');
    const message = ref('');
    const login = async function(){
        message.value = userLogin(username, password);
    }
    onMounted(()=>{
        console.log("Vue Start!");
    });
</script>

<style scoped>

</style>

    