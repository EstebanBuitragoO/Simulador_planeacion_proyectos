package Controllers;

import Models.ProjectModel;
import Services.ProjectService;
import java.util.List;

public class ProjectController {
    ProjectService projectService;

    public ProjectController() {
        projectService = new ProjectService();
    }

    public String createProject(String name, String description) {
        ProjectModel project = new ProjectModel(name);
        project.setDescription(description);
        return projectService.createProject(project);
    }

    public String updateProject(ProjectModel project) {
        return projectService.updateProject(project);
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
}