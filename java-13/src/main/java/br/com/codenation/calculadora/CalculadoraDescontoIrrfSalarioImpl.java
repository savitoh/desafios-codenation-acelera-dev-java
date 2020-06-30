package br.com.codenation.calculadora;

public class CalculadoraDescontoIrrfSalarioImpl implements CalculadoraDescontoIrrfSalario<CalculadoraDescontoInssSalario>{

    @Override
    public double aplicarDesconto(double salarioBase, CalculadoraDescontoInssSalario descontoInss) {

        final double salarioDescontadoINSS = salarioBase - descontoInss.applyAsDouble(salarioBase);

        if(salarioDescontadoINSS <= FaixaCalculoDescontoIrrf.PRIMEIRA_FAIXA.salarioBase) 
            return salarioDescontadoINSS - (salarioDescontadoINSS*FaixaCalculoDescontoIrrf.PRIMEIRA_FAIXA.desconto.orElse(0.0));

        if(salarioDescontadoINSS > FaixaCalculoDescontoIrrf.ULTIMA_FAIXA.salarioBase)
            return salarioDescontadoINSS - (salarioDescontadoINSS*FaixaCalculoDescontoIrrf.ULTIMA_FAIXA.desconto.orElse(0.0));
        
        return salarioDescontadoINSS - (salarioDescontadoINSS*FaixaCalculoDescontoIrrf.SEGUNDA_FAIXA.desconto.orElse(0.0));
    }
    
}