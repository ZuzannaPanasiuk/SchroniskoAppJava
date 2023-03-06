package schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import schronisko.models.Tymczas;

@Repository
public interface TymczasRepository extends JpaRepository<Tymczas, Long> {
	
}