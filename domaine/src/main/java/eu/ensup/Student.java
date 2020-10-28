package eu.ensup;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Class Student
 * 
 * @author Student
 *
 */

@Entity
@DiscriminatorValue("student")
@NamedQueries({
	@NamedQuery(name = "getAllStudent", query = "select s from Student s "),
	@NamedQuery(name = "getStudentByResearch", query = "select st from Student st where st.firstName= :firstName and st.lastName= :lastName"),
	@NamedQuery(name = "getStudentByEmail", query = "select st from Student st where st.mailAdresse= :mailAdresse")
	

})


public class Student extends Person {

	private String dateOfBirth;
	
	@ManyToOne()
	private Course course;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	Collection<Course> courses;
	
	public Student() {
		super();
	}



	public Student(String firstName, String lastName, String mailAdresse, String adress, String numberPhone,
			String dateOfBirth) {
		super(firstName, lastName, mailAdresse, adress, numberPhone);
		this.dateOfBirth = dateOfBirth;
	}

	

	public Student(Long id, String firstName, String lastName, String mailAdresse, String adress, String numberPhone,
			String dateOfBirth) {
		super(id, firstName, lastName, mailAdresse, adress, numberPhone);
		this.dateOfBirth = dateOfBirth;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Student [dateOfBirth=" + dateOfBirth + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getMailAdresse()=" + getMailAdresse() + ", getAdress()="
				+ getAdress() + ", getNumberPhone()=" + getNumberPhone() + "]";
	}

}
