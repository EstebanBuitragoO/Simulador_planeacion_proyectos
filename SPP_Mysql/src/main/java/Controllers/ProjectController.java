package Controllers;

import Models.ProjectModel;
import Models.TaskModel;
import Services.ProjectService;
import java.util.Date;
import java.util.List;

public class ProjectController {
    ProjectService projectService;

    public ProjectController() {
        projectService = new ProjectService();
    }

    public String createProject(String name, String description, Date startDate, Date targetEndDate) {
        ProjectModel project = new ProjectModel(name, description, startDate, targetEndDate);
        return projectService.createProject(project);
    }

    public String updateProject(ProjectModel project) {
        return projectService.updateProject(project);
    }

    public String updateProject(Long id, String name, String description, Date startDate, Date targetEndDate) {
        ProjectModel project = projectService.getProject(id);
        if (project != null) {
            project.setName(name);
            project.setDescription(description);
            project.setStartDate(startDate);
            project.setTargetEndDate(targetEndDate);
            return projectService.updateProject(project);
        }
        return "Proyecto no encontrado";
    }

    public String deleteProject(Long id) {
        return projectService.deleteProject(id);
    }

    public ProjectModel getProject(Long id) {
        return projectService.getProject(id);
    }

    public List<ProjectModel> getAllProjects() {
        return projectService.getAllProjects();
    }

    public ProjectModel.Risk calculateRisk(List<TaskModel> tasks) {
        return projectService.calculateRisk(tasks);
    }
}