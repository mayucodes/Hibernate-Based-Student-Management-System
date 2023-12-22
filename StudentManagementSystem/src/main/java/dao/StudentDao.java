package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Student;
import util.HibernateUtil;

/**
 * Implementation of the data access object (DAO) for the Student entity.
 */
public class StudentDao implements IStudentDao {

    /**
     * Save a new student to the database.
     */
    @Override
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start the transaction
            transaction = session.beginTransaction();
            // Save the student object
            session.persist(student);
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * Update an existing student in the database.
     */
    @Override
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start the transaction
            transaction = session.beginTransaction();
            // Update the student object
            session.merge(student);
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * Retrieve a student from the database by their ID.
     */
    @Override
    public Student getStudentById(long id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start the transaction
            transaction = session.beginTransaction();
            // Get the student object by ID
            student = session.get(Student.class, id);
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return student;
    }

    /**
     * Retrieve a list of all students from the database using CriteriaQuery.
     */
    @Override
    public List<Student> getAllStudents() {
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start the transaction
            transaction = session.beginTransaction();
            // Use CriteriaQuery to get all students
            CriteriaQuery<Student> cq = session.getCriteriaBuilder().createQuery(Student.class);
            cq.from(Student.class);
            students = session.createQuery(cq).getResultList();
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
    }

    /**
     * Delete a student from the database by their ID.
     */
    @Override
    public void deleteStudent(long id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start the transaction
            transaction = session.beginTransaction();
            // Get the student object by ID
            student = session.get(Student.class, id);
            // Delete the student object
            session.remove(student);
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

