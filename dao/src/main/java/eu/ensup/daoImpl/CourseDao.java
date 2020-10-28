package eu.ensup.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.ensup.Course;
import eu.ensup.Student;
import eu.ensup.dao.ICourseDao;

/**
 * Classe CRUD pour les cours.
 * @author 33651
 *
 */
public class CourseDao implements ICourseDao
{
	// Constructors
	
	/**
	 * Construit le CourseDao à partir de l'entityManager.
	 * @param entityManager
	 */
	public CourseDao()
	{
		super();
	}
	
	// Methods
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.ICourseDao#associateCourse(java.lang.String, int)
	 */
//	@Override
//	public void associateCourse(String courseTheme, int idStudent)
//	{
//		EntityManagerFactory entityManagerFactory =
//    			Persistence.createEntityManagerFactory("demojpa-pu");
//    	
//    	EntityManager entityManager = entityManagerFactory.createEntityManager();
//    	
//    	Student student = entityManager.find(Student.class, idStudent);
//    	
//    	if (student == null)
//    	{
//    		System.out.println("Cet id n'est attribué à aucun étudiant.");
//    		return;
//    	}
//    	
//    	// Ouverture transaction
//    	EntityTransaction transaction = entityManager.getTransaction();
//    	transaction.begin();
//    	
//    	student.getCourses().add(entityManager.find(Course.class, courseTheme));
//    	
////    	entityManager.persist(student);
//
//    	// Fermeture transaction
//    	transaction.commit();
//    	
//    	entityManager.close();
//		entityManagerFactory.close();
//	}

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.ICourseDao#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses()
	{
		EntityManagerFactory entityManagerFactory =
    			Persistence.createEntityManagerFactory("demojpa-pu");
    	
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	List<Course> courses = entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    	
    	entityManager.close();
		entityManagerFactory.close();
    	
    	return courses;
	}
}