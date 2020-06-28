package challenge;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CriptografiaCesariana implements Criptografia {

    private static final short MOVIMENTA_NUMERO_CASA = 3;

    @Override
    public String criptografar(String texto) {
        Objects.requireNonNull(texto);
        if(texto.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return texto.toLowerCase().chars()
                .mapToObj(item -> {
                    char character = (char) item;
                    Optional<Integer> posicaoCharacter = Alfabeto.getPosicao(character);
                    if(posicaoCharacter.isPresent()) {
                        Integer posicaoCifrada = posicaoCharacter.get();
                        Integer posicaoDecifrada = ((posicaoCifrada + MOVIMENTA_NUMERO_CASA) % Alfabeto.ULTIMA_POSICAO);
                        char caracterDecifrado = Alfabeto.getCharacter(posicaoDecifrada.shortValue());
                        return String.valueOf(caracterDecifrado);
                    }
                    return String.valueOf(character);
                })
                .collect(Collectors.joining());
    }

    @Override
    public String descriptografar(String texto) {
        Objects.requireNonNull(texto);
        if(texto.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return texto.toLowerCase().chars()
                .mapToObj(item -> {
                    char character = (char) item;
                    Optional<Integer> posicaoCharacter = Alfabeto.getPosicao(character);
                    if(posicaoCharacter.isPresent()) {
                        Integer posicaoCifrada = posicaoCharacter.get();
                        Integer posicaoDecifrada = ((posicaoCifrada - MOVIMENTA_NUMERO_CASA) % Alfabeto.ULTIMA_POSICAO);
                        char caracterDecifrado = Alfabeto.getCharacter(posicaoDecifrada.shortValue());
                        return String.valueOf(caracterDecifrado);
                    }
                    return String.valueOf(character);
                })
                .collect(Collectors.joining());
    }
}
