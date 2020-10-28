package eu.ensup.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.ensup.Student;
import eu.ensup.dao.IStudentDao2;

public class StudentDao2 implements IStudentDao2 {
	
	private EntityManagerFactory entityManagerFactory ;
	private EntityManager entityManager;
	
	public StudentDao2() {
		entityManagerFactory = Persistence.createEntityManagerFactory("demojpapartiel");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	
	/**
	 *  Creer un etudiant
	 * @param student
	 */
	
	@Override
	public void createStudent(Student student) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(student);
		entityTransaction.commit();
		
	}
	/**
	 * Recherche un etudiant par son id
	 * @param id
	 * @return un etudiant
	 */
	
	@Override
	public Student getStudent(long id) {

		Student student = entityManager.find(Student.class, id);

		return student;
	}
	
	
	/**
	 * Modifier les informations d'un etudiant
	 * @param student
	 */
	@Override
	public void updateStudent(Student student) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
	}
	
	
	/**
	 * Supprime un etudiant 
	 * @param id
	 */
	@Override
	public boolean deleteStudent(long id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Student student = getStudent(id);
		entityManager.remove(student);
		entityTransaction.commit();
		Student studentVerify = getStudent(id);
		
		if(studentVerify == null) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Recupere la liste des etudiants 
	 * @return une liste etudiant
	 */
	@Override
	public List<Student> readAllStudent(){
		
		return entityManager.createNamedQuery("getAllStudent", Student.class).getResultList();
	}
	
	
	@Override
	public List<Student> getStudentByResearch(String firstName, String lastName){
		
		List<Student> listStudent = entityManager.createNamedQuery("getStudentByResearch", Student.class).setParameter("firstName",firstName).
				setParameter("lastName", lastName).getResultList();
		
		return listStudent;
		
	}
	
	@Override
	public Student getStudentByEmail(String email) {
		
		Student student = entityManager.createNamedQuery("getStudentByEmail", Student.class).setParameter("email",email)
				.getSingleResult();
		
		return student;
	}
	


	

}
