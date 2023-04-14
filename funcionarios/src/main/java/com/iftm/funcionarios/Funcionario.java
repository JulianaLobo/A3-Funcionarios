package com.iftm.funcionarios;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorPorHora;

    public Funcionario(String nome, int horasTrabalhadas, double valorPorHora) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (horasTrabalhadas < 1 || horasTrabalhadas > 40) {
            throw new IllegalArgumentException("Horas trabalhadas inválidas");
        }
        if (valorPorHora < 1320 * 0.04 || valorPorHora > 1320 * 0.1) {
            throw new IllegalArgumentException("Valor por hora inválido");
        }
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
        if (horasTrabalhadas < 1 || horasTrabalhadas > 40) {
            throw new IllegalArgumentException("Horas trabalhadas devem estar entre 1 e 40 horas.");
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        double salarioMinimo = 1320.00;
        double valorMinimo = salarioMinimo * 0.04;
        double valorMaximo = salarioMinimo * 0.1;
        if (valorPorHora < valorMinimo || valorPorHora > valorMaximo) {
            throw new IllegalArgumentException("Valor da hora inválido.");
        }
        this.valorPorHora = valorPorHora;
    }
}

