package tt.com.organizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tt.com.tutorial.pcg.organizer.db.issue.OrganizerIssue;
import tt.com.tutorial.pcg.organizer.exceptionhandler.HandlerResponse;
import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@EnableWebMvc
@Controller
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

	@GetMapping(value = "/start", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView start() {

		return new ModelAndView("index");
	}

	@GetMapping(value = "/t", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView time() {

		return new ModelAndView("time");
	}

	@GetMapping(value = "/bootstrapTest", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView bootstrapTest() {

		return new ModelAndView("bootstrapTest");
	}

	@GetMapping(value = "/bootstrapSpringGrid", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView bootstrapSpringGrid() {

		return new ModelAndView("bootstrapSpringGrid");
	}

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView welcome(Map<String, Object> model) {
		model.put("message", "hello");
		return new ModelAndView("hello");
	}

	@GetMapping("/next")
	public String next(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "next";
	}

	// @GetMapping(value = "/greet{name}")
	// public @ResponseBody Response welcome(
	// @RequestParam(value = "name", required = false, defaultValue = "Stranger")
	// String name) {
	// Date d = new Date();
	// String loaded = "Hello, " + name + ". now is: " + d.toString();
	//
	// return Response.status(201).entity(loaded).build();
	// }

	@Transactional
	@PostMapping(value = PATH_ADD, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrganizerIssue create(@Valid @RequestBody OrganizerIssue oi) {
		return organizerIssueService.createOrganizerIssue(oi);
	}

	@Transactional
	@PostMapping(value = PATH_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrganizerIssue update(@Valid @RequestBody OrganizerIssue oi) {
		return organizerIssueService.updateOrganizerIssue(oi);
	}

	@Transactional
	@GetMapping(value = PATH_RETRIEVE)
	public @ResponseBody OrganizerIssue retrieveSingle(@Valid @RequestParam("id") Long id) {
		return organizerIssueService.getOrganizerIssue(id);

	}

	@Transactional
	@GetMapping(value = PATH_REMOVE)
	public @ResponseBody Long removeSingle(@Valid @RequestParam("id") Long id) {
		return organizerIssueService.deleteOrganizerIssue(id);

	}

	@Transactional
	@GetMapping(value = PATH_REMOVE_GROUP)
	public @ResponseBody Integer removeGroup(@Valid @RequestParam("id") List<Long> id) {
		return organizerIssueService.deleteOrganizerIssues(id);

	}

	// @RequestPath

	@Transactional
	@GetMapping(value = PATH_RETRIEVE_ALL)
	public @ResponseBody List<OrganizerIssue> getAll() {
		return organizerIssueService.getOrganizerIssue();
	}

	// modelled

	@Transactional
	@PostMapping(value = PATH_ADD_M, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean createModelled(HttpServletRequest req, HttpServletResponse resp) {

		String name = req.getParameter("name") == null ? "" : req.getParameter("name");
		String memo = req.getParameter("memo") == null ? "" : req.getParameter("memo");
		Integer priority = req.getParameter("priority") == null ? null : Integer.parseInt(req.getParameter("priority"));

		OrganizerIssue oi = new OrganizerIssue(name, memo, priority);
		organizerIssueService.createOrganizerIssue(oi);
		// set to boolean validated by non-null
		return null != oi;
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
	public @ResponseBody boolean removeGroupModelled(HttpServletRequest req, HttpServletResponse resp) {
		String checked = req.getParameter("checked") == null ? "" : req.getParameter("checked");

		List<Long> issues = new ArrayList<Long>();

		for (String s : checked.split(",")) {
			issues.add(new Long(s));
		}
		organizerIssueService.deleteOrganizerIssues(issues);
		return null != new Integer(issues.size());

	}

	// @RequestPath

	@Transactional
	@PostMapping(value = PATH_RETRIEVE_ALL_M)
	public @ResponseBody List<OrganizerIssue> getAllModelled(HttpServletRequest req, HttpServletResponse resp) {
		return organizerIssueService.getOrganizerIssue();
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE/* , reason = "wrong value" */)
	public @ResponseBody HandlerResponse actOnException(DataIntegrityViolationException ve) {
		return new HandlerResponse("violated", ve.getRootCause().getMessage());
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE/* , reason = "omitted compulsory row" */)
	public @ResponseBody HandlerResponse actOnException(HttpMessageNotReadableException ve) {
		return new HandlerResponse("violated", ve.getRootCause().getMessage());
	}
}
