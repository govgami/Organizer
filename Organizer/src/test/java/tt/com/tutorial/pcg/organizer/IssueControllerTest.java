package tt.com.tutorial.pcg.organizer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.controller.OrganizerIssueController;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueControllerTest {

	@Autowired
	OrganizerIssueController orgController;

	@Test
	public void shouldCreateIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("d1e", "pi", 2);

		// when

		OrganizerIssue saved = orgController.create(issue);

		// then
		Assert.assertNotNull(saved.getIssueID());
	}

	@Test
	public void shouldUpdateIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de2", "pi", 12);

		// when
		issue = orgController.create(issue);
		issue.setIssuePriority(14);
		OrganizerIssue issue2 = orgController.update(issue);

		// then
		Assert.assertEquals(14, issue2.getIssuePriority().intValue());
	}

	@Test
	public void shouldGetIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de3", "pi", 10);
		issue = orgController.create(issue);

		// when
		OrganizerIssue issue2 = orgController.retrieveSingle(issue.getIssueID());

		// then
		Assert.assertNotNull(issue2);
	}

	@Test
	public void shouldRemoveIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de4", "pi", 10);
		long id = orgController.create(issue).getIssueID();

		// when
		orgController.removeSingle(id);
		OrganizerIssue issue2 = orgController.retrieveSingle(id);
		// then
		Assert.assertNull(issue2);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void shouldThrowExceptionCauseNotExistingPriorityAtIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue("de5", "pixe", null);

		// when

		orgController.create(issue);

	}

	@Test(expected = DataIntegrityViolationException.class)
	public void shouldThrowExceptionCauseNotExistingNameAtIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue(null, "pixe", 2);

		// when

		orgController.create(issue);

	}

	@Test(expected = DataIntegrityViolationException.class)
	public void shouldThrowExceptionCauseNotExistingFieldsAtIssueObjectTest() {
		// given
		OrganizerIssue issue = new OrganizerIssue(null, "pixe", null);

		// when

		orgController.create(issue);

	}
}
