package challenge;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Alfabeto {
    
    private Alfabeto() {

    }

    private static final char[] ALFABETO;

    private static final short PRIMEIRA_POSICAO = 1;

    static final short ULTIMA_POSICAO = 26;

    static {
        ALFABETO = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> (char) c + "")
                .collect(Collectors.joining())
                .toCharArray();
    }

    public static char getCharacter(short posicao) {
        if(posicao < PRIMEIRA_POSICAO || posicao > ULTIMA_POSICAO) {
            throw new IllegalArgumentException("A posicao do caracter no alfabeto deve ser entre 1 e 26 (: ");
        }
        return ALFABETO[posicao - 1];
    }

    public static Optional<Integer> getPosicao(char character) {
        char lowerCaseCharacter = Character.toLowerCase(character);
        return getPosicao(lowerCaseCharacter, 0, ALFABETO.length - 1);
    }

    private static Optional<Integer> getPosicao(char character, int indexEsquerdo, int indexDireito) {
        final int meio = (indexEsquerdo + indexDireito) / 2;
        if(ALFABETO[meio] == character) {
            return Optional.of(meio + 1);
        }
        if(indexEsquerdo > indexDireito) {
            return Optional.empty();
        }
        else {
            if(ALFABETO[meio] < character) {
                return getPosicao(character, meio + 1 , indexDireito);
            }
            return getPosicao(character, indexEsquerdo, meio - 1);
        }
    }

}