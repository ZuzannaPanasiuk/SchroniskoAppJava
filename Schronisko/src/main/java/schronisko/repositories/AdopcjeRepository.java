package schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import schronisko.models.Adopcje;

@Repository
public interface AdopcjeRepository extends JpaRepository<Adopcje, Long> {
	
}
