package co.com.soinsoftware.schoolmanagement.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.com.soinsoftware.schoolmanagement.bll.ClassRoomBLL;
import co.com.soinsoftware.schoolmanagement.entity.ClassRoomBO;
import co.com.soinsoftware.schoolmanagement.mapper.ClassRoomMapper;

/**
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 05/06/2015
 */
@Path("/schoolmanagement/classroom/")
public class ClassRoomRequestHandler extends AbstractRequestHandler {

	private final ClassRoomBLL classRoomBLL = ClassRoomBLL.getInstance();

	@GET
	@Path(PATH_ALL)
	@Produces(APPLICATION_JSON)
	public Set<ClassRoomBO> findAll(
			@QueryParam(PARAMETER_SCHOOL_ID) final int schoolId) {
		final Set<ClassRoomBO> classRoomSet = classRoomBLL.findAll(schoolId);
		LOGGER.info("findAll function loads {}", classRoomSet.toString());
		return classRoomSet;
	}

	@GET
	@Path(PATH_BY)
	@Produces(APPLICATION_JSON)
	public Set<ClassRoomBO> findBy(
			@QueryParam(PARAMETER_CLASSROOM_ID) final Integer classRoomId,
			@QueryParam(PARAMETER_SCHOOL_ID) final int schoolId,
			@QueryParam(PARAMETER_YEAR) final String year,
			@QueryParam(PARAMETER_GRADE) final Integer grade,
			@QueryParam(PARAMETER_TIME) final Integer time) {
		final Set<ClassRoomBO> classRoomSet = classRoomBLL.findBy(classRoomId,
				schoolId, year, grade, time, true);
		LOGGER.info("findBy function loads {}", classRoomSet.toString());
		return classRoomSet;
	}

	@POST
	@Path(PATH_SAVE)
	@Produces(APPLICATION_JSON)
	public ClassRoomBO save(@FormParam(PARAMETER_OBJECT) final String jsonObject) {
		ClassRoomBO savedClassRoom = null;
		final ClassRoomBO classRoom = new ClassRoomMapper()
				.geObjectFromJSON(jsonObject);
		if (classRoom != null) {
			savedClassRoom = classRoomBLL.saveRecord(classRoom);
			LOGGER.info("save function applied to {}", savedClassRoom);
		}
		return savedClassRoom;
	}

	@POST
	@Path(PATH_SAVE_CLASSROOM_X_STUDENT)
	@Produces(APPLICATION_JSON)
	public Set<ClassRoomBO> saveClassRoomxStudent(
			@FormParam(PARAMETER_OBJECT) final String jsonObject) {
		final Set<ClassRoomBO> classRoomSet = new HashSet<>();
		final List<ClassRoomBO> classRoomList = new ClassRoomMapper()
				.getObjectListFromJSON(jsonObject);
		if (!classRoomList.isEmpty()) {
			for (final ClassRoomBO classRoom : classRoomList) {
				final ClassRoomBO savedClassRoom = classRoomBLL
						.saveClassRoomXStudent(classRoom);
				classRoomSet.add(savedClassRoom);
				LOGGER.info("saveClassRoomxStudent function applied to {}",
						savedClassRoom);
			}
		}
		return classRoomSet;
	}

	@GET
	@Path(PATH_VALIDATE)
	@Produces(MediaType.TEXT_PLAIN)
	public String validateExistingByCode(
			@QueryParam(PARAMETER_SCHOOL_ID) final int schoolId,
			@QueryParam(PARAMETER_CODE) final String code,
			@QueryParam(PARAMETER_CLASSROOM_ID) final int classRoomId) {
		final ClassRoomBO classRoom = classRoomBLL.findByCode(schoolId, code,
				classRoomId);
		final String validCode = Boolean.toString(classRoom == null);
		LOGGER.info("code {} is valid = {}", code, validCode);
		return validCode;
	}
}