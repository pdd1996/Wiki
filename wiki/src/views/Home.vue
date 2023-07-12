<template>
  <a-layout-content style="padding: 0 50px">
    <a-breadcrumb style="margin: 16px 0">
      <a-breadcrumb-item>Home</a-breadcrumb-item>
      <a-breadcrumb-item>List</a-breadcrumb-item>
      <a-breadcrumb-item>App</a-breadcrumb-item>
    </a-breadcrumb>
    <a-layout style="padding: 24px 0; background: #fff">
      <a-layout-sider width="200" style="background: #fff">
        <a-menu 
          mode="inline" 
          v-model:selectedKeys="selectedKeys2" 
          v-model:openKeys="openKeys" 
          style="height: 100%"
        >
          <a-menu-item key="welcome">
            <router-link :to="'/'">
              <span>欢迎</span>
            </router-link>
          </a-menu-item>
          <a-sub-menu v-for="item in level1" :key="item.id" >
            <template #title>
              <span>
                <user-outlined />
                {{ item.name }}
              </span>
            </template>
            <a-menu-item v-for="child in item.children" :key="child.id">
              <span>{{ child.name }}</span>  
            </a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
        <a-list 
        item-layout="vertical" 
        size="large" 
        :data-source="ebooks"
        :grid="{ gutter: 25, column: 3 }"
        >
          <template #renderItem="{ item }">
            <a-list-item key="item.bookName">
              <template #actions>
                <span v-for="{ type, text } in actions" :key="type">
                  <component v-bind:is="type" style="margin-right: 8px" />
                  {{ text }}
                </span>
              </template>
              <a-list-item-meta :description="item.bookDesc">
                <template #title>
                  <a :href="item.href">{{ item.bookName }}</a>
                </template>
                <template #avatar><a-avatar :src="item.bookCover" /></template>
              </a-list-item-meta>
            </a-list-item>
          </template>
        </a-list>
      </a-layout-content>
    </a-layout>
  </a-layout-content>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted } from 'vue';
import { UserOutlined, LaptopOutlined, NotificationOutlined, StarOutlined, LikeOutlined, MessageOutlined } from '@ant-design/icons-vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import {Tool} from '../util/tool'

const listData: Record<string, string>[] = [];

export default defineComponent({
  name: 'Home',
  components: {
    UserOutlined,
    LaptopOutlined,
    NotificationOutlined,
    StarOutlined,
    LikeOutlined,
    MessageOutlined,
  },
  setup() {
    // 响应式的数据
    const ebooks = ref();
    const level1 = ref();
    let categorys: any
    // 初始化
    onMounted(() => {
      handleQueryCategory();
      axios.get("/ebook/list",{
        params:{
          page: 1,
          size: 1000
        }
      }).then((resp) => {
        const data = resp.data;
        ebooks.value = data.content.list;
      })
    });

    const handleQueryCategory = () => {
      axios.get("/category/all").then((response) => {

        const data = response.data;
        if (data.success) {
          categorys = data.content;
          console.log("原始数组:",categorys);

          level1.value = {};
          level1.value = Tool.array2Tree(categorys,0)
          console.log("树形结构：",level1.value)
        } else {
          message.error(data.message);
        }
      });
    }; 

    const actions: Record<string, string>[] = [
      { type: 'StarOutlined', text: '156' },
      { type: 'LikeOutlined', text: '156' },
      { type: 'MessageOutlined', text: '2' },
    ];

    return {
      ebooks,
      selectedKeys1: ref<string[]>(['2']),
      selectedKeys2: ref<string[]>(['1']),
      openKeys: ref<string[]>(['sub1']),
      listData,
      actions,
      pagination: {
        onChange: (page: any) => {
          console.log(page)
        },
        pageSize: 3
      },
      level1,
      handleQueryCategory
    };
  },
});
</script>

<style scoped>
.ant-avatar {
  width: 50px;
  height: 50px;
  line-height: 50px;
  border-radius: 8%;
  margin: 5px 0;
}
</style>
