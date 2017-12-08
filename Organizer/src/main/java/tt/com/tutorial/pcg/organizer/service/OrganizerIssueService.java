package tt.com.tutorial.pcg.organizer.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueRepository;

@Service
public class OrganizerIssueService {

	@Autowired
	private OrganizerIssueRepository organizerIssueDao;

	@Transactional
	@RequestMapping(value = "/plan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public Response createOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueDao.save(oi);

		return Response.status(201).entity("A new resource has been created: " + saved.toString()).build();
	}

	@Transactional
	@RequestMapping(value = "/plan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public Response updateOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueDao.save(oi);

		return Response.status(201).entity("A resource has been updated: " + saved.toString()).build();
	}

	@Transactional
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Response getOrganizerIssue(@PathVariable("id") Long id) {
		OrganizerIssue loaded = organizerIssueDao.findOne(id);

		return Response.status(201).entity("A resource has been read: " + loaded.toString()).build();
	}

	@Transactional
	@RequestMapping(value = "/usages", method = RequestMethod.GET)
	public Response getOrganizerIssue() {
		List<OrganizerIssue> loaded = organizerIssueDao.findAll();

		return Response.status(201).entity("A resources have been read: " + loaded.toString()).build();
	}

	// @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	// public Response welcome(@RequestParam(value = "name", required = false,
	// defaultValue = "Stranger") String name) {
	// Date d = new Date();
	// String loaded = "Hello, now is: " + d.toString();
	//
	// return Response.status(201).entity(loaded).build();
	// }

}
