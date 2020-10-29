package eu.ensup.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.User;
import eu.ensup.dao.IUserDao2;

public class UserDao2 implements IUserDao2 {

	private static final Logger monLogger = LogManager.getLogger(CourseDao.class);

	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	public UserDao2() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("demojpapartiel");
		entityManager = entityManagerFactory.createEntityManager();	
		monLogger.info("Init User DAO");
	}
	
	@Override
	public User getUser(String login, String password) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user = entityManager.createNamedQuery("getUser", User.class).setParameter("login",login).
					setParameter("password", password).getSingleResult();
			//User user = new User();	
		monLogger.info("Login  User DAO");
		return user;
	}
	
	
}
