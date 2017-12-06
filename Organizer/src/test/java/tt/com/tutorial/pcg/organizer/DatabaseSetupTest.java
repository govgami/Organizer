package tt.com.tutorial.pcg.organizer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tt.com.tutorial.pcg.organizer.db.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseSetupTest {
//create table organizer_issue (id int not null primary key, name varchar(50) not null, descript varchar(500), priority int not null);

	@Test
	public void shouldCreateConnectionTest() {
		Connection.getNewconnection();
	}

}
