package Models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "projects")
@Access(AccessType.FIELD)
public class ProjectModel implements Serializable {

    public enum Risk {
        BAJO("Bajo"),
        MEDIO("Medio"),
        ALTO("Alto");

        private final String displayName;

        Risk(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public java.awt.Color getDisplayColor() {
            switch (this) {
                case BAJO:
                    return new java.awt.Color(34, 139, 34);
                case MEDIO:
                    return new java.awt.Color(255, 165, 0);
                case ALTO:
                    return new java.awt.Color(220, 20, 60);
                default:
                    return new java.awt.Color(153, 153, 153);
            }
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = true)
    private String description;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private java.util.List<TaskModel> tasks = new java.util.ArrayList<>();

    @Temporal(TemporalType.DATE)
    private java.util.Date startDate;

    @Temporal(TemporalType.DATE)
    private java.util.Date targetEndDate;

    public ProjectModel() {}

    public ProjectModel(String name) {
        this.name = name;
    }

    public ProjectModel(String name, String description ,java.util.Date startDate, java.util.Date targetEndDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.targetEndDate = targetEndDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public java.util.List<TaskModel> getTasks() {
        return tasks;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public java.util.Date getTargetEndDate() {
        return targetEndDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(java.util.List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public void setTargetEndDate(java.util.Date targetEndDate) {
        this.targetEndDate = targetEndDate;
    }

}
