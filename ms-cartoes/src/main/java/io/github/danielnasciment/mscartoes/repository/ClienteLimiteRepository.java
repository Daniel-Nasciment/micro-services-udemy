package io.github.danielnasciment.mscartoes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danielnasciment.mscartoes.domain.ClienteLimite;

public interface ClienteLimiteRepository extends JpaRepository<ClienteLimite, Long> {

	public Optional<ClienteLimite> findByCpf(String cpf);
	
}
