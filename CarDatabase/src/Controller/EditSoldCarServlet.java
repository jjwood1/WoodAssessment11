package Controller;

import model.SoldCar;
import model.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditSoldCarServlet
 */
@WebServlet("/editSoldCarServlet")
public class EditSoldCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSoldCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SoldCarHelper dao = new SoldCarHelper();
		
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String owner = request.getParameter("owner");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Customer myCustomer = new Customer(owner);
		myCustomer.setCustomerName(owner);
		SoldCar SoldCarToUpdate = dao.searchForSoldCarById(tempId);
		SoldCarToUpdate.setName(name);
		SoldCarToUpdate.setYear(year);
		SoldCarToUpdate.setCustomer(myCustomer);
		
		dao.updateSoldCar(SoldCarToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllSoldCarsServlet").forward(request, response);
	}

}
