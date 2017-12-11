package tt.com.tutorial.pcg.organizer;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@RestController
class AppController {

	@Autowired
	OrganizerIssueService organizerIssueService;

	@RequestMapping(value = "/greet{name}", method = RequestMethod.GET)
	public Response welcome(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		Date d = new Date();
		String loaded = "Hello, " + name + ". now is: " + d.toString();

		return Response.status(201).entity(loaded).build();
	}

	@Transactional
	@RequestMapping(value = "/plan/c", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizerIssue create(@RequestBody OrganizerIssue oi) {
		return organizerIssueService.createOrganizerIssue(oi);
	}

	@Transactional
	@RequestMapping(value = "/plan/u", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizerIssue update(@RequestBody OrganizerIssue oi) {
		return organizerIssueService.updateOrganizerIssue(oi);
	}

	@Transactional
	@RequestMapping(value = "/get{id}", method = RequestMethod.GET)
	public OrganizerIssue getSingle(@RequestParam("id") Long id) {
		return organizerIssueService.getOrganizerIssue(id);

	}
	// @RequestPath

	@Transactional
	@RequestMapping(value = "/usages", method = RequestMethod.GET)
	public List<OrganizerIssue> getAll() {
		return organizerIssueService.getOrganizerIssue();
	}
}
