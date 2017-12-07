package tt.com.tutorial.pcg.organizer.db.issue.impl.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueDao;


@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class OrganizerIssueDaoJPA2 implements OrganizerIssueDao{
	
	static final String SELECT_BY_ID="select oi from OrganizerIssue where oi.issueId=?1";
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public OrganizerIssue getOrganizerIssueById(Long id) {
		try {
			TypedQuery<OrganizerIssue> query = em.createQuery(SELECT_BY_ID, OrganizerIssue.class);
			query.setParameter(1, id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
@Transactional
	public Long createOrganizerIssue(OrganizerIssue oi) {
		em.getTransaction().begin();
		em.persist(oi);
		em.flush();
		em.getTransaction().commit();
		return oi.getIssueID();
	}
@Transactional
	public int updateOrganizerIssue(OrganizerIssue oi) {
		em.merge(oi);

    	return 1;
	}
@Transactional
	public Long deleteOrganizerIssueById(Long id) {
		OrganizerIssue podcast = em.find(OrganizerIssue.class, id);
    	em.remove(podcast);
    	return id;
	}
@Transactional
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

}
