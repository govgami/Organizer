package tt.com.tutorial.pcg.organizer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueDao;
import tt.com.tutorial.pcg.organizer.db.issue.impl.dao.OrganizerIssueDaoJPA2;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseSetupTest {
//create table organizer_issue (id int not null primary key, name varchar(50) not null, descript varchar(500), priority int not null);

	//@PersistenceContext
	//EntityManager em;
	
	@Test
	public void shouldWireManagerTest() {

		//then
//		Assert.assertNotNull(em);
	}
	
	@Test
	public void shouldCreateSimpleObjectTest() {
		//given
		//EntityManager em=Connection.getNewconnection();
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);
		//when
		
		OrganizerIssueDao dao=new OrganizerIssueDaoJPA2();
		Long id=dao.createOrganizerIssue(issue);
//		em.getTransaction().begin();
//		em.persist(issue);
//		em.flush();
//		em.getTransaction().commit();

		//em.getMetamodel().entity(OrganizerIssue.class);
		
		//then
		//Assert.assertNotNull(dao!=null);
		Assert.assertNotNull(/*dao.createOrganizerIssue(issue)*//*issue.getIssueID()*/id);
	}
	
	@Test
	public void shouldCreateSimpleObjectWebTest() {
		//given
		//EntityManager em=Connection.getNewconnection();
		//when
		OrganizerIssue issue = new OrganizerIssue("de", "pi", 2);
		
		OrganizerIssueService service=new OrganizerIssueService(new OrganizerIssueDaoJPA2());
		//em.persist(issue);
		//em.flush();

		//em.getMetamodel().entity(OrganizerIssue.class);
		
		//then
		//Assert.assertNotNull(dao!=null);
		Assert.assertNotNull(service.createOrganizerIssue(issue));
	}

}
