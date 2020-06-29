package com.codegym.controller;

import com.codegym.model.Country;
import com.codegym.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private ICountryService countryService;
    @GetMapping("list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("country/list");
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("countries",countries);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("country/create");
        modelAndView.addObject("country",new Country());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCountry(@ModelAttribute Country country){
        ModelAndView modelAndView = new ModelAndView("country/create");

            countryService.save(country);
            modelAndView.addObject("message","create success");
        return modelAndView;
    }

}
