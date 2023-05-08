package com.br.estoque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    private static int count = 1;
    private Logger log = LoggerFactory.getLogger(EstoqueService.class);

    public EstoqueResponse produtoDisponivel(Long id, int quantidade) {
        log.info("Verificando se produtoId #{} esta disponivel", id);

        boolean estadisponivel = count % 2 == 0;
        count++;

        log.info("Concluiu consulta de disponibilidade do produto");
        return new EstoqueResponse(id, estadisponivel);
    }
}
