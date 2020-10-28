package eu.ensup;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("user")
@NamedQueries({
	@NamedQuery(name = "getUser", query = "select u from User u where u.login= :login and u.password= :password")
})
public class User  extends Person{

	
	private String login;
	private String password;
	private String profil;
	
	public User(String firstName, String lastName, String mailAdresse, String adress, String numberPhone, String login,
			String password, String profil) {
		super(firstName, lastName, mailAdresse, adress, numberPhone);
		this.login = login;
		this.password = password;
		this.profil = profil;
	}

	
	
	public User() {
		super();
	}



	public User(Long id, String firstName, String lastName, String mailAdresse, String adress, String numberPhone,
			String login, String password, String profil) {
		super(id, firstName, lastName, mailAdresse, adress, numberPhone);
		this.login = login;
		this.password = password;
		this.profil = profil;
	}

	public User(String login, String password, String profil) {
		super();
		this.login = login;
		this.password = password;
		this.profil = profil;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	
	
}
