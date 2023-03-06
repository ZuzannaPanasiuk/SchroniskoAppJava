package schronisko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schronisko.models.Adopcje;
import schronisko.repositories.AdopcjeRepository;

@Service
public class AdopcjeService {

	@Autowired
	private AdopcjeRepository repository;

	public AdopcjeService() {
		super();
	}
	
	
	public <S extends Adopcje> S save(S entity) {
		return repository.save(entity);
	}

	public List<Adopcje> findAll() {
		return repository.findAll();
	}

	public Optional<Adopcje> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
