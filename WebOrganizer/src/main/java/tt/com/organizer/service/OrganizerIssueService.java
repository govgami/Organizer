package tt.com.organizer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tt.com.organizer.db.issue.OrganizerIssue;
import tt.com.organizer.db.issue.OrganizerIssueRepository;

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

	public Optional<OrganizerIssue> getOrganizerIssue(Long id) {
		return organizerIssueDao.findById(id);

	}

	public List<OrganizerIssue> getOrganizerIssue() {
		return organizerIssueDao.findAll();
	}

	public Long deleteOrganizerIssue(Long id) {
		organizerIssueDao.deleteById(id);
		return id;
	}

	public Integer deleteOrganizerIssues(List<Long> group) {
		List<OrganizerIssue> issues = organizerIssueDao.findAllById(group);
		organizerIssueDao.deleteInBatch(issues);
		return group.size();
	}

}
