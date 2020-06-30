package br.com.codenation.calculadora;

import java.util.function.DoubleUnaryOperator;

public class CalculadoraDescontoInssSalario implements DoubleUnaryOperator {

    @Override
    public double applyAsDouble(double salarioBase) {

        if(salarioBase <= FaixaCalculoDescontoInss.PRIMEIRA_FAIXA.salarioBase)
            return salarioBase*FaixaCalculoDescontoInss.PRIMEIRA_FAIXA.desconto;
            
        if(salarioBase > FaixaCalculoDescontoInss.ULTIMA_FAIXA.salarioBase) 
            return salarioBase*FaixaCalculoDescontoInss.ULTIMA_FAIXA.desconto;

        return salarioBase*FaixaCalculoDescontoInss.SEGUNDA_FAIXA.desconto;
    }

}