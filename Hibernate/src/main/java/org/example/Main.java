package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Create Student object
        //automatically creates a table
        Student student = new Student();
        student.setId(6);
        student.setName("Mohn");
        student.setAge(18);

        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class ).configure().buildSessionFactory();
        Session session = sf.openSession();
        //transaction updates the database - commits the changes to database
        Transaction tx = session.beginTransaction();

        //Create
        /*Read
        create a session 7 beginTransaction
        then just persist the object
        * */
        //insert into Student (age,name,id) values (?,?,?)
//        session.persist(student);

        //Read
        /*
        simply find that using two params (class,primary key)
        and returns a object
        * */
//        select s1_0.id,s1_0.age,s1_0.name from Student s1_0 where s1_0.id=?
//        Student st = session.find(Student.class,1);
//        System.out.println(st.getId() + " " +st.getAge() +" "+ st.getName());
//

        //Update
        /*
        * update Student set age=?,name=? where id=?
        * */
//        session.merge(student);
//        Student st2 =session.find(Student.class,6);
//        System.out.println(st2);


        //Delete
        /*
        what did is we first got the student which we need to delete using find
        then we passed object and removed it
        simple ass
        * delete from Student where id=?
        * */
//        Student s3 = session.find(Student.class, 2);
//        session.remove(s3);

        //commit should be always at last so that all the transactions get commited to the database
        tx.commit();

        session.close();
        sf.close();

    }
}
