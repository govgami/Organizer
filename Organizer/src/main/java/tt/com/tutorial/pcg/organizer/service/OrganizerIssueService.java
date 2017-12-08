package tt.com.tutorial.pcg.organizer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueRepository;

@Service
public class OrganizerIssueService {

	@Autowired
	private OrganizerIssueRepository organizerIssueDao;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response createOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueDao.save(oi);

		return Response.status(201).entity("A new resource has been created: " + saved.toString()).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response updateOrganizerIssue(OrganizerIssue oi) {
		OrganizerIssue saved = organizerIssueDao.save(oi);

		return Response.status(201).entity("A resource has been updated: " + saved.toString()).build();
	}
}
