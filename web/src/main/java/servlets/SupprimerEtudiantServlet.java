package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.Course;
import eu.ensup.Student;
import eu.ensup.User;
import eu.ensup.CourseService;
import eu.ensup.IStudentService;
import eu.ensup.StudentService;
import eu.ensup.UserService;

/**
 * Servlet implementation class SupprimerEtudiantServlet
 */
public class SupprimerEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private CourseService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;

	/**
	 * Default constructor.
	 */
	public SupprimerEtudiantServlet() {
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);
		
		Student student = studentService.getStudent(id);
		System.out.println(student);
				
		boolean verifDelete = studentService.deleteStudent(id);

		user = (User) session.getAttribute("user");
		if(verifDelete == true) {
			session.setAttribute("message", "Suppression effectuée avec succès !!! ");
			session.setAttribute("alert", "success");
			if(user.getProfil().equalsIgnoreCase("R")) {
			
				dispatcher = request.getRequestDispatcher("rechercheEtudiant.jsp");
				
			}
			else {
				dispatcher = request.getRequestDispatcher("etudiant.jsp");
				
			}
	
		}
		else {
			
			session.setAttribute("message", "Suppression non  effectuée car l'etudiant est associé a un cours!!! ");
			session.setAttribute("alert", "error");
			if(user.getProfil().equalsIgnoreCase("R")) {
				session.setAttribute("student", student);
				dispatcher = request.getRequestDispatcher("updateDelete.jsp");
				
			}
			else {
				dispatcher = request.getRequestDispatcher("etudiant.jsp");
				
			}
		}    
		session.setAttribute("students", lister());
		session.setAttribute("courses", getAllCourses());
		
		
		
		dispatcher.forward(request, response);
	}

	private List<Student> lister() {

		List<Student> students = Collections.emptyList();
		try {
			if(user.getProfil().equalsIgnoreCase("D")) {
			students = studentService.readAllStudent();
			}
		} catch (Exception e) {

		}
		return students;
	}

	private List<Course> getAllCourses() {

		List<Course> courses = Collections.emptyList();
		try {

			courses = courseService.getAllCourses();
		} catch (Exception e) {

		}
		return courses;
	}

}
