package schronisko.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import schronisko.models.Adopcje;
import schronisko.models.Klienci;
import schronisko.models.Zwierzeta;
import schronisko.services.AdopcjeService;
import schronisko.services.KlienciService;

@Controller 
public class KlienciController {

	@Autowired
	private KlienciService serviceKlienci;
	@Autowired
	private AdopcjeService serviceAdopcje;
	
	//Funkcje dotyczące klientów
		@RequestMapping("lista_klientow")
		public String list_klientow(Model model) {
			List<Klienci> listKlienci=serviceKlienci.findAll();
			model.addAttribute("listKlienci", listKlienci);
			return "lista_klientow";
			}
		
		@GetMapping("/dodawanie_klientow")
		public String dodawanie_klientow(Model model) {
			Klienci nowyKlienci = new Klienci();
			model.addAttribute("nowyKlienci", nowyKlienci);
			return "dodawanie_klientow";
		}
		
		@GetMapping("/edycja_klientow/{idk}")
		public ModelAndView edycja_klientow(@PathVariable(name = "idk") Long id) {
			ModelAndView mav = new ModelAndView("/edycja_klientow");
			Optional<Klienci> klient = serviceKlienci.findById(id);
			mav.addObject("klient", klient);
			return mav;
		}
		
		@PostMapping(value="/klienci_zapis")
		public String zapis_klientow(@ModelAttribute("klient") @Valid Klienci klient, Errors error) {
			 if(error.hasErrors()) return "dodawanie_klientow";
			 serviceKlienci.save(klient);
			 return "redirect:/lista_klientow";
		}
		
		@RequestMapping("/klienci_usuwanie/{id}")
		public String usuwanie_klientow(@PathVariable(name = "id") Long id) {
			List <Adopcje> listaAdopcji = serviceAdopcje.findAll();
			Optional<Klienci> klient = serviceKlienci.findById(id);
			
			for(Adopcje adopcja:listaAdopcji)
			{
				if(adopcja.getKlient() == klient.get())
				{
					serviceAdopcje.deleteById(adopcja.getIda());
				}
			}
			
			serviceKlienci.deleteById(id);
		 	return "redirect:/lista_klientow";
		}
		//Koniec funkcji dotyczących klientów
}
