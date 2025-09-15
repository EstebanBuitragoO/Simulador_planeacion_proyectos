package ORM;

import Models.DependencyModel;
import Models.TaskModel;
import javax.persistence.EntityManager;
import java.util.List;

public class DependencyORM {

    private EntityManager em() {
        return JPAUtil.getEntityManager();
    }

    public void create(DependencyModel d) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(DependencyModel d) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(Long id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            DependencyModel ref = em.getReference(DependencyModel.class, id);
            em.remove(ref);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public DependencyModel find(Long id) {
        EntityManager em = em();
        try {
            return em.find(DependencyModel.class, id);
        } finally {
            em.close();
        }
    }

    public List<DependencyModel> findAll() {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT d FROM DependencyModel d", DependencyModel.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DependencyModel> findByProject(Long projectId) {
        EntityManager em = em();
        try {
            return em.createQuery(
                    "SELECT d FROM DependencyModel d WHERE d.project.id = :pid ORDER BY d.id",
                    DependencyModel.class)
                .setParameter("pid", projectId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DependencyModel> findByPredecessor(Long taskId) {
        EntityManager em = em();
        try {
            return em.createQuery(
                    "SELECT d FROM DependencyModel d WHERE d.predecessor.id = :tid",
                    DependencyModel.class)
                .setParameter("tid", taskId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public List<DependencyModel> findBySuccessor(Long taskId) {
        EntityManager em = em();
        try {
            return em.createQuery(
                    "SELECT d FROM DependencyModel d WHERE d.successor.id = :tid",
                    DependencyModel.class)
                .setParameter("tid", taskId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public List<TaskModel> getPredecessors(Long taskId) {
        EntityManager em = em();
        try {
            return em.createQuery(
                    "SELECT d.predecessor FROM DependencyModel d WHERE d.successor.id = :tid",
                    TaskModel.class)
                .setParameter("tid", taskId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public List<TaskModel> getSuccessors(Long taskId) {
        EntityManager em = em();
        try {
            return em.createQuery(
                    "SELECT d.successor FROM DependencyModel d WHERE d.predecessor.id = :tid",
                    TaskModel.class)
                .setParameter("tid", taskId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteDependenciesByProject(Long projectId) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM DependencyModel d WHERE d.project.id = :pid")
              .setParameter("pid", projectId)
              .executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public boolean dependencyExists(Long projectId, Long predecessorId, Long successorId) {
        EntityManager em = em();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(d) FROM DependencyModel d WHERE d.project.id = :pid " +
                    "AND d.predecessor.id = :predId AND d.successor.id = :succId", Long.class)
                .setParameter("pid", projectId)
                .setParameter("predId", predecessorId)
                .setParameter("succId", successorId)
                .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}
