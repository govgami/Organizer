package tt.com.tutorial.pcg.organizer.db.issue.impl.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueDao;

public class OrganizerIssueDaoJPA2 implements OrganizerIssueDao{
	
	static final String SELECT_BY_ID="select oi from OrganizerIssue where oi.issueId=?1";
	
	@PersistenceContext
	private EntityManager em;

	public OrganizerIssue getOrganizerIssueById(Long id) {
		try {
			TypedQuery<OrganizerIssue> query = em.createQuery(SELECT_BY_ID, OrganizerIssue.class);
			query.setParameter(1, id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Long createOrganizerIssue(OrganizerIssue oi) {
		em.persist(oi);
		em.flush();
		return oi.getIssueID();
	}

	public int updateOrganizerIssue(OrganizerIssue oi) {
		em.merge(oi);

    	return 1;
	}

	public Long deleteOrganizerIssueById(Long id) {
		OrganizerIssue podcast = em.find(OrganizerIssue.class, id);
    	em.remove(podcast);
    	return id;
	}

	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

}
