package com.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class KwiatyController {
    @Autowired
    private KwiatyRepository kwiatyRepository;

    @RequestMapping("/formularz")
    public String form() {
        return "formularz";
    }

    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("nazwa") String nazwa,
            @RequestParam("kolor") String kolor,
            @RequestParam("ilosc") int ilosc,
            @RequestParam("rodzaj") String rodzaj,
            Model model)
        throws Exception{
        Kwiaty kwiaty = new Kwiaty(nazwa, kolor, ilosc, rodzaj);
        System.out.println(kwiaty);
        kwiatyRepository.save(kwiaty);
        model.addAttribute("kwiaty", kwiaty);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz(Model model) {
        model.addAttribute("kwiaty", kwiatyRepository.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Long id, Model model) {
        kwiatyRepository.deleteById(id);
        model.addAttribute("kwiaty", kwiatyRepository.findAll());
        return "pokaz";
    }

    @RequestMapping("/aktualizacja")
    public String update(
            @RequestParam("nazwa") String nazwa,
            @RequestParam("kolor") String kolor,
            @RequestParam("ilosc") int ilosc,
            @RequestParam("rodzaj") String rodzaj,
            Model model) throws Exception {
        Kwiaty kwiaty = new Kwiaty(nazwa, kolor, ilosc, rodzaj);
        //kwiaty.setId(id);
        //System.out.println(kwiaty);
        kwiatyRepository.save(kwiaty);
        model.addAttribute("kwiaty", kwiaty);
        return "pokaz";
    }


    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("nazwa") String nazwa, Model model) {
        model.addAttribute("kwiaty", kwiatyRepository.findByNazwa(nazwa));
        return "pokaz";
    }
    @RequestMapping("/przekieruj")
    public String przekieruj(@RequestParam("id") long id, Model model) {
        System.out.println(kwiatyRepository.findById(id));
        model.addAttribute("kwiaty", kwiatyRepository.findById(id).get());
        return "przekieruj";
    }
}