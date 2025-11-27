
<template>
  <div class="p-6 space-y-4">
      <div class="flex justify-between items-center mb-2">
        <h2 class="text-lg font-bold">{{ prop.item.title }}</h2>
        <span
          class="px-3 py-1 rounded-full text-sm font-medium"
          :class="statusColor(prop.item.status)"
        >
          {{ prop.item.status }}
        </span>
      </div>

      <p class="text-gray-700 mb-2">
        {{ prop.item.description }}
      </p>

      <div class="text-gray-500 text-sm">
        Task ID: {{ prop.item.id }}
      </div>
    </div>

</template>
<script name="TaskComponent" setup lang="ts">
import { Task } from '../models/Task';

const prop = defineProps({
  item: {
    type: Task,
    required: true
  }
});

const statusColor = (status: string) => {
  switch (status) {
    case "ACTIVE":
      return "bg-green-100 text-green-700";
    case "COMPLETE":
      return "bg-yellow-100 text-yellow-700";
    default:
      return "bg-gray-200 text-gray-700";
  }
}

</script>
<style lang="scss" scoped>

</style>
