package br.com.codenation.calculadora;

public class CalculadoraSalario {

	private static final double SALARIO_MINIMO = 1_039.00;

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < SALARIO_MINIMO)
            return 0;
		double salarioLiquido = new CalculadoraDescontoIrrfSalarioImpl()
			.aplicarDesconto(salarioBase, new CalculadoraDescontoInssSalario());
		return Math.round(salarioLiquido);
	}


}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/