package servico;

import modelo.Veiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorFrota {
    private final List<Veiculo> frota;

    public GestorFrota() {
        this.frota = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Impossível adicionar um veículo nulo.");
        }
        frota.add(veiculo);
    }

    public List<Veiculo> getFrota() {
        return Collections.unmodifiableList(frota);
    }

    public double calcularAutonomiaMedia() {
        if (frota.isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        for (Veiculo v : frota) {
            soma += v.calcularAutonomia();
        }
        return soma / frota.size();
    }
}