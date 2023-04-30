package com.br.estoque;

public class EstoqueResponse {
    private Long produtoId;
    private boolean estaDisponivel;

    public EstoqueResponse(Long produtoId, boolean estaDisponivel) {
        this.produtoId = produtoId;
        this.estaDisponivel = estaDisponivel;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }
}
