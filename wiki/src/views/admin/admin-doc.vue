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
      :data-source="level1"
      :rowKey="(record: any, index: any ) => index"
      :pagination="false"
      >
        <!-- <template #cover="{ text: cover }">
          <img :src="cover" alt="avatar" />
        </template> -->
        <template #action="{record}">
          <a-space size="small">
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
    title="文档表单" 
    @ok="handleModalOk"
    ok-text="确定" 
    cancel-text="取消"
    >
    <a-form :model="doc" :label-col="{ span: 4 }" :wrapper-col="{ span: 14 }">
      <a-form-item label="名称">
        <a-input v-model:value="doc.name" />
      </a-form-item>
      <a-form-item label="父文档">
        <!-- <a-input v-model:value="doc.parent" /> -->
        <a-select
          ref="select"
          v-model:value="doc.parent"
        >
          <a-select-option value="0">无</a-select-option>
          <a-select-option 
            v-for="c in level1" 
            :key="c.id" 
            :value="c.id" 
            :disabled="doc.id === c.id"
          >
            {{ c.name }}
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="顺序">
        <a-input v-model:value="doc.sort" />
      </a-form-item>
    </a-form>
  </a-modal>
</template> 



<script lang="ts">
import { defineComponent, ref, onMounted } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';
import {Tool} from '../../util/tool'

const columns = [
  {
    title: '名称',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: '父文档',
    dataIndex: 'parent',
    key: 'parent',
  },
  {
    title: '排序',
    key: 'sort',
    dataIndex: 'sort',
  },
  {
    title: 'Action',
    key: 'action',
    slots: { customRender: 'action' },
  },
];

export default defineComponent({
  name: 'AdminDoc',
  setup() {
    const docs = ref();
    const loading = ref(false);
    const modalVisible = ref(false)
    const doc = ref({
      name:'',
      parent: '',
      sort: ''
    });
    /**
     * [{
     *  id: '',
     *  name: '',
     *  children: [{
     *  id: '',
     *  name: '',
     *  }]
     * }]
     */
    // 一级文档树，children属性是二级文档
    const level1 = ref();

    /**
      * 数据查询
    **/
    const handleQuery = () => {
      loading.value = true;
      level1.value = [];
      axios.get("/doc/all").then((response) => {
        loading.value = false;
        const data = response.data;
        if (data.success) {
          docs.value = data.content;
          console.log("原始数组:",docs.value);

          level1.value = {};
          level1.value = Tool.array2Tree(docs.value,0)
          console.log("树形结构：",level1)
        } else {
          message.error(data.message);
        }
      });
    };

    const handleModalOk = () => {
      modalVisible.value = true
      
      axios
      .post("/doc/save", doc.value)
      .then((response) => {
          const data = response.data;
          if(data.success) {
            modalVisible.value = false;
            
            // 重新加载页面
            handleQuery();
          } else {
            message.error(data.message);
          }
        });
    }

    const handleEdit = (record: any) => {
      modalVisible.value = true
      doc.value = record
    }

    const handleAdd = () => {
      //todo
      modalVisible.value = true
      doc.value = {
        name:'',
        parent: '',
        sort: ''
      }
    }

    const handleDelete = (id: number) => {
      axios.delete("/doc/delete/" + id)
      .then((response) => {
          const data = response.data;
          if(data.success) {
            
            // 重新加载页面
            handleQuery();
          }
        });
    }

    onMounted(() => {
      handleQuery();
    });

    return {
      docs,
      columns,
      loading,
      modalVisible,
      doc,
      level1,
      handleModalOk,
      handleEdit,
      handleAdd,
      handleDelete
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