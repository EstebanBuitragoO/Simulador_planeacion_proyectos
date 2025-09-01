package Controllers;

import Models.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

public class UserJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public UserJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sppPU");
    }

    private EntityManager em() { return emf.createEntityManager(); }

    public void create(User u) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(User u) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void destroy(Long id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            User ref = em.getReference(User.class, id);
            em.remove(ref);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public User find(Long id) {
        EntityManager em = em();
        try { return em.find(User.class, id); }
        finally { em.close(); }
    }

    public List<User> findAll() {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally { em.close(); }
    }

    // Útil para login
    public User findByEmail(String email) {
        EntityManager em = em();
        try {
            List<User> list = em.createQuery(
                    "SELECT u FROM User u WHERE u.email = :e", User.class)
                .setParameter("e", email)
                .setMaxResults(1)
                .getResultList();
            return list.isEmpty() ? null : list.get(0);
        } finally { em.close(); }
    }
}
