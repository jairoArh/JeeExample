import com.example.demoprog3.logic.Student;
import com.google.gson.Gson;
import persistence.StudentDAO;
import sun.util.resources.LocaleData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet(name = "ServletSendStudent", value = "/add-student")
public class ServletSendStudent extends HttpServlet {
    private StudentDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Gson gson = new Gson();

        Integer id = Integer.parseInt(request.getParameter("idStudent"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String birthday = request.getParameter("birthday");
        //Convertimos la fecha que viene como un String ("2023-08-25") a un arreglo de String ([2023,8,23]), para
        //convertor los datos a valores numéricos y poder instanciar un LocalDate
        String[] aux = birthday.split("-");
        int year = Integer.parseInt( aux[0]);
        int month = Integer.parseInt( aux[1]);
        int day = Integer.parseInt( aux[2]);
        LocalDate btd = LocalDate.of( year,month,day);
        Student student = new Student( id, name, gender.charAt(0), city, btd);

        try(
                PrintWriter out = response.getWriter();
        ){
            if( stDAO.add( student) ){
                out.println(gson.toJson(student));
            }else{
                out.println(gson.toJson( null ));
            }
        }
    }
}
