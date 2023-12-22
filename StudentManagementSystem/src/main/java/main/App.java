package main;

import java.util.List;
import dao.IStudentDao;
import dao.StudentDao;
import model.Student;

public class App {

    /**
     * 
     */
    public static void main(String[] args) {
        IStudentDao studentDao = new StudentDao();

        // test saveStudent
        Student student = new Student("Mayumi", "Shehara", "mayumi@gmail.com");
        Student student2 = new Student("Ruvini", "Medagedara", "ruvini@gmail.com");
        
        studentDao.saveStudent(student);
        studentDao.saveStudent(student2);

        // test updateStudent
        student.setFirstName("Mayu");
        studentDao.updateStudent(student);

//        // test getStudentById
//        Student student2 = studentDao.getStudentById(student.getId());
//        System.out.println(student2);
//        

        // test getAllStudents
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }

        // test deleteStudent
        studentDao.deleteStudent(2);
    }
}

