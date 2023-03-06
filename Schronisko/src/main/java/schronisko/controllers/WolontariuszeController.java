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
import schronisko.models.Tymczas;
import schronisko.models.Wolontariusze;
import schronisko.services.TymczasService;
import schronisko.services.WolontariuszeService;

@Controller 
public class WolontariuszeController {
	
	@Autowired
	private WolontariuszeService serviceWolontariusze;
	@Autowired
	private TymczasService serviceTymczas;

	//Funkcje dotyczące wolontariuszy
			@RequestMapping("lista_wolontariuszy")
			public String list_wolontariuszy(Model model) {
				List<Wolontariusze> listWolontariusze=serviceWolontariusze.findAll();
				model.addAttribute("listWolontariusze", listWolontariusze);
				return "lista_wolontariuszy";
				}
			
			@GetMapping("/dodawanie_wolontariuszy")
			public String dodawanie_wolontariuszy(Model model) {
				Wolontariusze nowyWolontariusze = new Wolontariusze();
				model.addAttribute("nowyWolontariusze", nowyWolontariusze);
				return "dodawanie_wolontariuszy";
			}
			
			@GetMapping("/edycja_wolontariuszy/{idw}")
			public ModelAndView edycja_wolontariuszy(@PathVariable(name = "idw") Long id) {
				ModelAndView mav = new ModelAndView("/edycja_wolontariuszy");
				Optional<Wolontariusze> wolontariusz = serviceWolontariusze.findById(id);
				mav.addObject("wolontariusz", wolontariusz);
				return mav;
			}
			
			@PostMapping(value="/wolontariusze_zapis")
			public String zapis_wolontariuszy(@ModelAttribute("wolontariusze") Wolontariusze wolontariusze) {
				 serviceWolontariusze.save(wolontariusze);
				 return "redirect:/lista_wolontariuszy";
			}
			
			@RequestMapping("/wolontariusze_usuwanie/{id}")
			public String usuwanie_wolontariuszy(@PathVariable(name = "id") Long id) {
				List <Tymczas> listaTymczas = serviceTymczas.findAll();
				Optional<Wolontariusze> wolontariusz = serviceWolontariusze.findById(id);
				
				for(Tymczas tymczas:listaTymczas)
				{
					if(tymczas.getWolontariusz() == wolontariusz.get())
					{
						serviceTymczas.deleteById(tymczas.getIdt());
					}
				}
				
				
				serviceWolontariusze.deleteById(id);
			 	return "redirect:/lista_wolontariuszy";
			}
			//Koniec funkcji dotyczących wolontariuszy
}
