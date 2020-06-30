package br.com.codenation.calculadora;

public enum FaixaCalculoDescontoInss {

    PRIMEIRA_FAIXA(1_500.00, 0.08),

    SEGUNDA_FAIXA(1_500.01, 0.09),

    ULTIMA_FAIXA(4_000.00, 0.11);

    final double salarioBase;

    final double desconto;

    FaixaCalculoDescontoInss(double salarioBase, double desconto) {
        this.salarioBase = salarioBase;
        this.desconto = desconto;
    }

    
    
}