package org.hiber;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionUtil sessionUtil = new SessionUtil();
        sessionUtil.init();
        try {
            ProductDao productDao = new ProductDao(sessionUtil);

            System.out.printf(productDao.findAll().toString());

            productDao.save(new Product("Chicken", 55));
            System.out.printf(productDao.findAll().toString());

            System.out.printf(productDao.findById(2L).toString());

            productDao.deleteById(2L);
            System.out.printf(productDao.findAll().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionUtil.close();
        }
    }
}
