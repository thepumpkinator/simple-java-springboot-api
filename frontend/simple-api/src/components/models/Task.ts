export interface ITask {
  id: number,
  title: string,
  description: string,
  status: string,
}

export class Task {
  id: number;
  title: string;
  description: string;
  status: string;

  constructor (_task: ITask) {
    this.id = _task.id;
    this.title = _task.title;
    this.description = _task.description;
    this.status = _task.status;
  }
}

