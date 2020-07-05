package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        Objects.requireNonNull(placa);
        Objects.requireNonNull(cor);
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public boolean possuiMotorista() {
        return Objects.nonNull(this.motorista);
    }

    public boolean motoristaEhMenorDeIdade() {
        return  Objects.isNull(this.motorista) || this.motorista.ehMenorIdade();
    }

    public boolean motoristaEstaSuspenso() {
        return Objects.isNull(this.motorista) || this.motorista.habilitacaoEstaSuspensa();
    }

    public boolean motoristaEhSenior() {
        return Objects.isNull(this.motorista) || this.motorista.ehSenior();
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            return new Carro(motorista, placa, cor);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
        result = prime * result + ((placa == null) ? 0 : placa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carro other = (Carro) obj;
        if (cor != other.cor)
            return false;
        if (motorista == null) {
            if (other.motorista != null)
                return false;
        } else if (!motorista.equals(other.motorista))
            return false;
        if (placa == null) {
            if (other.placa != null)
                return false;
        } else if (!placa.equals(other.placa))
            return false;
        return true;
    }
}
