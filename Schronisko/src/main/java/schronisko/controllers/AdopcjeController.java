package schronisko.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import schronisko.models.Adopcje;
import schronisko.models.Klienci;
import schronisko.models.Zwierzeta;
import schronisko.services.AdopcjeService;
import schronisko.services.KlienciService;
import schronisko.services.ZwierzetaService;

@Controller 
public class AdopcjeController {
	
	@Autowired
	private KlienciService serviceKlienci;
	@Autowired
	private ZwierzetaService serviceZwierzeta;
	
	@Autowired
	private AdopcjeService serviceAdopcje;
	
	//Funkcje dotyczące adopcji
			@RequestMapping("lista_adopcji")
			public String list_adopcji(Model model) {
				List<Adopcje> listAdopcje=serviceAdopcje.findAll();
				model.addAttribute("listAdopcje", listAdopcje);
				return "lista_adopcji";
				}
			
			@GetMapping("/dodawanie_adopcji")
			public String dodawanie_adopcji(Model model) {
				Adopcje nowyAdopcje = new Adopcje();
				model.addAttribute("nowyAdopcje", nowyAdopcje);
				List<Klienci> lk = serviceKlienci.findAll();
				model.addAttribute("lk", lk);
				
				List<Zwierzeta> lz = serviceZwierzeta.findAll();
				model.addAttribute("lz", lz);
				return "dodawanie_adopcji";
			}
			
			@GetMapping("/edycja_adopcji/{ida}")
			public ModelAndView edycja_adopcji(@PathVariable(name = "ida") Long id, Model model) {
				ModelAndView mav = new ModelAndView("/edycja_adopcji");
				List<Klienci> lk = serviceKlienci.findAll();
				model.addAttribute("lk", lk);
				
				List<Zwierzeta> lz = serviceZwierzeta.findAll();
				model.addAttribute("lz", lz);
				Optional<Adopcje> adopcja = serviceAdopcje.findById(id);
				mav.addObject("adopcja", adopcja);
				return mav;
			}
			
			@PostMapping(value="/adopcje_zapis")
			public String zapis_adopcji(@ModelAttribute("adopcje") Adopcje adopcje) {
				 serviceAdopcje.save(adopcje);
				 return "redirect:/lista_adopcji";
			}
			
			@RequestMapping("/adopcje_usuwanie/{id}")
			public String usuwanie_adopcji(@PathVariable(name = "id") Long id) {
				serviceAdopcje.deleteById(id);
			 	return "redirect:/lista_adopcji";
			}
			//Koniec funkcji dotyczących adopcji

}
