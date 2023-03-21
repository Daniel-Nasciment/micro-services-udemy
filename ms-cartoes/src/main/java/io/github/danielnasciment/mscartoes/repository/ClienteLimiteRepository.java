package io.github.danielnasciment.mscartoes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.danielnasciment.mscartoes.domain.LimiteCartaoCliente;

@Repository
public interface ClienteLimiteRepository extends JpaRepository<LimiteCartaoCliente, Long> {

	public List<Optional<LimiteCartaoCliente>> findByCpf(String cpf);
	
}
