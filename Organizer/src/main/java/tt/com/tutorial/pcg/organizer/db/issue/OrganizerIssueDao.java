package tt.com.tutorial.pcg.organizer.db.issue;

import org.springframework.transaction.annotation.Transactional;

public interface OrganizerIssueDao {
	@Transactional
public OrganizerIssue getOrganizerIssueById(Long id);
	@Transactional
public Long createOrganizerIssue(OrganizerIssue oi);
	@Transactional
public int updateOrganizerIssue(OrganizerIssue oi);
	@Transactional
public Long deleteOrganizerIssueById(Long id);
	@Transactional
public void removeAll();
}
