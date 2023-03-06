package schronisko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schronisko.models.Klienci;
import schronisko.repositories.KlienciRepository;

@Service
public class KlienciService {

	@Autowired
	private KlienciRepository repository;

	public KlienciService() {
		super();
	}
	
	
	public <S extends Klienci> S save(S entity) {
		return repository.save(entity);
	}

	public List<Klienci> findAll() {
		return repository.findAll();
	}

	public Optional<Klienci> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
