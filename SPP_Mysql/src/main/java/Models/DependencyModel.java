package Models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(
    name = "dependencies",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_dep_unique", columnNames = {"project_id", "predecessor_task_id", "successor_task_id"})
    },
    indexes = {
        @Index(name = "idx_dep_project", columnList = "project_id"),
        @Index(name = "idx_dep_pred", columnList = "predecessor_task_id"),
        @Index(name = "idx_dep_succ", columnList = "successor_task_id")
    }
)
@Access(AccessType.FIELD)
public class DependencyModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectModel project;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "predecessor_task_id", nullable = false)
    private TaskModel predecessor;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "successor_task_id", nullable = false)
    private TaskModel successor;

    public DependencyModel() {}

    public DependencyModel(ProjectModel project, TaskModel predecessor, TaskModel successor) {
        this.project = project;
        this.predecessor = predecessor;
        this.successor = successor;
    }

    public Long getId() { 
        return id; 
    }
    
    public ProjectModel getProject() { 
        return project; 
    }
    
    public TaskModel getPredecessor() { 
        return predecessor; 
    }
    
    public TaskModel getSuccessor() { 
        return successor; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public void setProject(ProjectModel project) { 
        this.project = project; 
    }
    
    public void setPredecessor(TaskModel predecessor) { 
        this.predecessor = predecessor; 
    }
    
    public void setSuccessor(TaskModel successor) { 
        this.successor = successor; 
    }
}
