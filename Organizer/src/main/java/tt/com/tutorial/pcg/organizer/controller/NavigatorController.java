package tt.com.tutorial.pcg.organizer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tt.com.tutorial.pcg.organizer.service.OrganizerIssueService;

@Controller
public class NavigatorController {

	@Autowired
	OrganizerIssueService organizerIssueService;

	public static final String PATH_WELCOME = "/";
	public static final String PATH_ORGANIZER = "/organizer";
	public static final String PATH_TIME = "/t";
	public static final String PATH_NEXT = "/next";

	@GetMapping(value = "/start", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView start() {

		return new ModelAndView("index");
	}

	@GetMapping(value = PATH_TIME, produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView time() {

		return new ModelAndView("time");
	}

	@GetMapping(value = PATH_ORGANIZER, produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView organizer() {

		return new ModelAndView("organizer");
	}

	@GetMapping(value = PATH_WELCOME, produces = MediaType.TEXT_HTML_VALUE)
	public String welcome(Map<String, Object> model) {
		model.put("message", "hello");
		return "hello";
	}

	@GetMapping(PATH_NEXT)
	public String next(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "next";
	}
}
