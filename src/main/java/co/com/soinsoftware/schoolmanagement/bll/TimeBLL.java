/**
 * 
 */
package co.com.soinsoftware.schoolmanagement.bll;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.soinsoftware.schoolmanagement.dao.TimeDAO;
import co.com.soinsoftware.schoolmanagement.entity.TimeBO;
import co.com.soinsoftware.schoolmanagement.hibernate.Bztime;

/**
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 27/08/2015
 */
@Service
public class TimeBLL extends AbstractBLL implements IBusinessLogicLayer<TimeBO, Bztime> {
	
	@Autowired
	private TimeDAO timeDAO;

	@Override
	public Set<TimeBO> findAll() {
		return this.isCacheEmpty(TIME_KEY) ? this.selectAndPutInCache() : this.getObjectsFromCache();
	}

	@Override
	public TimeBO findByIdentifier(final Integer identifier) {
		TimeBO timeBO = null;
		if (!this.isCacheEmpty(TIME_KEY)) {
			timeBO = (TimeBO) this.getObjectFromCache(TIME_KEY, identifier);
		}
		if (timeBO == null) {
			timeBO = this.selectByIdentifierAndPutInCache(identifier);
		}
		if (timeBO != null) {
			LOGGER.info("time = {} was loaded successfully",
					timeBO.toString());
		}
		return timeBO;
	}

	@Override
	public TimeBO findByCode(final String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public TimeBO saveRecord(final TimeBO record) {
		return record.getId() == 0 ? 
				this.insertRecord(record) : 
				this.updateRecord(record);
	}

	@Override
	public TimeBO insertRecord(final TimeBO newRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeBO updateRecord(final TimeBO record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TimeBO> selectAndPutInCache() {
		final Set<Bztime> bzTimeSet = this.timeDAO.select();
		final Set<TimeBO> timeBOSet = this
				.createEntityBOSetUsingHibernatEntities(bzTimeSet);
		if (timeBOSet != null) {
			this.putObjectsInCache(TIME_KEY, timeBOSet);
		}
		return timeBOSet;
	}

	@Override
	public TimeBO selectByIdentifierAndPutInCache(final Integer identifier) {
		TimeBO timeBO = null;
		final Bztime bzTime = this.timeDAO.selectByIdentifier(identifier);
		if (bzTime != null) {
			timeBO = new TimeBO(bzTime);
			this.putObjectInCache(TIME_KEY, timeBO);
		}
		return timeBO;
	}

	@Override
	public Set<TimeBO> createEntityBOSetUsingHibernatEntities(
			final Set<?> hibernateEntitySet) {
		Set<TimeBO> timeBOSet = null;
		if (hibernateEntitySet != null && hibernateEntitySet.size() > 0) {
			timeBOSet = new HashSet<>();
			for (Object bzTime : hibernateEntitySet) {
				if (bzTime instanceof Bztime) {
					timeBOSet.add(new TimeBO(
							(Bztime) bzTime));
				}
			}	
		}
		return timeBOSet;
	}
	
	@SuppressWarnings("unchecked")
	protected Set<TimeBO> getObjectsFromCache() {
		LOGGER.info("Loading times entities from cache");
		return this.getObjectsFromCache(TIME_KEY);
	}
	
	@Override
	public Bztime buildHibernateEntity(TimeBO timeBO) {
		Bztime bzTime = new Bztime();
		if (timeBO != null) {
			bzTime.setId(timeBO.getId());
			bzTime.setCode(timeBO.getCode());
			bzTime.setName(timeBO.getName());
			bzTime.setCreation(timeBO.getCreation());
			bzTime.setUpdated(timeBO.getUpdated());
			bzTime.setEnabled(timeBO.isEnabled());
		}
		return bzTime;
	}

	@Override
	public TimeBO putObjectInCache(Bztime record) {
		// TODO Auto-generated method stub
		return null;
	}
}