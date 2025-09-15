package Models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "projects")
@Access(AccessType.FIELD)
public class ProjectModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = true)
    private String description;

    public ProjectModel() {}

    public ProjectModel(String name) {
        this.name = name;
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
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public void setDescription(String description) { 
        this.description = description; 
    }
    
}
