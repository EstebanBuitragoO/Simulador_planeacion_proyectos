package Services;

import Models.ProjectModel;
import Models.TaskModel;
import ORM.ProjectORM;
import java.util.List;

public class ProjectService {
    ProjectORM projectORM = new ProjectORM();

    public String createProject(ProjectModel project) {
        try {
            projectORM.create(project);
            return "Proyecto creado exitosamente";
        } catch (Exception e) {
            return "Error al crear proyecto: " + e.getMessage();
        }
    }

    public String updateProject(ProjectModel project) {
        try {
            projectORM.edit(project);
            return "Proyecto actualizado exitosamente";
        } catch (Exception e) {
            return "Error al actualizar proyecto: " + e.getMessage();
        }
    }

    public String deleteProject(Long id) {
        try {
            projectORM.destroy(id);
            return "Proyecto eliminado exitosamente";
        } catch (Exception e) {
            return "Error al eliminar proyecto: " + e.getMessage();
        }
    }

    public ProjectModel getProject(Long id) {
        return projectORM.find(id);
    }

    public List<ProjectModel> getAllProjects() {
        return projectORM.findAll();
    }

    public ProjectModel.Risk calculateRisk(List<TaskModel> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return ProjectModel.Risk.BAJO;
        }

        long overdueTasks = 0;
        for (TaskModel task : tasks) {
            if (task.isOverdue()) {
                overdueTasks++;
            }
        }

        double overduePercentage = (double) overdueTasks / tasks.size() * 100;

        if (overduePercentage > 30) {
            return ProjectModel.Risk.ALTO;
        } else if (overduePercentage > 10) {
            return ProjectModel.Risk.MEDIO;
        } else {
            return ProjectModel.Risk.BAJO;
        }
    }
}