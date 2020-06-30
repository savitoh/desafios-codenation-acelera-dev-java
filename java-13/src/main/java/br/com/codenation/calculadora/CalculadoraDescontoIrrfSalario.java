package br.com.codenation.calculadora;

import java.util.function.DoubleUnaryOperator;

@FunctionalInterface
public interface CalculadoraDescontoIrrfSalario<T extends DoubleUnaryOperator> {
    
    double aplicarDesconto(double salarioBase, T descontoInss);
}