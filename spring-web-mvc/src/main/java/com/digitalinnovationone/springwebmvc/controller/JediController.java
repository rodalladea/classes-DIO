package com.digitalinnovationone.springwebmvc.controller;

import com.digitalinnovationone.springwebmvc.model.Jedi;
import com.digitalinnovationone.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public ModelAndView getJedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", repository.findAll());

        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView getNewJedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        modelAndView.addObject("jedi", new Jedi());

        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "new-jedi";
        }

        repository.save(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");

        return "redirect:jedi";
    }
}
