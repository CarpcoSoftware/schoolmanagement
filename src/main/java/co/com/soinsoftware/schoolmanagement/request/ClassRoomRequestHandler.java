package co.com.soinsoftware.schoolmanagement.request;

import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.soinsoftware.schoolmanagement.bll.ClassRoomBLL;
import co.com.soinsoftware.schoolmanagement.entity.ClassRoomBO;
import co.com.soinsoftware.schoolmanagement.mapper.ClassRoomMapper;
import co.com.soinsoftware.schoolmanagement.util.ServiceLocator;

/**
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 05/06/2015
 */
@Path("/schoolmanagement/classroom/")
public class ClassRoomRequestHandler {

	private static final String PATH_ALL = "all";
	private static final String PATH_BY = "by";
	private static final String PATH_SAVE = "save";
	private static final String PATH_VALIDATE = "validate";

	private static final String PARAMETER_CLASSROOM_ID = "classRoomId";
	private static final String PARAMETER_CODE = "code";
	private static final String PARAMETER_GRADE = "grade";
	private static final String PARAMETER_OBJECT = "object";
	private static final String PARAMETER_SCHOOL_ID = "schoolId";
	private static final String PARAMETER_TIME = "time";
	private static final String PARAMETER_YEAR = "year";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ClassRoomRequestHandler.class);

	@Autowired
	private final ClassRoomBLL classRoomBLL = ServiceLocator
			.getBean(ClassRoomBLL.class);

	@GET
	@Path(PATH_ALL)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<ClassRoomBO> findAll(
			@QueryParam(PARAMETER_SCHOOL_ID) final int schoolId) {
		final Set<ClassRoomBO> classRoomSet = classRoomBLL.findAll(schoolId);
		LOGGER.info("findAll function loads {}", classRoomSet.toString());
		return classRoomSet;
	}

	@GET
	@Path(PATH_BY)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<ClassRoomBO> findBy(
			@QueryParam(PARAMETER_CLASSROOM_ID) final Integer classRoomId,
			@QueryParam(PARAMETER_SCHOOL_ID) final int schoolId,
			@QueryParam(PARAMETER_YEAR) final String year,
			@QueryParam(PARAMETER_GRADE) final Integer grade,
			@QueryParam(PARAMETER_TIME) final Integer time) {
		final Set<ClassRoomBO> classRoomSet = classRoomBLL.findBy(classRoomId,
				schoolId, year, grade, time);
		LOGGER.info("findBy function loads {}", classRoomSet.toString());
		return classRoomSet;
	}

	@POST
	@Path(PATH_SAVE)
	@Produces(MediaType.APPLICATION_JSON)
	public ClassRoomBO save(@FormParam(PARAMETER_OBJECT) final String jsonObject) {
		ClassRoomBO classRoomBO = null;
		final ClassRoomBO newClassRoomBO = new ClassRoomMapper()
				.geObjectFromJSON(jsonObject);
		if (newClassRoomBO != null) {
			classRoomBO = classRoomBLL.saveRecord(newClassRoomBO);
			LOGGER.info("save function applied to {}", classRoomBO);
		}
		return classRoomBO;
	}

	@GET
	@Path(PATH_VALIDATE)
	@Produces(MediaType.TEXT_PLAIN)
	public String validateExistingByCode(
			@QueryParam(PARAMETER_SCHOOL_ID) final int schoolId,
			@QueryParam(PARAMETER_CODE) final String code,
			@QueryParam(PARAMETER_CLASSROOM_ID) final int classRoomId) {
		final ClassRoomBO classRoomBO = classRoomBLL.findByCode(schoolId, code,
				classRoomId);
		final String validCode = Boolean.toString(classRoomBO == null);
		LOGGER.info("code {} is valid = {}", code, validCode);
		return validCode;
	}
}
