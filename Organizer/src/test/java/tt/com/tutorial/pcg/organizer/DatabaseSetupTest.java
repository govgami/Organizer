package tt.com.tutorial.pcg.organizer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseSetupTest {

	@Autowired
	OrganizerIssueRepository repository;

	@Test
	public void shouldWireManagerTest() {

		// then
		Assert.assertNotNull(repository);
	}

	@Test
	public void shouldCreateIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);

		// when
		OrganizerIssue saved = repository.save(issue);

		// then
		Assert.assertNotNull(saved.getIssueID());
	}

	@Test
	public void shouldUpdateIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 12);

		// when
		issue = repository.save(issue);
		issue.setIssuePriority(14);
		OrganizerIssue issue2 = repository.save(issue);

		// then
		Assert.assertEquals(14, issue2.getIssuePriority().intValue());
	}

	@Test
	public void shouldGetIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 10);
		issue = repository.save(issue);

		// when
		OrganizerIssue issue2 = repository.findOne(issue.getIssueID());

		// then
		Assert.assertNotNull(issue2);
	}

	@Test
	public void shouldRemoveIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 10);
		long id = repository.save(issue).getIssueID();

		// when
		repository.delete(id);
		OrganizerIssue issue2 = repository.findOne(id);
		// then
		Assert.assertNull(issue2);
	}

}
