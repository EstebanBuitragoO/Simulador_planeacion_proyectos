package ORM;

import Models.TaskModel;
import javax.persistence.EntityManager;
import java.util.List;

public class TaskORM {

    private EntityManager em() { return JPAUtil.getEntityManager(); }

    public void create(TaskModel t) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(TaskModel t) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void destroy(Long id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            TaskModel ref = em.getReference(TaskModel.class, id);
            em.remove(ref);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public TaskModel find(Long id) {
        EntityManager em = em();
        try { return em.find(TaskModel.class, id); }
        finally { em.close(); }
    }

    public List<TaskModel> findAll() {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT t FROM TaskModel t", TaskModel.class)
                     .getResultList();
        } finally { em.close(); }
    }

    public List<TaskModel> findByProject(Long projectId) {
        EntityManager em = em();
        try {
            return em.createQuery(
                    "SELECT t FROM TaskModel t WHERE t.project.id = :pid ORDER BY t.id",
                    TaskModel.class)
                .setParameter("pid", projectId)
                .getResultList();
        } finally { em.close(); }
    }
}
