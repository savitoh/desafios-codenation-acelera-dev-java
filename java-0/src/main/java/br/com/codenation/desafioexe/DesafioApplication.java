package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	private static final short VALOR_MAXIMO = 350;

	public static List<Integer> fibonacci() {
		List<Integer> sequenciaFibonnacci = new ArrayList<>();
		int index = 0;
		int quantidadeValoresMaiores350 = 0;
		while(quantidadeValoresMaiores350 < 1) {
			Integer valueFibonacci = fibonacci(index);
			sequenciaFibonnacci.add(valueFibonacci);
			index++;
			if(valueFibonacci > VALOR_MAXIMO) 
				quantidadeValoresMaiores350++;
		}
		return sequenciaFibonnacci;
	}

	public static Boolean isFibonacci(final Integer a) {
		return fibonacci().contains(a);
	}

	public static Integer fibonacci(final Integer n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) 
			return 1;
		else 
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

}