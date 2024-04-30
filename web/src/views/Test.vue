<template>
    {{a}}
    <button @click="btn">button</button>
    {{ c }}
    {{ x }} {{ z }}
</template>

<script setup>
import { ref, reactive, toRef, toRefs, inject, getCurrentInstance } from "vue";
</script>

    