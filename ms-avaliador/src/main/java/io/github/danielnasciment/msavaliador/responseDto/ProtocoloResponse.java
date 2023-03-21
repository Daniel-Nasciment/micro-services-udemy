package io.github.danielnasciment.msavaliador.responseDto;

import java.util.UUID;

public class ProtocoloResponse {

	private String protocolo = UUID.randomUUID().toString();

	public String getProtocolo() {
		return protocolo;
	}

}
