package io.github.danielnasciment.msavaliador.calculador;

import java.math.BigDecimal;

public class CalculadorLimite {
	
	// REGRA PARA CALCULO DO LIMITE PRÉ-APROVADO
	private static final int FATOR_DIVISAO_IDADE = 10;

	public BigDecimal calcular(int idadeCliente, BigDecimal limiteBasico) {
		 
		BigDecimal fator = BigDecimal.valueOf(idadeCliente).divide(new BigDecimal(FATOR_DIVISAO_IDADE));
		
		return fator.multiply(limiteBasico).setScale(2);

	}

	
	
	
}
