/**
 * 
 */
package co.com.soinsoftware.schoolmanagement.request;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.soinsoftware.schoolmanagement.bll.YearBLL;
import co.com.soinsoftware.schoolmanagement.entity.YearBO;

/**
 * 
 * @author Carlos Andres Rodriguez
 * @version 1.0
 * @since 29/06/2015
 */
@Path("/schoolmanagement/year/")
public class YearRequestHandler {
	
	private final YearBLL yearBLL = YearBLL.getInstance();

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<YearBO> findAll() {
		return yearBLL.findAll();
	}
	
	@GET
	@Path("currentYear")
	@Produces(MediaType.APPLICATION_JSON)
	public YearBO findCurrentYear() {
		return yearBLL.findCurrentYear();
	}
}
