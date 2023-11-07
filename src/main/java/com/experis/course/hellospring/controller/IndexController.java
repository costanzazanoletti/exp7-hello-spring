package com.experis.course.hellospring.controller;

import java.time.LocalDate;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping
  @ResponseBody
  public String index() {
    return "<html><body><h1>Ciao</h1><h2>studenti</h2></body></html>";
  }

  /* questo metodo risponde a /home
  e l'html viene generato a partire dal template resources/templates/home-page.html
   */
  @GetMapping("home")
  public String home(Model model) {
    LocalDate today = LocalDate.now();
    Random random = new Random();
    model.addAttribute("currentDate", today);
    model.addAttribute("randomNumber", random.nextInt());
    return "home-page";
  }

  @GetMapping("homepage")
  public String redirectHome() {
    return "redirect:/home";
  }

}
