package Models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(
    name = "tasks"
)
@Access(AccessType.FIELD)
public class TaskModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectModel project;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    public TaskModel() {}

    public TaskModel(ProjectModel project, String name, Integer durationDays) {
        this.project = project;
        this.name = name;
        this.durationDays = durationDays;
    }

    public Long getId() { 
        return id; 
    }
    
    public ProjectModel getProject() { 
        return project; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public Integer getDurationDays() { 
        return durationDays; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public void setProject(ProjectModel project) { 
        this.project = project; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public void setDurationDays(Integer durationDays) { 
        this.durationDays = durationDays; 
    }
}
