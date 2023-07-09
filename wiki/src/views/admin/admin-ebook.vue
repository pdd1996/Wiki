<template>
  <a-layout style="padding: 24px 0; background: #fff">
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
      <p>
        <a-button 
          type="primary" 
          size="large" 
          @click="handleAdd"
          >
          新增
        </a-button>
      </p>
      <a-table 
      :columns="columns" 
      :data-source="ebooks"
      :rowKey="(record: any, index: any ) => index"
      :pagination="pagination"
      :loading="loading"
      @change="handleTableChange"
      >
        <template #cover="{ text: cover }">
          <img :src="cover" alt="avatar" />
        </template>
        <template #category="{ text: record }">
          <span>{{ getCategoryName(record.category1) }} / {{ getCategoryName(record.category2) }}</span>
        </template>
        <template #action="{record}">
          <a-space size="small">
            <router-link to="/admin/doc">
              <a-button type="primary" size="small">
                文档管理
              </a-button>
            </router-link>
            <a-button type="primary" size="small" @click="handleEdit(record)">
              编辑
            </a-button>
            <a-popconfirm 
              title="删除后不可恢复，确认删除?" 
              ok-text="是" 
              cancel-text="否"
              @confirm="handleDelete(record.id)"
            >
              <a-button danger  size="small">
                删除
              </a-button>
            </a-popconfirm>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>

  <a-modal 
    v-model:visible="modalVisible"
    title="电子书表单" 
    @ok="handleModalOk"
    ok-text="确定" 
    cancel-text="取消"
    >
    <a-form :model="ebook" :label-col="{ span: 4 }" :wrapper-col="{ span: 14 }">
      <a-form-item label="封面">
        <a-input v-model:value="ebook.bookCover" />
      </a-form-item>
      <a-form-item label="名称">
        <a-input v-model:value="ebook.bookName" />
      </a-form-item>
      <a-form-item label="分类">
        <!-- 显示的是name 实际要取的字段 id -->
        <a-cascader 
          v-model:value="categoryIds" 
          :options="level1" 
          :field-names = "{ label:'name', value: 'id', children: 'children'}" 
        />
      </a-form-item>
      <!-- <a-form-item label="分类一">
        <a-input v-model:value="ebook.category1" />
      </a-form-item>
      <a-form-item label="分类二">
        <a-input v-model:value="ebook.category2" />
      </a-form-item> -->
      <a-form-item label="描述">
        <a-input v-model:value="ebook.bookDesc" />
      </a-form-item>
    </a-form>
  </a-modal>
</template> 



<script lang="ts">
import { defineComponent, ref, onMounted } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import { Tool } from '@/util/tool';

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
  // {
  //   title: '分类1',
  //   dataIndex: 'category1',
  //   key: 'category1',
  // },
  // {
  //   title: '分类2',
  //   key: 'category2',
  //   dataIndex: 'category2',
  // },
  {
    title: '分类',
    slots: { customRender: 'category' },
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
  name: 'AdminEbook',
  setup() {
    const ebooks = ref();
    const pagination = ref({
      total: 0,
      // 当前页
      current: 1,
      // 展示页
      pageSize: 4,
    });
    const loading = ref(false);
    const modalVisible = ref(false)
    const ebook = ref({
      bookCover: '',
      bookName: '',
      category1: '',
      category2: '',
      bookDesc: '',
    });
    /**
     * 级联组件
     * 数组 [100, 101]对应 案例： 前端/vue
     */
    const categoryIds = ref();
    const level1 = ref();

    /**
      * 数据查询
    **/
    const handleQuery = (params: any) => {
      loading.value = true;
      axios.get("/ebook/list", {
        params: {
          page: params.page,
          size: params.size,
        }
      }).then((response) => {
        loading.value = false;
        const data = response.data;
        if(data.success) {
          // ebooks.value = data.content;
          ebooks.value = data.content.list;
          // 重置分页按钮
          pagination.value.current = params.page;
          pagination.value.total = data.content.total;
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * 表格点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };

    const handleModalOk = () => {
      modalVisible.value = true
      ebook.value.category1 = categoryIds.value[0];
      ebook.value.category2 = categoryIds.value[1];

      axios
      .post("/ebook/save", ebook.value)
      .then((response) => {
          const data = response.data;
          if(data.success) {
            modalVisible.value = false;
            
            // 重新加载页面
            handleQuery({
              page: pagination.value.current,
              size: pagination.value.pageSize,
            });
          } else {
            message.error(data.message);
          }
        });
    }

    const handleEdit = (record: any) => {
      modalVisible.value = true
      ebook.value = record
      categoryIds.value = [ebook.value.category1, ebook.value.category2]
    }

    const handleAdd = () => {
      //todo
      modalVisible.value = true
      ebook.value = {
        bookCover: '',
        bookName: '',
        category1: '',
        category2: '',
        bookDesc: '',
      }
    }

    const handleDelete = (id: number) => {
      axios.delete("/ebook/delete/" + id)
      .then((response) => {
          const data = response.data;
          if(data.success) {
            
            // 重新加载页面
            handleQuery({
              page: pagination.value.current,
              size: pagination.value.pageSize,
            });
          }
        });
    }


    /**
     * 查询所有分类
     */
    let categorys: any;

    const handleQueryCategory = () => {
      loading.value = true;
      level1.value = [];
      axios.get("/category/all").then((response) => {
        loading.value = false;
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
    }

    const getCategoryName = (cid: number) => {
      console.log(cid, "cid")
      console.log(categorys, "categorys")
      let result = "";

      categorys.forEach((item: any) => {
        if(item.id === cid) {
          result = item.name;
        }
      });

      return result;
    }
    onMounted(() => {
      handleQueryCategory();
      handleQuery({
        page: 1,
        size: pagination.value.pageSize,
      });
    });

    return {
      ebooks,
      pagination,
      columns,
      loading,
      modalVisible,
      ebook,
      categoryIds,
      level1,
      handleTableChange,
      handleModalOk,
      handleEdit,
      handleAdd,
      handleDelete,
      handleQueryCategory,
      getCategoryName
    };
  },
  components: {

  },
});

</script>

<style scoped>
img {
  width: 50px;
  height: 50px;
}
</style>