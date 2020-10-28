package eu.ensup;

import eu.ensup.daoImpl.UserDao2;
import eu.ensup.User;

/**
 * CourseService
 * 
 * @author DANON
 *
 */
public class UserService {


	//IUserDao idao;
	private UserDao2 dao;
	
	public UserService() {
		
		this.dao = new UserDao2();
		}
			
			

	

	/**
	 * get an user
	 * @param login
	 * @param password
	 * @return 
	 */
	public User getUser(String login, String password) {
		return dao.getUser(login, password);
	}

}
