package tt.com.tutorial.pcg.organizer;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseSetupTest {

	@Autowired
	OrganizerIssueService service;
	// AnnotationConfigApplicationContext context =
	// new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void shouldWireManagerTest() {
		// when
		// = context.getBean(OrganizerIssueService.class);

		// then
		Assert.assertNotNull(service);
	}

	@Test
	public void shouldCreateSimpleObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);
		// OrganizerIssueService service=context.getBean(OrganizerIssueService.class);
		// when
		Response resp = service.createOrganizerIssue(issue);

		// then
		Assert.assertNotNull(/* dao.createOrganizerIssue(issue) */issue.getIssueID());
		System.out.println(resp.getEntity().toString());
	}

	@Test
	public void shouldUpdateSimpleObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 12);
		// OrganizerIssueService service=context.getBean(OrganizerIssueService.class);
		// when
		Response resp = service.createOrganizerIssue(issue);
		issue.setIssuePriority(14);
		resp = service.updateOrganizerIssue(issue);

		// then
		// Assert.assertNotNull(/*dao.createOrganizerIssue(issue)*/issue.getIssueID());
		System.out.println(resp.getEntity().toString());
	}

}
