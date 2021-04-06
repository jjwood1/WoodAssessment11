package Controller;
import model.SoldCar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavigationForSoldCarsServlet
 */
@WebServlet("/navigationForSoldCarsServlet")
public class NavigationForSoldCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationForSoldCarsServlet() {
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
		
		SoldCarHelper dao = new SoldCarHelper();
		
		String act = request.getParameter("doThisToItem");
		
		String path = "/viewAllSoldCarsServlet";
		
		if(act.equals("Delete"))
		{
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SoldCar SoldCarToDelete = dao.searchForSoldCarById(tempId);
				dao.deleteCar(SoldCarToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		
		}
		else if(act.equals("Edit"))
		{
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SoldCar soldCarToEdit = dao.searchForSoldCarById(tempId);
				request.setAttribute("soldCarToEdit", soldCarToEdit);
				path = "/edit-sold-car.jsp";
			}
			catch (NumberFormatException e)
			{
				System.out.println("Forgot to select a car");
			}
		}
		else if(act.equals("Return to index"))
		{
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
