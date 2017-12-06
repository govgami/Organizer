package tt.com.tutorial.pcg.organizer;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.db.Connection;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseSetupTest {
//create table organizer_issue (id int not null primary key, name varchar(50) not null, descript varchar(500), priority int not null);

	@Test
	public void shouldCreateConnectionTest() {
		//when
		
		EntityManager em=Connection.getNewconnection();
//		em.getMetamodel().entity(OrganizerIssue.class);
		
		//then
		Assert.assertNotNull(em);
	}

}
