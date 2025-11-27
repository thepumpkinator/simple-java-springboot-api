import api from "@/services/httpClient"
import { Task } from "@/components/models/Task";

export class TaskService{

  async getTaskById(id: number): Promise<Task> {
    return (await api.get("/task/" + id)).data;
  }

  async getTasks(): Promise<Task[]> {
    return (await api.get("/tasks")).data;
  }

  async createTask(task: Task): Promise<Task> {
    return (await api.post("/task/save", task)).data;
  }

  async updateTask(task: Task, id: number): Promise<Task> {
    return (await api.put("/task/" + id, task)).data;
  }

  async deleteTask(id: number) {
    return (await api.delete("/task/" + id)).data;
  }

}
