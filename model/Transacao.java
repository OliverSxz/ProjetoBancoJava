package model;

import java.time.LocalDateTime;

public class Transacao {

    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime data;

    public Transacao(TipoTransacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return data +
                " | " + tipo +
                " | R$ " + String.format("%.2f", valor);
    }
}