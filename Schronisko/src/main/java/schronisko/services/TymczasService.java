package schronisko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schronisko.models.Tymczas;
import schronisko.repositories.TymczasRepository;

@Service
public class TymczasService {

	@Autowired
	private TymczasRepository repository;

	public TymczasService() {
		super();
	}
	
	
	public <S extends Tymczas> S save(S entity) {
		return repository.save(entity);
	}

	public List<Tymczas> findAll() {
		return repository.findAll();
	}

	public Optional<Tymczas> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

