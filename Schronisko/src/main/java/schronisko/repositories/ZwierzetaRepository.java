package schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import schronisko.models.Zwierzeta;

@Repository

public interface ZwierzetaRepository extends JpaRepository<Zwierzeta, Long> {
	
}
