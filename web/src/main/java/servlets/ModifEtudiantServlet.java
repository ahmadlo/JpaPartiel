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
 * Servlet implementation class ModifEtudiantServlet
 */
public class ModifEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private RequestDispatcher dispatcher = null;
	private CourseService courseService;
	private User user = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifEtudiantServlet() {
		studentService = new StudentService();
		courseService = new CourseService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = new Student(
				request.getParameter("firstName"), 
				request.getParameter("lastName"),
				request.getParameter("mailAdresse"), 
				request.getParameter("adress"),
				request.getParameter("numberPhone"), 
				request.getParameter("dateOfBirth"));

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		
		studentService.updateStudent(student);

		session.setAttribute("student", null);
		session.setAttribute("students", lister(student));
		session.setAttribute("courses", getAllCourses());
		
		if(user.getProfil().equalsIgnoreCase("R")) {
			
			dispatcher = request.getRequestDispatcher("rechercheEtudiant.jsp");

		}
		else {
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		}
		dispatcher.forward(request, response);
	}

	private List<Student> lister(Student student) {

		List<Student> students = Collections.emptyList();
		try {
			
			if(user.getProfil().equalsIgnoreCase("D")) {
			students = studentService.readAllStudent();
			} else {
				students.add(student);
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
