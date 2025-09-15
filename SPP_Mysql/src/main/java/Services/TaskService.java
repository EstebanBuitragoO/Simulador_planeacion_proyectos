package Services;

import Models.TaskModel;
import Models.ProjectModel;
import ORM.TaskORM;
import ORM.ProjectORM;
import java.util.List;

public class TaskService {
    TaskORM taskORM = new TaskORM();
    ProjectORM projectORM = new ProjectORM();

    public String createTask(Long projectId, String name, Integer durationDays) {
        try {
            ProjectModel project = projectORM.find(projectId);
            if (project == null) {
                return "Proyecto no encontrado";
            }

            TaskModel task = new TaskModel(project, name, durationDays);
            taskORM.create(task);
            return "Tarea creada exitosamente";
        } catch (Exception e) {
            return "Error al crear tarea: " + e.getMessage();
        }
    }

    public String updateTask(TaskModel task) {
        try {
            taskORM.edit(task);
            return "Tarea actualizada exitosamente";
        } catch (Exception e) {
            return "Error al actualizar tarea: " + e.getMessage();
        }
    }

    public String deleteTask(Long id) {
        try {
            taskORM.destroy(id);
            return "Tarea eliminada exitosamente";
        } catch (Exception e) {
            return "Error al eliminar tarea: " + e.getMessage();
        }
    }

    public TaskModel getTask(Long id) {
        return taskORM.find(id);
    }

    public List<TaskModel> getTasksByProject(Long projectId) {
        return taskORM.findByProject(projectId);
    }
}