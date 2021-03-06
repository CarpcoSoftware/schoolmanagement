/**
 * 
 */
package co.com.soinsoftware.schoolmanagement.request;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.soinsoftware.schoolmanagement.bll.GradeBLL;
import co.com.soinsoftware.schoolmanagement.entity.GradeBO;

/**
 * 
 * @author Carlos Andres Rodriguez
 * @version 1.0
 * @since 29/06/2015
 */
@Path("/schoolmanagement/grade/")
public class GradeRequestHandler {

	private final GradeBLL gradeBLL = GradeBLL.getInstance();

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<GradeBO> findAll() {
		return gradeBLL.findAll();
	}
}
