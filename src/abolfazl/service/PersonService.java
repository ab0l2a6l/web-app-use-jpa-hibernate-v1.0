package abolfazl.service;

import abolfazl.common.JPA;
import abolfazl.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PersonService {

    private static void save1() {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("J2OS")
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Person person = new Person().setName("abolfazl").setFamily("mohammadi");
        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();
        System.out.println(person.getName());
    }

    private static void save2() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Person person = new Person().setName("abolfazl").setFamily("mohammadi");
        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();
        System.out.println(person.getName());
    }

    private static void update1() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person().setPersonId(2L).setName("abol").setFamily("mohammad");
        entityManager.persist(person); // exeption mide chon nabayad Person new shavad. b method update2() boro


        entityTransaction.commit();
        entityManager.close();
    }


    public static void update2() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = entityManager.find(Person.class, 1L);
        person.setName("aaa");

        entityTransaction.commit();
        entityManager.close();
    }

    public static void update3() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = entityManager.find(Person.class, 1L);
        person.setName("bbb");

        entityTransaction.commit();
        entityManager.close();
    }

    public static void update4() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person().setPersonId(1L).setName("aaa").setFamily("bbb");
        entityManager.merge(person);

        entityTransaction.commit();
        entityManager.close();
    }

    public static void update5() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person().setPersonId(5L).setName("abol").setFamily("bb");
        entityManager.merge(person); // id k ma dadim ro nadide migire va ba sequence khodesh mire jolo

        entityTransaction.commit();
        entityManager.close();
    }

    public static void update6() { // mikhaym dar DB update nashe
        EntityManager entityManager = JPA.getEntityManager();

        Person person = entityManager.find(Person.class, 1L);
        person.setName("ali");
        System.out.println(person.getName());
        person = entityManager.find(Person.class, 1L);
        System.out.println(person.getName());

        entityManager.close();
    }

    public static void update7() {// mikhaym dar DB update nashe (ye ravesh dg)
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = entityManager.find(Person.class, 1L);
        entityManager.detach(person);
        person.setName("ali");

        entityTransaction.commit();
        entityManager.close();
    }

    public static void remove1() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class, 2L);
        entityManager.remove(person);

        entityTransaction.commit();
        entityManager.close();
    }


    public static void update8() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("update  personEntity e set e.name=:n where e.personId=:x");
        query.setParameter("n", "abolllll");
        query.setParameter("x", 3L);
        query.executeUpdate();

        entityTransaction.commit();
        entityManager.close();
    }

    public static void findOne() {
        EntityManager entityManager = JPA.getEntityManager();
        Person person = entityManager.find(Person.class, 1L);
        System.out.println(person.getName());
        System.out.println(person.getFamily());
        System.out.println(person.getPersonId());
        entityManager.close();
    }

    public static void findAll1() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select o from personEntity o");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getPersonId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }
        entityManager.close();
    }

    public static void findAll2() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNativeQuery("select  * from person", Person.class);
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getPersonId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());

        }
        entityManager.close();
    }

    public static void findAll3() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from person where name=:myParam", Person.class);
        query.setParameter("myParam" , "abolllll");
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getPersonId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }

    }

    public static void findAll4(){
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select o from personEntity o where o.name=:myParam");
        query.setParameter("myParam" , "abolllll");
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getPersonId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }
    }
    public static void findAll5(){
        EntityManager entityManager  = JPA.getEntityManager();
        Query query = entityManager.createNamedQuery("x1"); // az class Person tolid mishe
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getPersonId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }
    }
    public static void main(String[] args) {
        //save1();
        //save2();
        //update1();
        //update2();
        //update3();
        //update4();
        //update5();
        //update6();
        //update7();
        //update8();
        //remove1();
        //findOne();
        findAll1();
        //findAll2();
        //findAll3();
        //findAll4();
        //findAll5();
    }


}
