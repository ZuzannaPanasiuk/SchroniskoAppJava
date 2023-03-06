package schronisko.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import schronisko.models.Zwierzeta;
import schronisko.repositories.ZwierzetaRepository;

@Service
public class ZwierzetaService {

	@Autowired
	private ZwierzetaRepository repository;

	public ZwierzetaService() {
		super();
	}
	
	
	public <S extends Zwierzeta> S save(S entity) {
		return repository.save(entity);
	}

	public List<Zwierzeta> findAll() {
		return repository.findAll();
	}

	public Optional<Zwierzeta> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
