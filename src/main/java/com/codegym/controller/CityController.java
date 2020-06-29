package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.repository.ICityRepository;
import com.codegym.service.city.ICityService;
import com.codegym.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;
import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @ModelAttribute("country")
    Iterable<Country> countries() {
        return countryService.findAll();
    }

//    @GetMapping("/list")
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("city/list");
//        Iterable<City> cities = cityService.findAll();
//        modelAndView.addObject("cities", cities);
//        return modelAndView;
//    }
    @GetMapping("/list")
    public ModelAndView ListCity(@RequestParam("s") Optional<String> s,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<City> cities;
        if (s.isPresent()) {
            cities = cityService.findAllByCityNameContaining(s.get(), pageable);
        } else {
            cities = cityService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("city/create");
        cityService.save(city);
        modelAndView.addObject("message", "save success");
        return modelAndView;
    }

    @GetMapping("/showId/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("city/detail");
        Optional<City> city = cityService.getById(id);
        if (city.isPresent()){
            City city1 = new City();
            city1 = city.get();
            modelAndView.addObject("city",city1);
        }
        return modelAndView;
    }
    @GetMapping("/showEdit/{id}")
    public ModelAndView showDetailEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("city/edit");
        Optional<City> city = cityService.getById(id);
        if (city.isPresent()){
            City city1 = new City();
            city1 = city.get();
            modelAndView.addObject("city",city1);
        }
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute City city){
        ModelAndView modelAndView = new ModelAndView("city/edit");
        if (city.getId() != null){
            cityService.save(city);
            modelAndView.addObject("message", "edit success");
        }else {
            modelAndView.addObject("message","edit no success");
        }

            return modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("city/list");
        cityService.remove(id);
        modelAndView.addObject("cities", cityService.findAll());
        return modelAndView;
    }
}
