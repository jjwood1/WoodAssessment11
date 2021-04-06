package Controller;
import model.Car;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddCarServlet() {
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		Car myCar = new Car(name, year);
		CarHelper dao = new CarHelper();
		dao.insertItem(myCar);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
