package kz.bitlab.spring2.controller;

import kz.bitlab.spring2.model.Application;
import kz.bitlab.spring2.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ApplicationService applicationService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("applications", applicationService.getAllApplications());
        return "main-page";
    }

    @GetMapping(value = "add-page")
    public String addPage() {
        return "add-page";
    }

    @PostMapping(value = "addApplication")
    public String addApplicationPage(Application application) {
        applicationService.addApplication(application);
        return "redirect:/";
    }

    @GetMapping(value = "/details-page")
    public String detailstPage(Model model,
                               @RequestParam int id) {
        model.addAttribute("app", applicationService.getApplication(id));
        return "details-page";
    }

    @PostMapping(value = "/handle-application")
    public String handleApplication(Application application) {
        applicationService.updateApplication(application);
        return "redirect:/details-page?id=" + application.getId();
    }

    @GetMapping(value = "/delete-application")
    public String deleteApplication(@RequestParam int id) {
        applicationService.deleteApplication(id);
        return "redirect:/";
    }

    @GetMapping(value = "/handled-true")
    public String handledTrue(Model model) {
        model.addAttribute("list", applicationService.getApplicationsByHandled(true));
        return "handled-true";
    }

    @GetMapping(value = "/handled-false")
    public String handledFalse(Model model) {
        model.addAttribute("list", applicationService.getApplicationsByHandled(false));
        return "handled-true";
    }
}
