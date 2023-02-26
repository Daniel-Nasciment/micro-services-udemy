package io.github.danielnasciment.mscartoes.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danielnasciment.mscartoes.domain.Cartao;
import io.github.danielnasciment.mscartoes.repository.CartaoRepository;
import io.github.danielnasciment.mscartoes.requestDto.CartaoRequest;
import io.github.danielnasciment.mscartoes.responseDto.CartaoResponse;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	
	public void salvarNovoCartao(@Valid CartaoRequest request) {
		cartaoRepository.save(request.toModel());
	}
	
	public List<CartaoResponse> getCartoesRendaMenorIgual(Long renda){
		List<Cartao> cartoes = cartaoRepository.findByRendaLessThanEqual(new BigDecimal(renda));
	
		List<CartaoResponse> cartoesResponse = new ArrayList<CartaoResponse>();
		
		cartoes.forEach(c -> cartoesResponse.add(new CartaoResponse().toResponse(c)));
		
		return cartoesResponse;
	}
	
}
