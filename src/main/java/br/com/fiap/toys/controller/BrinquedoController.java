package br.com.fiap.toys.controller;

import br.com.fiap.toys.model.Brinquedo;
import br.com.fiap.toys.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("brinquedos", repository.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "form";
    }

    @PostMapping
    public String create(@Valid Brinquedo brinquedo, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        repository.save(brinquedo);
        return "redirect:/brinquedos";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<Brinquedo> brinquedo = repository.findById(id);
        if (brinquedo.isPresent()) {
            model.addAttribute("brinquedo", brinquedo.get());
            return "form";
        }
        return "redirect:/brinquedos";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Brinquedo updated, BindingResult result) {
        if (result.hasErrors()) {
            updated.setId(id);
            return "form";
        }
        repository.save(updated);
        return "redirect:/brinquedos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/brinquedos";
    }
}