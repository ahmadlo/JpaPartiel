package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.Student;
import eu.ensup.User;
import eu.ensup.IStudentService;
import eu.ensup.StudentService;

/**
 * Servlet implementation class RechercheEtudiantServlet
 */
public class RechercheEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = null;
	private IStudentService studentService;
	private RequestDispatcher dispatcher = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheEtudiantServlet() {
		super();
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");
		List<Student> students = studentService.getStudentByResearch(request.getParameter("firstNameR"), request.getParameter("lastNameR"));
		System.out.println(students.get(0).getFirstName());
		System.out.println(students.get(0));
		if(user.getProfil().equalsIgnoreCase("R")) {
			
			dispatcher = request.getRequestDispatcher("updateDelete.jsp");
			session.setAttribute("student", students.get(0));
		}
		
		else {
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
			session.setAttribute("students", students);


		}
		
		
		dispatcher.forward(request, response);
	}
	
	
}
