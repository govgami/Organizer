package tt.com.tutorial.pcg.organizer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.exceptionhandler.HandlerResponse;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@RestController
public class OrganizerIssueController {

	@Autowired
	OrganizerIssueService organizerIssueService;

	public static final String PATH_RETRIEVE_ALL = "/allUsages";
	public static final String PATH_ADD = "/plan/";
	public static final String PATH_UPDATE = "/edit/";
	public static final String PATH_REMOVE = "/remove{id}";
	public static final String PATH_REMOVE_GROUP = "/remove/";
	public static final String PATH_RETRIEVE = "/get{id}";
	public static final String PATH_RETRIEVE_ALL_M = "/allUsagesModel";
	public static final String PATH_ADD_M = "/planModel/";
	public static final String PATH_UPDATE_M = "/editModel/";
	public static final String PATH_REMOVE_M = "/removeModel{id}";
	public static final String PATH_REMOVE_GROUP_M = "/removeModel/";
	public static final String PATH_RETRIEVE_M = "/getModel{id}";

	@Transactional
	@PostMapping(value = PATH_ADD, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizerIssue create(@Valid @RequestBody OrganizerIssue oi) {
		return organizerIssueService.createOrganizerIssue(oi);
	}

	@Transactional
	@PostMapping(value = PATH_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizerIssue update(@Valid @RequestBody OrganizerIssue oi) {
		return organizerIssueService.updateOrganizerIssue(oi);
	}

	@Transactional
	@GetMapping(value = PATH_RETRIEVE)
	public OrganizerIssue retrieveSingle(@Valid @RequestParam("id") Long id) {
		return organizerIssueService.getOrganizerIssue(id);

	}

	@Transactional
	@GetMapping(value = PATH_REMOVE)
	public Long removeSingle(@Valid @RequestParam("id") Long id) {
		return organizerIssueService.deleteOrganizerIssue(id);

	}

	@Transactional
	@GetMapping(value = PATH_REMOVE_GROUP)
	public Integer removeGroup(@Valid @RequestParam("id") List<Long> id) {
		return organizerIssueService.deleteOrganizerIssues(id);

	}

	@Transactional
	@GetMapping(value = PATH_RETRIEVE_ALL)
	public List<OrganizerIssue> getAll() {
		return organizerIssueService.getOrganizerIssue();
	}

	// modelled

	@Transactional
	@PostMapping(value = PATH_ADD_M)
	public Boolean createModelled(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println(req.getAttributeNames());
		String name = req.getParameter("issueName").equals("") ? null : req.getParameter("issueName");
		String memo = req.getParameter("issueMemo") == null ? "" : req.getParameter("issueMemo");
		Integer priority = req.getParameter("issuePriority").equals("") ? null
				: Integer.parseInt(req.getParameter("issuePriority"));

		OrganizerIssue oi = new OrganizerIssue(name, memo, priority);
		organizerIssueService.createOrganizerIssue(oi);
		return oi != null;
	}

	@Transactional
	@PostMapping(value = PATH_REMOVE_GROUP_M)
	public Boolean removeGroupModelled(HttpServletRequest req, HttpServletResponse resp) {
		String checked = req.getParameter("checked") == null ? "" : req.getParameter("checked");

		List<Long> issues = new ArrayList<Long>();

		for (String s : checked.split(",")) {
			issues.add(new Long(s));
		}
		organizerIssueService.deleteOrganizerIssues(issues);
		return new Integer(issues.size()) != null;

	}

	@Transactional
	@PostMapping(value = PATH_RETRIEVE_ALL_M)
	public List<OrganizerIssue> allUsagesModel(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("called: " + PATH_RETRIEVE_ALL_M);
		return organizerIssueService.getOrganizerIssue();
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE/* , reason = "wrong value" */)
	public HandlerResponse actOnException(DataIntegrityViolationException ve) {
		return new HandlerResponse("violated integrity", ve.getRootCause().getMessage());
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE/* , reason = "omitted compulsory row" */)
	public HandlerResponse actOnException(HttpMessageNotReadableException ve) {
		return new HandlerResponse("violated readability", ve.getRootCause().getMessage());
	}

	@ExceptionHandler({ NumberFormatException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE/* , reason = "omitted compulsory row" */)
	public HandlerResponse actOnException(NumberFormatException ve) {
		return new HandlerResponse("violated number format", ve.getMessage());
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE/* , reason = "wrong value" */)
	public HandlerResponse actOnException(ConstraintViolationException ve) {
		return new HandlerResponse("violated constraint", ve.getMessage());
	}

}
