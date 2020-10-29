package eu.ensup.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.Student;
import eu.ensup.dao.IStudentDao2;

public class StudentDao2 implements IStudentDao2 {
	
	private static final Logger monLogger = LogManager.getLogger(CourseDao.class);

	
	private EntityManagerFactory entityManagerFactory ;
	private EntityManager entityManager;
	
	public StudentDao2() {
		entityManagerFactory = Persistence.createEntityManagerFactory("demojpapartiel");
		entityManager = entityManagerFactory.createEntityManager();
		monLogger.info("Init Student DAO");
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
		monLogger.info("Create Student");
	}
	/**
	 * Recherche un etudiant par son id
	 * @param id
	 * @return un etudiant
	 */
	
	@Override
	public Student getStudent(long id) {

		Student student = entityManager.find(Student.class, id);
		monLogger.info("Get Student");
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
		monLogger.info("Update Student");
		
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
		monLogger.info("delete Student");
		
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
		monLogger.info("Listingg Student");
		
		return entityManager.createNamedQuery("getAllStudent", Student.class).getResultList();
	}
	
	
	@Override
	public List<Student> getStudentByResearch(String firstName, String lastName){
		monLogger.info("Research Student");
		List<Student> listStudent = entityManager.createNamedQuery("getStudentByResearch", Student.class).setParameter("firstName",firstName).
				setParameter("lastName", lastName).getResultList();
		
		return listStudent;
		
	}
	
	@Override
	public Student getStudentByEmail(String email) {
		monLogger.info("get by Email Student");
		
		Student student = entityManager.createNamedQuery("getStudentByEmail", Student.class).setParameter("email",email)
				.getSingleResult();
		
		return student;
	}
	


	

}
