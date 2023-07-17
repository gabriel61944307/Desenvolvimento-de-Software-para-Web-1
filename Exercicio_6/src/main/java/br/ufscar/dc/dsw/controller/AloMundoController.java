package br.ufscar.dc.dsw.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AloMundoController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/converte")
    public String conversor(@RequestParam("val_min") String minValue, @RequestParam("val_max") String maxValue, 
                                @RequestParam("val_inc") String incValue, Model model) {
        
        int min = -100, max = 100, inc = 5;
        try {
            min = Integer.parseInt(minValue);
        }catch(Exception ex){}
            
        try{
            max = Integer.parseInt(maxValue);
        }catch(Exception ex){}

        try {
            inc = Integer.parseInt(incValue);
        }catch(Exception ex){}

        if(inc <= 0) inc = 5;
        if(min > max) {
            int aux = min;
            min = max;
            max = aux;
        }

        Map<Integer, Double> respostas = new TreeMap<>();

        for (int celsius = min; celsius <= max; celsius += inc) {
            double fahr = 1.8 * celsius + 32;
            respostas.put(celsius, fahr);
        }

        model.addAttribute("respostas", respostas);

        return "conversao";
    }

}
