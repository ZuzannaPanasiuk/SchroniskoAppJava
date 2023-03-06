package schronisko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schronisko.models.Wolontariusze;
import schronisko.repositories.WolontariuszeRepository;

@Service
public class WolontariuszeService {

	@Autowired
	private WolontariuszeRepository repository;

	public WolontariuszeService() {
		super();
	}
	
	
	public <S extends Wolontariusze> S save(S entity) {
		return repository.save(entity);
	}

	public List<Wolontariusze> findAll() {
		return repository.findAll();
	}

	public Optional<Wolontariusze> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
