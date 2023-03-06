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

import schronisko.models.Tymczas;
import schronisko.models.Wolontariusze;
import schronisko.models.Zwierzeta;
import schronisko.services.TymczasService;
import schronisko.services.WolontariuszeService;
import schronisko.services.ZwierzetaService;

@Controller 
public class TymczasController {
	
	@Autowired
	private WolontariuszeService serviceWolontariusze;
	@Autowired
	private ZwierzetaService serviceZwierzeta;
	
	@Autowired
	private TymczasService serviceTymczas;
	
	//Funkcje dotyczące tymczasów
			@RequestMapping("lista_tymczasow")
			public String list_tymczasow(Model model) {
				List<Tymczas> listTymczas=serviceTymczas.findAll();
				model.addAttribute("listTymczas", listTymczas);
				return "lista_tymczasow";
				}
			
			@GetMapping("/dodawanie_tymczasow")
			public String dodawanie_tymczasow(Model model) {
				Tymczas nowyTymczas = new Tymczas();
				model.addAttribute("nowyTymczas", nowyTymczas);
				List<Wolontariusze> lw = serviceWolontariusze.findAll();
				model.addAttribute("lw", lw);
				
				List<Zwierzeta> lz = serviceZwierzeta.findAll();
				model.addAttribute("lz", lz);
				return "dodawanie_tymczasow";
			}
			
			@GetMapping("/edycja_tymczasow/{idt}")
			public ModelAndView edycja_tymczasow(@PathVariable(name = "idt") Long id, Model model) {
				ModelAndView mav = new ModelAndView("/edycja_tymczasow");
				List<Wolontariusze> lw = serviceWolontariusze.findAll();
				model.addAttribute("lw", lw);
				
				List<Zwierzeta> lz = serviceZwierzeta.findAll();
				model.addAttribute("lz", lz);
				Optional<Tymczas> tymczas = serviceTymczas.findById(id);
				mav.addObject("tymczas", tymczas);
				return mav;
			}
			
			@PostMapping(value="/tymczas_zapis")
			public String zapis_tymczasow(@ModelAttribute("tymczas") Tymczas tymczas) {
				 serviceTymczas.save(tymczas);
				 return "redirect:/lista_tymczasow";
			}
			
			@RequestMapping("/tymczas_usuwanie/{id}")
			public String usuwanie_tymczasow(@PathVariable(name = "id") Long id) {
				serviceTymczas.deleteById(id);
			 	return "redirect:/lista_tymczasow";
			}
			//Koniec funkcji dotyczących tymczasów

}
