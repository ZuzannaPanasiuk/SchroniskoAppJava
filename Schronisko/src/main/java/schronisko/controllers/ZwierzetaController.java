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
import schronisko.models.Tymczas;
import schronisko.models.Zwierzeta;
import schronisko.services.AdopcjeService;
import schronisko.services.TymczasService;
import schronisko.services.ZwierzetaService;

@Controller
public class ZwierzetaController {
	@Autowired
	private ZwierzetaService serviceZwierzeta;
	@Autowired
	private AdopcjeService serviceAdopcje;
	@Autowired
	private TymczasService serviceTymczas;
	
	//Funkcje dotyczące zwierząt
		@RequestMapping("lista_zwierzat")
		public String list_zwierzat(Model model) {
			List<Zwierzeta> listZwierzeta=serviceZwierzeta.findAll();
			model.addAttribute("listZwierzeta", listZwierzeta);
			return "lista_zwierzat";
			}
		
		@RequestMapping("lista_zwierzat_admin")
		public String list_zwierzat_admin(Model model) {
			List<Zwierzeta> listZwierzeta=serviceZwierzeta.findAll();
			model.addAttribute("listZwierzeta", listZwierzeta);
			return "lista_zwierzat_admin";
			}
		
		@GetMapping("/dodawanie_zwierzat")
		public String dodawanie_zwierzat(Model model) {
			Zwierzeta nowyZwierzeta = new Zwierzeta();
			model.addAttribute("nowyZwierzeta", nowyZwierzeta);
			return "dodawanie_zwierzat";
		}
		
		@GetMapping("/edycja_zwierzat/{idz}")
		public ModelAndView edycja_zwierzat(@PathVariable(name = "idz") Long id) {
			ModelAndView mav = new ModelAndView("/edycja_zwierzat");
			Optional<Zwierzeta> zwierze = serviceZwierzeta.findById(id);
			mav.addObject("zwierze", zwierze);
			return mav;
		}
		
		@PostMapping(value="/zwierzeta_zapis")
		public String zapis_zwierzat(@ModelAttribute("zwierze") Zwierzeta zwierze) {
			 serviceZwierzeta.save(zwierze);
			 return "redirect:/lista_zwierzat";
		}
		
		@RequestMapping("/zwierzeta_usuwanie/{id}")
		public String usuwanie_zwierzat(@PathVariable(name = "id") Long id) {
			List <Adopcje> listaAdopcji = serviceAdopcje.findAll();
			List <Tymczas> listaTymczas = serviceTymczas.findAll();
			Optional<Zwierzeta> zwierze = serviceZwierzeta.findById(id);
			
			for(Adopcje adopcja:listaAdopcji)
			{
				if(adopcja.getZwierze() == zwierze.get())
				{
					serviceAdopcje.deleteById(adopcja.getIda());
				}
			}
			
			for(Tymczas tymczas:listaTymczas)
			{
				if(tymczas.getZwierze() == zwierze.get())
				{
					serviceTymczas.deleteById(tymczas.getIdt());
				}
			}
			
			serviceZwierzeta.deleteById(id);
		 	return "redirect:/lista_zwierzat";
		}
		//Koniec funkcji dotyczących zwierząt
		
}
