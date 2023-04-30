package com.br.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping("/disponivel")
    public ResponseEntity<EstoqueResponse> produtoDisponivel(@RequestParam Long id, @RequestParam int quantidade) {

        return ResponseEntity.ok(service.reservaSeProdutoDisponivel(id, quantidade));
    }
}
