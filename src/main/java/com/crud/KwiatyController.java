package com.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KwiatyController {
    @Autowired
    private KwiatyRepository kwiatyRepository;

    @RequestMapping("/formularz")
    public String form() {
        return "formularz";
    }

    @PostMapping("/dodaj")
    public String dodajKwiaty(
            @RequestParam("nazwa") String nazwa,
            @RequestParam("kolor") String kolor,
            @RequestParam("ilosc") int ilosc,
            @RequestParam("rodzaj") String rodzaj,
            Model model) {
        Kwiaty kwiaty = new Kwiaty(nazwa, kolor, ilosc, rodzaj);
        System.out.println(kwiaty);
        kwiatyRepository.save(kwiaty);
        model.addAttribute("kwiaty", kwiaty);
        return "Widok";
    }
}
