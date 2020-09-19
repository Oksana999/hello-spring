package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oksana
 */
@Controller
//@ResponseBody
//@RequestMapping(value = "hello")
public class HelloController {

   @GetMapping("goodbye")
   public String goodbye(){
      return "Goodbye, Spring!";
   }

   @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},
          value = "hello")
   public String helloWithQueryParam(@RequestParam String name, String language, Model model){
      String greeting = createMessage(name, language);
      model.addAttribute("greeting", greeting);
      return "hello";
   }

   public static String createMessage(@RequestParam String name, String language) {
      String gritting = null;
      if (language.equals("Russian")) {
         gritting = "Здравствуй, " + name + "!";
      }
      if (language.equals("English")) {
         gritting = "Hello, " + name + "!";
      }
      if (language.equals("French")) {

         gritting = "Bonjor, " + name + " !";
      }
      return gritting;
   }

   @GetMapping("hello/{name}")
   public String helloWithPathParam(@PathVariable String name, Model model) {
      String greeting = "Hello "+name+ "!";
      model.addAttribute("greeting", greeting);

      return "hello";
   }

   @GetMapping("hello-names")
   public String helloNames(Model model){
      List<String> names = new ArrayList<>();
      names.add("Java");
      names.add("LaunchCode");
      names.add("Java Script");
      model.addAttribute("names", names);
      return "hello-list";
   }

//   @GetMapping("hello")
//   public String hello(Model model){
//      String greeting = "Hello, Spring!";
//      model.addAttribute("greeting", greeting);
//      return "hello";
//   }

   @GetMapping("form")
   public String helloForm(){
      return "form";

   }

}


