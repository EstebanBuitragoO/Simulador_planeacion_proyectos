package ORM;

import Models.ProjectModel;
import javax.persistence.EntityManager;
import java.util.List;

public class ProjectORM {
    
    private EntityManager em(){
        return JPAUtil.getEntityManager();
    }
    
    public void create(ProjectModel p){
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void edit(ProjectModel p) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void destroy(Long id) {
        EntityManager em = em();
        try{
            em.getTransaction().begin();
            ProjectModel ref = em.getReference(ProjectModel.class, id);
            em.remove(ref);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public ProjectModel find(Long id) {
        EntityManager em = em();
        try{
            return em.find(ProjectModel.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<ProjectModel> findAll(){
        EntityManager em = em();
        try {
            return em.createQuery("SELECT p FROM ProjectModel p", ProjectModel.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
