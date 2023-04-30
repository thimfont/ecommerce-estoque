package com.br.estoque;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoRepository repository;

    //TODO: criar uma service para lidar com metodos do repository e assim mover a exception para ele evitando duplicar codigo
    public EstoqueResponse produtoDisponivel(Long produtoId, int quantidadeNecessaria) {
        Produto produto = repository
                .findById(produtoId)
                .orElseThrow(() -> new EntityNotFoundException("Produto com id " + produtoId + " não foi encontrado."));

        if (possuiQuantidadeNecessaria(produto.getQuantidade(), quantidadeNecessaria)) {
            reservaTemporariaDoProduto(produto, quantidadeNecessaria);
            return new EstoqueResponse(produtoId, true);
        }

        return new EstoqueResponse(produtoId, true);
    }

    private boolean possuiQuantidadeNecessaria(int quantidadeDisponivel, int quantidadeNecessaria) {
        return quantidadeDisponivel - quantidadeNecessaria >= 0;
    }

    private void reservaTemporariaDoProduto(Produto produto, int quantidadeSolicitada) {
        produto.diminuiQuantidade(quantidadeSolicitada);
        repository.save(produto);
    }
}
