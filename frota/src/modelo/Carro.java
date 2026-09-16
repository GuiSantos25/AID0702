package modelo;

public class Carro extends Veiculo {
    private int numeroPortas;
    private static final double CONSUMO_MEDIO_L100 = 6.5; // litros / 100km

    public Carro(String matricula, String marca, double capacidadeDeposito, int numeroPortas) {
        super(matricula, marca, capacidadeDeposito);
        setNumeroPortas(numeroPortas);
    }

    @Override
    public double calcularAutonomia() {
        return (nivelCombustivel / CONSUMO_MEDIO_L100) * 100;
    }

    @Override
    public String descrever() {
        return String.format("Carro | Marca: %s | Matrícula: %s | Portas: %d | Autonomia: %.1f km",
                marca, matricula, numeroPortas, calcularAutonomia());
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        if (numeroPortas < 2 || numeroPortas > 5) {
            throw new IllegalArgumentException("Número de portas inválido para um ligeiro de passageiros (2 a 5).");
        }
        this.numeroPortas = numeroPortas;
    }
}