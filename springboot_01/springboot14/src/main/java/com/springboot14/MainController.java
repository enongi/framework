package com.springboot14;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String index(Model model) {
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("world", messageSource.getMessage("world", null, locale));
        return "index";
    }
}
