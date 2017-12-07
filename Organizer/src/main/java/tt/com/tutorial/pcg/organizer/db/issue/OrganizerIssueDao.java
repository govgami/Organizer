package tt.com.tutorial.pcg.organizer.db.issue;

import org.springframework.transaction.annotation.Transactional;

public interface OrganizerIssueDao {

public OrganizerIssue getOrganizerIssueById(Long id);

public Long createOrganizerIssue(OrganizerIssue oi);

public int updateOrganizerIssue(OrganizerIssue oi);

public Long deleteOrganizerIssueById(Long id);

public void removeAll();
}
