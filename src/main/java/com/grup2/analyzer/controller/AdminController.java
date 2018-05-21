package com.grup2.analyzer.controller;

import com.grup2.analyzer.model.Page;
import com.grup2.analyzer.model.PageLog;
import com.grup2.analyzer.service.PageLogService;
import com.grup2.analyzer.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {

    @Autowired
    private PageService service;

    @Autowired
    private PageLogService logService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminHome(ModelMap model) {

        List<Page> pages = service.loadPages();
        model.addAttribute("pages", pages);

        return "allPages";
    }

    @RequestMapping(value = "/page/{pageId}", method = RequestMethod.GET)
    public String pageDetail(@PathVariable("pageId") int pageId,
                             @RequestParam(required = false, defaultValue = "newest") String sort,
                             ModelMap model) {

        Page page = service.loadPageById(pageId);
        List<PageLog> pageLogs = logService.loadPageLogId(pageId, sort);

        model.addAttribute("page", page);
        model.addAttribute("pageLogs", pageLogs);

        return "pageDetail";
    }
}
