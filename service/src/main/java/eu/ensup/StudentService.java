package eu.ensup;

import java.util.List;

import eu.ensup.daoImpl.StudentDao2;
import eu.ensup.Student;

/**
 * StudentService
 * 
 * @author DANON
 *
 */
public class StudentService implements IStudentService {

	/*
	 * IStudentDao idao; StudentDao dao;
	 */
	private StudentDao2 dao;
	
	public StudentService() {
		this.dao = new StudentDao2();
	}
	


	@Override
	public void createStudent(Student student) {
		dao.createStudent(student);
	}

	/**
	 * Read all informations of all students
	 * @return List<Student>
	 */
	 
	@Override
	public List<Student> readAllStudent() {
		return dao.readAllStudent();
	}

	/**
	 * Upadate a student information
	 * @param student
	 */
	@Override
	public void updateStudent(Student student) {
		dao.updateStudent(student);
	}

	/**	
	 * delete a student information
	 * @param i
	 */
	@Override
	public boolean deleteStudent(int id) {
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
		return dao.getStudent(i);
	}

	/**
	 * get user
	 * @param email
	 * @return
	 */
	@Override
	public Student getStudentByEmail(String email) {
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
		return dao.getStudentByResearch(firstName, lastName);
	}
}
