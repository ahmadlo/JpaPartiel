package eu.ensup;

import java.util.List;

import eu.ensup.Student;

public interface IStudentService {

	void createStudent(Student student);

	/**
	 * Read all informations of all students
	 * @return List<Student>
	 */

	List<Student> readAllStudent();

	/**
	 * Upadate a student information
	 * @param student
	 */
	void updateStudent(Student student);

	/**	
	 * delete a student information
	 * @param i
	 */
	boolean deleteStudent(int id);

	/**
	 * get a student information
	 * @param student
	 * @return
	 */
	Student getStudent(int i);

	/**
	 * get user
	 * @param email
	 * @return
	 */
	Student getStudentByEmail(String email);

	/**
	 * Research a student
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	List<Student> getStudentByResearch(String firstName, String lastName);

}