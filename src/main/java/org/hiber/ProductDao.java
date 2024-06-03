package org.hiber;

import org.hibernate.Session;

import java.util.List;

public class ProductDao {
    private SessionUtil sessionUtil;

    public ProductDao(SessionUtil session) {
        this.sessionUtil = session;
    }

    public Product findById(Long id) {
        try (Session session = sessionUtil.getSession()) {
            session.getTransaction().begin();
            Product product = session.find(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll() {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("SELECT p FROM Product p", Product.class)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Product p WHERE p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            }
    }

    public void save(Product product){
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
