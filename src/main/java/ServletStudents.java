import com.example.demoprog3.logic.Student;
import com.google.gson.Gson;
import persistence.StudentDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletStidents", value = "/servlet-students")
public class ServletStudents extends HttpServlet {

    private StudentDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<Student> students = stDAO.findAll();


        PrintWriter out = response.getWriter();
        out.println( gson.toJson( students ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
