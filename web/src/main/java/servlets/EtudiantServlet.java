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

/**
 * Servlet implementation class EtudiantServlet
 */
//@WebServlet("/Etudiant")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentService studentService;
	private CourseService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantServlet() {
		courseService = new CourseService();
		studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		

		session.setAttribute("students", lister());
		session.setAttribute("courses", getAllCourses());
		
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
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
