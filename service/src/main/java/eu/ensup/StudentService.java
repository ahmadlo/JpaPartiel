package eu.ensup;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.daoImpl.StudentDao2;
import eu.ensup.Student;

/**
 * StudentService
 * 
 * @author DANON
 *
 */
public class StudentService implements IStudentService {
	
	private static final Logger monLogger = LogManager.getLogger(StudentService.class);


	/*
	 * IStudentDao idao; StudentDao dao;
	 */
	private StudentDao2 dao;
	
	public StudentService() {
		this.dao = new StudentDao2();
		monLogger.info("Demarrage du Logger : StudentService");
	}
	


	@Override
	public void createStudent(Student student) {
		dao.createStudent(student);
		monLogger.info("On crée un Student");
	}

	/**
	 * Read all informations of all students
	 * @return List<Student>
	 */
	 
	@Override
	public List<Student> readAllStudent() {
		monLogger.info("Listing Student");
		return dao.readAllStudent();
	}

	/**
	 * Upadate a student information
	 * @param student
	 */
	@Override
	public void updateStudent(Student student) {
		monLogger.info("Update Student");
		dao.updateStudent(student);
	}

	/**	
	 * delete a student information
	 * @param i
	 */
	@Override
	public boolean deleteStudent(int id) {
		monLogger.info("Suppression Student");
		 return dao.deleteStudent(id);		
	}

	/**
	 * get a student information
	 * @param student
	 * @return
	 */
	@Override
	public Student getStudent(int i) {
		// TODO Auto-generated method stub
		monLogger.info("get Student");
		return dao.getStudent(i);
	}

	/**
	 * get user
	 * @param email
	 * @return
	 */
	@Override
	public Student getStudentByEmail(String email) {
		monLogger.info("get Student by mail");
		return dao.getStudentByEmail(email);
	}
	
	/**
	 * Research a student
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@Override
	public List<Student> getStudentByResearch(String firstName, String lastName){
		monLogger.info("get Student by research");
		return dao.getStudentByResearch(firstName, lastName);
	}
}
