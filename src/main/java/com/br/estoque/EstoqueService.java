package com.br.estoque;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoRepository repository;

    //TODO: criar uma service para lidar com metodos do repository e assim mover a exception para ele evitando duplicar codigo
    @Transactional
    public EstoqueResponse reservaSeProdutoDisponivel(Long produtoId, int quantidadeNecessaria) {
        Produto produto = localizaProduto(produtoId);
        boolean estaDisponivel = possuiQuantidadeNecessaria(produto.getQuantidade(), quantidadeNecessaria);
        return reservaProduto(estaDisponivel, produto, quantidadeNecessaria);
    }

    private Produto localizaProduto(Long produtoId) {
        return repository
                .findById(produtoId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Produto com id " + produtoId + " não foi encontrado."));
    }

    private boolean possuiQuantidadeNecessaria(int quantidadeDisponivel, int quantidadeNecessaria) {
        return quantidadeDisponivel - quantidadeNecessaria >= 0;
    }

    private EstoqueResponse reservaProduto(boolean estaDisponivel, Produto produto, int quantidadeNecessaria) {
        if (estaDisponivel) {
            reservaTemporariaDoProduto(produto, quantidadeNecessaria);
            return new EstoqueResponse(produto.getId(), true);
        }

        return new EstoqueResponse(produto.getId(), false);
    }

    private void reservaTemporariaDoProduto(Produto produto, int quantidadeSolicitada) {
        produto.diminuiQuantidade(quantidadeSolicitada);
        repository.save(produto);
    }
}
