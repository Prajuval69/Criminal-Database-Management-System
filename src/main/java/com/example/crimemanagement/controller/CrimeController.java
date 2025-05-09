package com.example.crimemanagement.controller;

import com.example.crimemanagement.entity.Crime;
import com.example.crimemanagement.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crime")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    // ✅ Show all crime records on the home page
    @GetMapping
    public String listCrimes(Model model) {
        List<Crime> crimes = crimeService.getAllCrimes();
        model.addAttribute("crimes", crimes);
        return "index";  // ✅ Ensure "index.html" exists in resources/templates
    }

    // ✅ Show crime form for adding a new crime
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("crime", new Crime());  // Pass empty Crime object for form binding
        return "crime-form";  // ✅ Ensure "crime-form.html" exists in resources/templates
    }

    // ✅ Show crime form for editing an existing crime
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Crime crime = crimeService.getCrimeById(id);
        model.addAttribute("crime", crime);
        return "crime-form";  // ✅ Reuse the same form for editing
    }

    // ✅ Save crime record (both new and updated)
    @PostMapping("/save")
    public String saveCrime(@ModelAttribute Crime crime) {
        crimeService.saveCrime(crime);
        return "redirect:/crime";  // ✅ Redirect to home page after saving
    }

    // ✅ Delete a crime record
    @GetMapping("/delete/{id}")
    public String deleteCrime(@PathVariable Long id) {
        crimeService.deleteCrime(id);
        return "redirect:/crime";  // ✅ Redirect to home page after deletion
    }
    
}
