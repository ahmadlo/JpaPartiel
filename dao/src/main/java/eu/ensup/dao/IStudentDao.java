package eu.ensup.dao;

import java.util.ArrayList;

import eu.ensup.Student;

public interface IStudentDao {

	public void createStudent(Student student);
	
	public Student getStudent(int  id);
	
	public Student getUser(String email);
	
	public ArrayList<Student> readAllStudent();
	
	public void deleteStudent(int id);
	
	public void  updateStudent(Student student);
}
