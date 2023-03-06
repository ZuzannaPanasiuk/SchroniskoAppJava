package schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import schronisko.models.Klienci;

@Repository
public interface KlienciRepository extends JpaRepository<Klienci, Long> {
	
}
