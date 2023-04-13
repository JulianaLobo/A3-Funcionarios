package com.iftm.funcionarios;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorPorHora;

    public Funcionario(String nome, int horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public double calcularPagamento() {
        double salarioMinimo = 1320.00;
        int maxHorasTrabalhadas = 40;
        double minValorPorHora = 0.04 * salarioMinimo;
        double maxValorPorHora = 0.10 * salarioMinimo;

        if (this.horasTrabalhadas > maxHorasTrabalhadas) {
            throw new IllegalArgumentException("Horas trabalhadas excedem o máximo permitido.");
        } else if (this.valorPorHora < minValorPorHora || this.valorPorHora > maxValorPorHora) {
            throw new IllegalArgumentException("Valor por hora não está dentro dos limites permitidos.");
        }

        double pagamento = this.horasTrabalhadas * this.valorPorHora;

        if (pagamento < salarioMinimo) {
            pagamento = salarioMinimo;
        }

        return pagamento;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}

