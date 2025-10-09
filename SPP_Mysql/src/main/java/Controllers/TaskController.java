package Controllers;

import Models.TaskModel;
import Models.ProjectModel;
import Models.UserModel;
import Services.TaskService;
import java.util.Date;
import java.util.List;

public class TaskController {
    TaskService taskService;
    TaskModel taskModel;
    ProjectModel projectModel;
    ProjectController projectController;

    public TaskController() {
        taskService = new TaskService();
        projectController = new ProjectController();
    }

    public String createTask(Long projectId, String name, Integer durationDays, Date startDate, Date endDate, Date plannedEndDate) {
        projectModel =  projectController.getProject(projectId);
        taskModel = new TaskModel(projectModel, name, durationDays, startDate, endDate, plannedEndDate);
        return taskService.createTask(taskModel);
    }

    public String createTask(Long projectId, UserModel assignedUser, String name, Integer durationDays, Date startDate, Date endDate, Date plannedEndDate) {
        projectModel = projectController.getProject(projectId);
        taskModel = new TaskModel(projectModel, assignedUser, name, durationDays, startDate, endDate, plannedEndDate);
        return taskService.createTask(taskModel);
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

    public List<TaskModel> getTasksByProjectAndStatus(Long projectId, TaskModel.Status status) {
        return taskService.getTasksByProjectAndStatus(projectId, status);
    }
    
    public String getAllTaskPercent () {
        return taskService.CalculateTaskPercent();
    }

    public int calculateProgress(List<TaskModel> tasks) {
        return taskService.calculateProgress(tasks);
    }

    public String calculateTimeRemaining(List<TaskModel> tasks) {
        return taskService.calculateTimeRemaining(tasks);
    }

    public List<Object[]> getWorkloadTableData(Long projectId, List<UserModel> users) {
        return taskService.calculateWorkloadTableData(projectId, users);
    }

    public String updateTaskStatus(Long taskId, TaskModel.Status newStatus) {
        TaskModel task = taskService.getTask(taskId);
        if (task == null) {
            return "Tarea no encontrada";
        }

        task.setStatus(newStatus);
        return taskService.updateTask(task);
    }
}