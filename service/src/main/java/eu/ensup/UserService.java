package eu.ensup;

import eu.ensup.daoImpl.UserDao2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.User;

/**
 * CourseService
 * 
 * @author DANON
 *
 */
public class UserService {

	
	private static final Logger monLogger = LogManager.getLogger(UserService.class);


	//IUserDao idao;
	private UserDao2 dao;
	
	public UserService() {
		
		this.dao = new UserDao2();
		monLogger.info("Demarrage du Logger : UserService");

		}
			
			

	

	/**
	 * get an user
	 * @param login
	 * @param password
	 * @return 
	 */
	public User getUser(String login, String password) {
		monLogger.info("On se  connecte");
		return dao.getUser(login, password);
	}

}
