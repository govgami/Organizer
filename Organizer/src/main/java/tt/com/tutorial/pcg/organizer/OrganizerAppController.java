package tt.com.tutorial.pcg.organizer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@RestController
public class OrganizerAppController {

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

	// @GetMapping("/")
	// public String homePage(Model model) {
	// model.addAttribute("appName", "Organizer");
	// return "home";
	// }

	/*
	 * @GetMapping("/") public String homePage() {
	 * 
	 * return "home"; }
	 */

	@RequestMapping(value = "/html5Test")
	public ModelAndView html5Test() {

		return new ModelAndView("/html5/html5Test");
	}

	@RequestMapping(value = "/bootstrapTest")
	public ModelAndView bootstrapTest() {

		return new ModelAndView("/bootstrapTest");
	}

	@RequestMapping(value = "/bootstrapSpringGrid")
	public ModelAndView bootstrapSpringGrid() {

		return new ModelAndView("/bootstrapSpringGrid");
	}

	@GetMapping(value = "/greet{name}")
	public Response welcome(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		Date d = new Date();
		String loaded = "Hello, " + name + ". now is: " + d.toString();

		return Response.status(201).entity(loaded).build();
	}

	@Transactional
	@PostMapping(value = PATH_ADD, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizerIssue create(@RequestBody OrganizerIssue oi) {
		return organizerIssueService.createOrganizerIssue(oi);
	}

	@Transactional
	@PostMapping(value = PATH_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrganizerIssue update(@RequestBody OrganizerIssue oi) {
		return organizerIssueService.updateOrganizerIssue(oi);
	}

	@Transactional
	@GetMapping(value = PATH_RETRIEVE)
	public OrganizerIssue retrieveSingle(@RequestParam("id") Long id) {
		return organizerIssueService.getOrganizerIssue(id);

	}

	@Transactional
	@GetMapping(value = PATH_REMOVE)
	public Long removeSingle(@RequestParam("id") Long id) {
		return organizerIssueService.deleteOrganizerIssue(id);

	}

	@Transactional
	@GetMapping(value = PATH_REMOVE_GROUP)
	public Integer removeGroup(@RequestParam("id") List<Long> id) {
		return organizerIssueService.deleteOrganizerIssues(id);

	}

	// @RequestPath

	@Transactional
	@GetMapping(value = PATH_RETRIEVE_ALL)
	public List<OrganizerIssue> getAll() {
		return organizerIssueService.getOrganizerIssue();
	}

	// modelled

	@Transactional
	@PostMapping(value = PATH_ADD_M, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createModelled(HttpServletRequest req, HttpServletResponse resp) {

		String name = req.getParameter("name") == null ? "" : req.getParameter("name");
		String memo = req.getParameter("memo") == null ? "" : req.getParameter("memo");
		Integer priority = req.getParameter("priority") == null ? null : Integer.parseInt(req.getParameter("priority"));

		OrganizerIssue oi = new OrganizerIssue(name, memo, priority);
		organizerIssueService.createOrganizerIssue(oi);
		// set to boolean validated by non-null
		return "bootstrapSpringGrid";
	}

	// @Transactional
	// @PostMapping(value = PATH_UPDATE_M, consumes =
	// MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public OrganizerIssue updateModelled(HttpServletRequest req,
	// HttpServletResponse resp) {
	// return organizerIssueService.updateOrganizerIssue(oi);
	// }

	// @Transactional
	// @GetMapping(value = PATH_RETRIEVE_M)
	// public OrganizerIssue retrieveSingleModelled(HttpServletRequest req,
	// HttpServletResponse resp) {
	// return organizerIssueService.getOrganizerIssue(id);
	//
	// }

	// @Transactional
	// @GetMapping(value = PATH_REMOVE_M)
	// public Long removeSingleModelled(HttpServletRequest req, HttpServletResponse
	// resp) {
	// return organizerIssueService.deleteOrganizerIssue(id);
	//
	// }

	@Transactional
	@PostMapping(value = PATH_REMOVE_GROUP_M)
	public Integer removeGroupModelled(HttpServletRequest req, HttpServletResponse resp) {
		String checked = req.getParameter("checked") == null ? "" : req.getParameter("checked");

		List<Long> issues = new ArrayList<Long>();

		for (String s : checked.split(",")) {
			issues.add(new Long(s));
		}
		organizerIssueService.deleteOrganizerIssues(issues);
		return issues.size();

	}

	// @RequestPath

	@Transactional
	@PostMapping(value = PATH_RETRIEVE_ALL_M)
	public List<OrganizerIssue> getAllModelled(HttpServletRequest req, HttpServletResponse resp) {
		return organizerIssueService.getOrganizerIssue();
	}

}
