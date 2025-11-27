<template>
  <div>
    <TaskComponent v-for="task in taskList" :item="task" :key="task.id" />
  </div>
</template>
<script setup lang="ts">
import { Task, ITask } from '../models/Task';
import TaskComponent from './TaskComponent.vue';
import { TaskService } from '@/services/TaskService';
import { ref, type Ref, onMounted, onBeforeMount } from 'vue';

const taskService = new TaskService();
const taskList: Ref<Task[]> = ref([]);

onBeforeMount(async () => {
  taskList.value = await taskService.getTasks();
});


</script>
<style lang="scss" scoped>

</style>
