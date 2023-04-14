package com.iftm.funcionarios;

public class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorPorHora, double despesaAdicional) {
        super(nome, horasTrabalhadas, valorPorHora);
        this.despesaAdicional = despesaAdicional;

        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (horasTrabalhadas <= 0 || horasTrabalhadas > 40) {
            throw new IllegalArgumentException("Horas trabalhadas inválidas");
        }
        if (valorPorHora < 0.04 * 1320) {
            throw new IllegalArgumentException("Valor por hora abaixo do mínimo permitido.");
        }
    }

    @Override
    public double calcularPagamento() {
        double salarioMinimo = 1320.00;
        int maxHorasTrabalhadas = 40;
        double minValorPorHora = 0.04 * salarioMinimo;
        double maxValorPorHora = 0.10 * salarioMinimo;
        double maxDespesaAdicional = 1000.00;
        double bonusDespesaAdicional = 1.10;

        if (this.getHorasTrabalhadas() > maxHorasTrabalhadas) {
            throw new IllegalArgumentException("Horas trabalhadas excedem o máximo permitido.");
        } else if (this.getValorPorHora() < minValorPorHora || this.getValorPorHora() > maxValorPorHora) {
            throw new IllegalArgumentException("Valor por hora não está dentro dos limites permitidos.");
        } else if (this.despesaAdicional > maxDespesaAdicional) {
            throw new IllegalArgumentException("Despesa adicional não pode ultrapassar R$ 1000.00.");
        }



        double pagamento = super.calcularPagamento();

        if (pagamento < salarioMinimo) {
            pagamento = salarioMinimo;
        }

        pagamento += this.despesaAdicional * bonusDespesaAdicional;

        return pagamento;
    }

    // getters e setters
    public double getDespesaAdicional() {
        return despesaAdicional;
    }

    public void setDespesaAdicional(double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }
}

