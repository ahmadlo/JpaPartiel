package eu.ensup.dao;

import eu.ensup.User;

/**
 * Interface CourseDao
 * 
 * @author DANON
 *
 */
public interface IUserDao {

	public User getUser(String login, String password);
}
