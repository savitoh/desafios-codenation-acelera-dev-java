package br.com.codenation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		final int tamanhoVetor = elements.length;
		return IntStream.of(elements).sum()/tamanhoVetor;
	}

	public static int mode(int[] elements) {
		Objects.requireNonNull(elements);
		int maiorValor = elements[0];
		int quantidadePresenteVetorMaiorValor = 1;
		for(int indexExterno = 0; indexExterno< elements.length - 1; indexExterno++) {
			int valorAtual = elements[indexExterno];
			int quantidadePresenteVetorValorAtual = 1;
			for(int indexInterno = indexExterno + 1; indexInterno < elements.length; indexInterno++) {
				if(valorAtual == elements[indexInterno]) {
					quantidadePresenteVetorValorAtual++;
				}
			}
			if(quantidadePresenteVetorValorAtual > quantidadePresenteVetorMaiorValor) {
				maiorValor = valorAtual;
				quantidadePresenteVetorMaiorValor = quantidadePresenteVetorValorAtual;
			}
		}
		return maiorValor;
	}

	public static int median(int[] elements) {
		final int tamanhoVetor = elements.length;
		List<Integer> valoresOrdenados = IntStream.of(elements)
			.boxed()
			.sorted()
			.collect(Collectors.toList());
		if(numeroEhPar(tamanhoVetor)) {
			final int metadeDireitaVetor = tamanhoVetor/2;
			final int metadeEsquerdaVetor = (tamanhoVetor/2) + 1;
			return (valoresOrdenados.get(metadeDireitaVetor-1) + valoresOrdenados.get(metadeEsquerdaVetor-1))/2;
		}
		final int metadeVetor = tamanhoVetor/2;
		return valoresOrdenados.get(metadeVetor);
	}

	private static boolean numeroEhPar(int valor) {
		return valor%2 == 0;
	}
}