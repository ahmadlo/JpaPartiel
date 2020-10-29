package eu.ensup;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private static final Logger monLogger = LogManager.getLogger(CourseService.class);


	ICourseDao idao;
	CourseDao dao;
	
	public CourseService(CourseDao dao) {
		this.dao = dao;
	}

	public CourseService() {
		super();
		dao = new CourseDao();
		monLogger.info("Demarrage du Logg");
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
		monLogger.info("listing des Courses ");
		return dao.getAllCourses();
		
	}

}
