package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(
    name = "tasks"
)
@Access(AccessType.FIELD)
public class TaskModel implements Serializable {

    public enum Status {
        TODO("To Do"),
        EN_PROGRESO("En Progreso"),
        BLOQUEADO("Bloqueado"),
        HECHO("Hecho");

        private final String displayName;

        Status(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectModel project;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private UserModel assignedUser;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate;

    @Column(name = "planned_end_date")
    @Temporal(TemporalType.DATE)
    private java.util.Date plannedEndDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO;

    public TaskModel() {}

    public TaskModel(ProjectModel project, String name, Integer durationDays, Date startDate, Date endDate, Date plannedEndDate) {
        this.project = project;
        this.name = name;
        this.durationDays = durationDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedEndDate = plannedEndDate;
        this.status = Status.TODO;
    }

    public TaskModel(ProjectModel project, String name, Integer durationDays, Date startDate, Date endDate, Date plannedEndDate, Status status) {
        this.project = project;
        this.name = name;
        this.durationDays = durationDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedEndDate = plannedEndDate;
        this.status = status;
    }

    public TaskModel(ProjectModel project, UserModel assignedUser, String name, Integer durationDays, Date startDate, Date endDate, Date plannedEndDate) {
        this.project = project;
        this.assignedUser = assignedUser;
        this.name = name;
        this.durationDays = durationDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedEndDate = plannedEndDate;
        this.status = Status.TODO;
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

    public Boolean isCompleted() {
        return status == Status.HECHO;
    }

    public void setCompleted(Boolean completed) {
        if (completed != null && completed) {
            this.status = Status.HECHO;
            if (this.endDate == null) {
                this.endDate = new java.util.Date();
            }
        } else {
            this.status = Status.TODO;
        }
    }

    public void setStatus(Status status) {
        this.status = status;
        if (status == Status.HECHO && this.endDate == null) {
            this.endDate = new java.util.Date();
        }
    }

    public UserModel getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(UserModel assignedUser) {
        this.assignedUser = assignedUser;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public java.util.Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(java.util.Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isTodo() {
        return status == Status.TODO;
    }

    public boolean isInProgress() {
        return status == Status.EN_PROGRESO;
    }

    public boolean isBlocked() {
        return status == Status.BLOQUEADO;
    }

    public boolean isDone() {
        return status == Status.HECHO;
    }

    public boolean isOverdue() {
        if (isCompleted() || plannedEndDate == null) {
            return false;
        }

        java.util.Date currentDate = new java.util.Date();
        java.util.Date endDateToCheck = endDate != null ? endDate : currentDate;

        return endDateToCheck.after(plannedEndDate);
    }

}
