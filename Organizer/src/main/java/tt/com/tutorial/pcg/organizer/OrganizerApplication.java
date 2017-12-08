package tt.com.tutorial.pcg.organizer;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class OrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);

	}

	@Controller
	class AppController {

		@RequestMapping(value = "/{name}", method = RequestMethod.GET)
		public @ResponseBody Response welcome(
				@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
			Date d = new Date();
			String loaded = "Hello, " + name + ". now is: " + d.toString();

			return Response.status(201).entity(loaded).build();
		}

	}
}
