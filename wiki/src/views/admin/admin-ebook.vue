<template>
  <a-layout style="padding: 24px 0; background: #fff">
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
      <a-table 
      :columns="columns" 
      :data-source="ebooks"
      :rowKey="(record:any, index: number) => index"
      >
        <template #cover="{ text: cover }">
          <img :src="cover" alt="avatar" />
        </template>
        <template #action="{}">
          <a-space size="small">
            <a-button type="primary" size="small">
              编辑
            </a-button>
            <a-popconfirm title="删除后不可恢复，确认删除?" ok-text="是" cancel-text="否">
              <a-button danger  size="small">
                删除
              </a-button>
            </a-popconfirm>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
</template> 



<script lang="ts">
import { defineComponent, ref, onMounted } from 'vue';
import axios from 'axios';
const columns = [
  {
    title: '封面',
    dataIndex: 'bookCover',
    key: 'bookCover',
    slots: { customRender: 'cover' }
  },
  {
    title: '名称',
    dataIndex: 'bookName',
    key: 'bookName',
  },
  {
    title: '分类1',
    dataIndex: 'category1',
    key: 'category1',
  },
  {
    title: '分类2',
    key: 'category2',
    dataIndex: 'category2',
  },
  {
    title: '文档数',
    key: 'docCount',
    dataIndex: 'docCount',
  },
  {
    title: '阅读数',
    key: 'viewCount',
    dataIndex: 'viewCount',
  },
  {
    title: '点赞数',
    key: 'likeCount',
    dataIndex: 'likeCount',
  },
  {
    title: 'Action',
    key: 'action',
    slots: { customRender: 'action' },
  },
];

export default defineComponent({
  name: 'adminEbook',
  setup() {
    const ebooks = ref();
    const pagination = ref(() => ({
      total: 0,
      // 当前页
      current: 1,
      // 展示页
      pageSize: 3,
    }));
    const loading = ref(false);

    /**
           * 数据查询
           **/
    const handleQuery = (params: any) => {
      loading.value = true;
      axios.get("/ebook/list", {
        params: {
          bookName: "Java",
        }
      }).then((response) => {
        loading.value = false;
        const data = response.data;
        ebooks.value = data.content;


          // 重置分页按钮
          // pagination.value.current = params.page;
          // pagination.value.total = data.content.total;
        });
    };

    /**
     * 表格点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数都有啥：" + pagination);
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };

    onMounted(() => {
      handleQuery({});
    });

    return {
      ebooks,
      pagination,
      columns,
      loading,
      handleTableChange
    };
  },
  components: {

  },
});

// const data = [
//   {
//     key: '1',
//     cover: '/image/JavaScript.jpg',
//     name: 'JavaScript',
//     category_1: '1',
//     category_2: '2',
//     documents: '40',
//     readings: '30',
//     likes: '40',
//   },
//   {
//     key: '2',
//     cover: '/image/TypeScript.jpg',
//     name: 'TypeScript',
//     category_1: '1',
//     category_2: '2',
//     documents: '50',
//     readings: '30',
//     likes: '40',
//   },
// ];


</script>

<style scoped>
img {
  width: 50px;
  height: 50px;
}
</style>