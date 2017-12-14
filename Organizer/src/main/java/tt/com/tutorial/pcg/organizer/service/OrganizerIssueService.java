package tt.com.tutorial.pcg.organizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueRepository;

@Service
public class OrganizerIssueService {

	@Autowired
	private OrganizerIssueRepository organizerIssueRepo;

	public OrganizerIssue createOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueRepo.save(oi);
		return saved;
	}

	public OrganizerIssue updateOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueRepo.save(oi);
		return saved;
	}

	public OrganizerIssue getOrganizerIssue(Long id) {
		return organizerIssueRepo.findOne(id);

	}

	public List<OrganizerIssue> getOrganizerIssue() {
		return organizerIssueRepo.findAll();
	}

	public Long deleteOrganizerIssue(Long id) {
		organizerIssueRepo.delete(id);
		return id;
	}

	public Integer deleteOrganizerIssues(List<Long> group) {
		List<OrganizerIssue> issues = organizerIssueRepo.findAll(group);
		organizerIssueRepo.deleteInBatch(issues);
		return group.size();
	}

}
