package tt.com.tutorial.pcg.organizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
		// AnnotationConfigApplicationContext context =
		// new AnnotationConfigApplicationContext(AppConfig.class);
		//
		// OrganizerIssueService personService =
		// context.getBean(OrganizerIssueService.class);
		//
		// // Add Persons
		// personService.createOrganizerIssue(new OrganizerIssue("Sunil", "Bora", 5));
	}
}
