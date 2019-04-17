package com.example.demo.controllers;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private final PersonService personService;

    @Autowired
    public IndexController(PersonService personService) {
        this.personService = personService;
    }
}
