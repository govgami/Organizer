package tt.com.tutorial.pcg.organizer;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseSetupTest {

	AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
	//@PersistenceContext
	//EntityManager em;
	
	@Test
	public void shouldWireManagerTest() {
	      OrganizerIssueService service = context.getBean(OrganizerIssueService.class);

		//then
		Assert.assertNotNull(service);
	}
	
	@Test
	public void shouldCreateSimpleObjectTest() {
		//given
		//EntityManager em=Connection.getNewconnection();
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);
		//when
		
		OrganizerIssueService service=context.getBean(OrganizerIssueService.class);
		Response resp=service.createOrganizerIssue(issue);
//		em.getTransaction().begin();
//		em.persist(issue);
//		em.flush();
//		em.getTransaction().commit();

		//em.getMetamodel().entity(OrganizerIssue.class);
		
		//then
		//Assert.assertNotNull(dao!=null);
		Assert.assertNotNull(/*dao.createOrganizerIssue(issue)*/issue.getIssueID());
	}
	
	@Test
	public void shouldCreateSimpleObjectWebTest() {
		//given
		//EntityManager em=Connection.getNewconnection();
		//when
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);
		
		OrganizerIssueService service=new OrganizerIssueService();
		//em.persist(issue);
		//em.flush();

		//em.getMetamodel().entity(OrganizerIssue.class);
		
		//then
		//Assert.assertNotNull(dao!=null);
		Assert.assertNotNull(service.createOrganizerIssue(issue));
	}

}
