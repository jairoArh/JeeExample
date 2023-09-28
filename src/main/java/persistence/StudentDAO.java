package persistence;

import com.example.demoprog3.logic.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements InterfaceDAO<Student>{
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/db_uptc?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "userUptc";
    private final String PASSWORD = "uptc4321";

    @Override
    public List findAll() {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
                ){
            String query = "SELECT * FROM student";
            ResultSet rs = statement.executeQuery( query );
            List<Student> list = new ArrayList<>();

            while (rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString("name");
                Character gender = rs.getString(3).charAt(0);
                String city = rs.getString(4);
                Date aux = rs.getDate( 5 );
                LocalDate birthday = aux.toLocalDate();

                list.add( new Student(id,name,gender,city,birthday) );
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student findById(Integer idFind) {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM student WHERE id='" + idFind + "'";
            ResultSet rs = statement.executeQuery( query );
            Student student = null;

            while (rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString("name");
                Character gender = rs.getString(3).charAt(0);
                String city = rs.getString(4);
                Date aux = rs.getDate( 5 );
                LocalDate birthday = aux.toLocalDate();

                student = new Student(id,name,gender,city,birthday);
            }

            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Student student) {

        String id = "0";

        String name = student.getName();

        String gender = String.valueOf(student.getGender());

        String city = student.getCity();

        String birthday = student.getBirthday().toString();

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO student VALUES('" + id + "','" + name  + "','" + gender + "','" + city + "','" + birthday + "')";

            int rows = statement.executeUpdate( query );

            return rows > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Student update(Student object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
