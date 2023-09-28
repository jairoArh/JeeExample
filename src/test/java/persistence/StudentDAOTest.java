package persistence;

import com.example.demoprog3.logic.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private StudentDAO stDAO;

    @Test
    void findAll() {
        stDAO = new StudentDAO();
        assertNotNull( stDAO.findAll());
        stDAO.findAll().forEach(System.out::println);
    }

    @Test
    void findById() {
        stDAO = new StudentDAO();
        Student student = stDAO.findById(3);

        assertEquals('F',student.getGender());
        assertEquals("Arelys de Jesús Gómez Pérez",student.getName());
    }

    @Test
    void add() {
        stDAO = new StudentDAO();
        assertTrue( stDAO.add( new Student(0,"Vicente Rios",'M',"Bogota", LocalDate.of(1990, Month.JUNE,10))));
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}