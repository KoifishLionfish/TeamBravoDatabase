package org.axe.Controller;

import org.axe.entity.Car;
import org.axe.entity.Customer;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");


    //CRUD - CREATE READ UPDATE DELETE
    public boolean save(Customer customer) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {

            transaction = entityManager.getTransaction();
            transaction.begin();
            // Vad vill vi utföra för operation
            entityManager.persist(customer);
            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            System.out.println("har nått finally");
            entityManager.close();
        }
        return false;
    }

    public List<Customer> getAll() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Customer> customerListToReturn = new ArrayList<>();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<Customer> resultList = entityManager.createQuery("FROM Customer", Customer.class);
            customerListToReturn.addAll(resultList.getResultList());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return customerListToReturn;
    }


    /* public addCustomerTocar (Car car) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Customer> customerListToReturn = new ArrayList<>();

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<Customer> resultList = entityManager.createQuery("FROM Customer", Customer.class);
            customerListToReturn.addAll(resultList.getResultList());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return customerListToReturn;
    } */

}
