package Controllers;

import Models.TaskModel;
import Models.ProjectModel;
import Services.TaskService;
import java.util.List;

public class TaskController {
    TaskService taskService;

    public TaskController() {
        taskService = new TaskService();
    }

    public String createTask(Long projectId, String name, Integer durationDays) {
        return taskService.createTask(projectId, name, durationDays);
    }

    public String updateTask(TaskModel task) {
        return taskService.updateTask(task);
    }

    public String deleteTask(Long id) {
        return taskService.deleteTask(id);
    }

    public TaskModel getTask(Long id) {
        return taskService.getTask(id);
    }

    public List<TaskModel> getTasksByProject(Long projectId) {
        return taskService.getTasksByProject(projectId);
    }
}