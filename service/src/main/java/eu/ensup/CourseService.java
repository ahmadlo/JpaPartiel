package eu.ensup;

import java.util.List;

import eu.ensup.dao.ICourseDao;
import eu.ensup.daoImpl.CourseDao;
import eu.ensup.Course;

/**
 * CourseService
 * 
 * @author DANON
 *
 */
public class CourseService {

	ICourseDao idao;
	CourseDao dao;
	
	public CourseService(CourseDao dao) {
		this.dao = dao;
	}

	public CourseService() {
		super();
		dao = new CourseDao();
	}

	/**
	 * associate course 
	 * @param course
	 * @param long1
	 */
//	public void associateCourse(String course, Long long1) {
//		dao.associateCourse(course, long1);
//	}

	public List<Course> getAllCourses() {		
		return dao.getAllCourses();
	}

}
