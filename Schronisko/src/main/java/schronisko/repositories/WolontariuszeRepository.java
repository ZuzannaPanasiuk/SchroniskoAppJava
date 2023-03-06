package schronisko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import schronisko.models.Wolontariusze;

@Repository
public interface WolontariuszeRepository extends JpaRepository<Wolontariusze, Long> {
	
}
