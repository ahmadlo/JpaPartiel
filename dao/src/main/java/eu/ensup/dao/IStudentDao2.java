package eu.ensup.dao;

import java.util.List;

import eu.ensup.Student;

public interface IStudentDao2 {

	/**
	 *  Creer un etudiant
	 * @param student
	 */

	void createStudent(Student student);

	/**
	 * Recherche un etudiant par son id
	 * @param id
	 * @return un etudiant
	 */

	Student getStudent(long id);

	/**
	 * Modifier les informations d'un etudiant
	 * @param student
	 */
	void updateStudent(Student student);

	/**
	 * Supprime un etudiant 
	 * @param id
	 */
	boolean deleteStudent(long id);

	/**
	 * Recupere la liste des etudiants 
	 * @return une liste etudiant
	 */
	List<Student> readAllStudent();

	List<Student> getStudentByResearch(String firstName, String lastName);

	Student getStudentByEmail(String email);

}