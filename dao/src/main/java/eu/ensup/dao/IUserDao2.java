package eu.ensup.dao;

import eu.ensup.User;

public interface IUserDao2 {

	User getUser(String login, String password);

}