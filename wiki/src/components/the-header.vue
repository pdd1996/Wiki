<template>
    <a-layout-header class="header">
    <div class="logo" />
      <a-menu
        theme="dark"
        mode="horizontal"
        v-model:selectedKeys="selectedKeys1"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1">nav 1231</a-menu-item>
        <a-menu-item key="2">nav 2214</a-menu-item>
        <a-menu-item key="3">nav 34123</a-menu-item>
      </a-menu>
    </a-layout-header>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
export default defineComponent({
  name: 'the-header',
  setup() {
    return {
      selectedKeys1: ref<string[]>(['2']),
    };
  },
});
</script>