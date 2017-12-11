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
	OrganizerIssueRepository repo;
	// AnnotationConfigApplicationContext context =
	// new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void shouldWireManagerTest() {
		// when
		// = context.getBean(OrganizerIssueService.class);

		// then
		Assert.assertNotNull(repo);
	}

	@Test
	public void shouldCreateSimpleObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);

		// when
		OrganizerIssue saved = repo.save(issue);

		// then
		Assert.assertNotNull(/* dao.createOrganizerIssue(issue) */saved.getIssueID());
	}

	@Test
	public void shouldUpdateSimpleObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 12);

		// when
		issue = repo.save(issue);
		issue.setIssuePriority(14);
		OrganizerIssue issue2 = repo.save(issue);
		// resp = service.updateOrganizerIssue(issue);

		// then
		Assert.assertEquals(14, issue2.getIssuePriority().intValue());
	}

	@Test
	public void shouldGetSimpleObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 10);
		issue = repo.save(issue);

		// when
		OrganizerIssue issue2 = repo.getOne(issue.getIssueID());

		// then
		Assert.assertNotNull(issue2);
	}

	@Test
	public void shouldRemoveSimpleObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 10);
		issue = repo.save(issue);

		// when
		OrganizerIssue issue2 = repo.getOne(issue.getIssueID());

		// then
		Assert.assertNotNull(issue2);
	}

}
