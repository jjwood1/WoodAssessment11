package Controller;
import model.SoldCar;
import model.Customer;
import java.time.LocalDate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SellCarServlet
 */
@WebServlet("/sellCarServlet")
public class SellCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellCarServlet() {
       // super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String owner = request.getParameter("owner");
		LocalDate DateSold = LocalDate.now();
		Customer myCustomer = new Customer(owner);
		CustomerHelper dao1 = new CustomerHelper();
		//dao1.insertItem(myCustomer);
		//SoldCar mySoldCar = new SoldCar(name, year, owner, DateSold);
		SoldCar mySoldCar = new SoldCar(name, year, DateSold, myCustomer);
		
		SoldCarHelper dao = new SoldCarHelper();
		dao.insertItem(mySoldCar);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
