package co.com.carpcosoftware.schoolmanagement.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import co.com.carpcosoftware.schoolmanagement.hibernate.Bzuser;
import co.com.carpcosoftware.schoolmanagement.util.Chronometer;

/**
 * User data access object
 * 
 * @author Carlos Andres Rodriguez
 * @version 1.0
 * @since 31/03/2015
 */
@Repository
public class UserDAO extends AbstractDAO implements IDataAccesable<Bzuser> {
	
	private static final String COLUMN_DOCUMENT_NUMBER = "documentNumber";
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Bzuser> select() {
		Set<Bzuser> bzUserSet = null;
		Chronometer chrono = this.startNewChronometer();
		
        try {
        	Query query = this.createQuery(this.getSelectStatementWithoutWhere());
        	bzUserSet = new HashSet<>(query.list());
        } catch (HibernateException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            this.stopChronometerAndLogMessage(chrono, UserDAO.class.getName() + ", Select function");
        }
		return bzUserSet;
	}

	@Override
	public Bzuser selectByIdentifier(Integer identifier) {
		Bzuser bzUser = null;
		Chronometer chrono = this.startNewChronometer();
		try {
        	Query query = this.createQuery(this.getSelectStatementByIdentifier());
        	query.setParameter(COLUMN_IDENTIFIER, identifier);
        	bzUser = (Bzuser) query.list().get(0);
        } catch (HibernateException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            this.stopChronometerAndLogMessage(chrono, UserDAO.class.getName() + ", selectByIdentifier function");
        }
		return bzUser;
	}
	
	public Bzuser selectByDocumentNumber(String documentNumber) {
		Bzuser bzUser = null;
		Chronometer chrono = this.startNewChronometer();
		try {
        	Query query = this.createQuery(this.getSelectStatementByDocumentNumber());
        	query.setParameter(COLUMN_DOCUMENT_NUMBER, documentNumber);
        	bzUser = (Bzuser) query.list().get(0);
        } catch (HibernateException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            this.stopChronometerAndLogMessage(chrono, UserDAO.class.getName() + ", selectByDocumentNumber function");
        }
		return bzUser;
	}

	@Override
	public boolean insert(Bzuser newRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bzuser record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getSelectStatementWithoutWhere() {
		StringBuilder sql = new StringBuilder();
		sql.append(STATEMENT_FROM);
		sql.append(TABLE_NAME_USER);		
		return sql.toString();
	}

	@Override
	protected String getInsertStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectStatementByIdentifier() {
		StringBuilder sql = new StringBuilder(this.getSelectStatementWithoutWhere());
		sql.append(STATEMENT_WHERE);
		sql.append(COLUMN_IDENTIFIER);
		sql.append(PARAMETER + COLUMN_IDENTIFIER);
		return sql.toString();
	}
	
	private String getSelectStatementByDocumentNumber() {
		StringBuilder sql = new StringBuilder(this.getSelectStatementWithoutWhere());
		sql.append(STATEMENT_WHERE);
		sql.append(COLUMN_DOCUMENT_NUMBER);
		sql.append(PARAMETER + COLUMN_DOCUMENT_NUMBER);
		return sql.toString();
	}

}