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
import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssueDao;

@Service
public class OrganizerIssueService {

@Autowired
	private OrganizerIssueDao organizerIssueDao;
	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response createOrganizerIssue(OrganizerIssue oi) {
		organizerIssueDao.createOrganizerIssue(oi);

		return Response.status(201)
				.entity("A new resource has been created: "+oi.toString()).build();
}
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response updateOrganizerIssue(OrganizerIssue oi) {
		organizerIssueDao.updateOrganizerIssue(oi);

		return Response.status(201)
				.entity("A resource has been updated: "+oi.toString()).build();
}
}
