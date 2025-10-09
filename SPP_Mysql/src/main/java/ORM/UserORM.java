package ORM;

import Models.UserModel;
import javax.persistence.EntityManager;
import java.util.List;

public class UserORM {

    private EntityManager em() {
        return JPAUtil.getEntityManager();
    }

    public void create(UserModel u) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(UserModel u) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(Long id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            UserModel ref = em.getReference(UserModel.class, id);
            em.remove(ref);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public UserModel find(Long id) {
        EntityManager em = em();
        try {
            return em.find(UserModel.class, id);
        } finally {
            em.close();
        }
    }

    public List<UserModel> findAll() {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT u FROM UserModel u", UserModel.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public UserModel findByEmail(String email) {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT u FROM UserModel u WHERE u.email = :e", UserModel.class)
                     .setParameter("e", email)
                     .setMaxResults(1)
                     .getResultStream()
                     .findFirst()
                     .orElse(null);
        } finally {
            em.close();
        }
    }
}
