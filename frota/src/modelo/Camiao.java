package modelo;

public class Camiao extends Veiculo {
    private double capacidadeCargaToneladas;
    private static final double CONSUMO_MEDIO_L100 = 25.0; // litros / 100km

    public Camiao(String matricula, String marca, double capacidadeDeposito, double capacidadeCargaToneladas) {
        super(matricula, marca, capacidadeDeposito);
        setCapacidadeCargaToneladas(capacidadeCargaToneladas);
    }

    @Override
    public double calcularAutonomia() {
        return (nivelCombustivel / CONSUMO_MEDIO_L100) * 100;
    }

    @Override
    public String descrever() {
        return String.format("Camião | Marca: %s | Matrícula: %s | Carga Máx: %.1f t | Autonomia: %.1f km",
                marca, matricula, capacidadeCargaToneladas, calcularAutonomia());
    }

    public double getCapacidadeCargaToneladas() {
        return capacidadeCargaToneladas;
    }

    public void setCapacidadeCargaToneladas(double capacidadeCargaToneladas) {
        if (capacidadeCargaToneladas <= 0) {
            throw new IllegalArgumentException("A capacidade de carga deve ser superior a 0 toneladas.");
        }
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }
}