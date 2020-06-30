package br.com.codenation.calculadora;

import java.util.Optional;

public enum FaixaCalculoDescontoIrrf {
    
    PRIMEIRA_FAIXA(3_000.00, Optional.empty()),

    SEGUNDA_FAIXA(3_000.01, Optional.of(0.075)),

    ULTIMA_FAIXA(6_000.00, Optional.of(0.15));

    double salarioBase;

    Optional<Double> desconto;

    FaixaCalculoDescontoIrrf(double salarioBase, Optional<Double> desconto) {
        this.salarioBase = salarioBase;
        this.desconto = desconto;
    }
}