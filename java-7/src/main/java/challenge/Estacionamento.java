package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Estacionamento {

    private static final short LIMITE = 10;

    private List<Carro> carros = new ArrayList<>(LIMITE);

    public void estacionar(Carro carro) {
      this.validate(carro);
      if(this.carros.size() < LIMITE) {
        carros.add(carro);
      } else {
        int index = getIndexPrimeiroMotoristaAptoSair()
            .orElseThrow(() -> new EstacionamentoException("Estacionamento Lotado (:"));
        carros.remove(index);
        carros.add(carro);
      }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        for(Carro carroTest : carros) {
            boolean x = Objects.equals(carroTest, carro);
            System.out.println(x);
        }
        return carros.contains(carro);
    }

    private OptionalInt getIndexPrimeiroMotoristaAptoSair() {
        return IntStream.range(0, carros.size())
            .filter(index -> !carros.get(index).motoristaEhSenior())
            .findFirst();
    }

    private void validate(Carro carro) {
        if(Boolean.FALSE.equals(carro.possuiMotorista())) {
            throw new EstacionamentoException("Carro não pode ser autonomo");
        }
        if(carro.motoristaEhMenorDeIdade()) {
            throw new EstacionamentoException("Motorista não pode ser menor de idade");
        }
        if(carro.motoristaEstaSuspenso()) {
            throw new EstacionamentoException("Motorista não pode ser suspenso");
        }
    }
}
