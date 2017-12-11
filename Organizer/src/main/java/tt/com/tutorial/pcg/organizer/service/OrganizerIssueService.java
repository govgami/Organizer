package tt.com.tutorial.pcg.organizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueRepository;

@Service
public class OrganizerIssueService {

	@Autowired
	private OrganizerIssueRepository organizerIssueDao;

	public OrganizerIssue createOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueDao.save(oi);
		return saved;
	}

	public OrganizerIssue updateOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueDao.save(oi);
		return saved;
	}

	public OrganizerIssue getOrganizerIssue(Long id) {
		return organizerIssueDao.findOne(id);

	}

	public List<OrganizerIssue> getOrganizerIssue() {
		return organizerIssueDao.findAll();
	}

	public Long deleteOrganizerIssue(Long id) {
		organizerIssueDao.delete(id);
		return id;
	}

	public Integer deleteOrganizerIssues(List<Long> group) {
		List<OrganizerIssue> issues = organizerIssueDao.findAll(group);
		organizerIssueDao.deleteInBatch(issues);
		return group.size();
	}

}
