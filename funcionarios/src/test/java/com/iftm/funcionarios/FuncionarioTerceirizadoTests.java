package com.iftm.funcionarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuncionarioTerceirizadoTests {

    @Test
    public void testConstrutorValido() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("João", 30, 10.00, 500.00);
        Assertions.assertEquals("João", funcionario.getNome());
        Assertions.assertEquals(30, funcionario.getHorasTrabalhadas());
        Assertions.assertEquals(10.00, funcionario.getValorPorHora());
        Assertions.assertEquals(500.00, funcionario.getDespesaAdicional());
    }

    @Test
    public void testConstrutorNomeVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("", 30, 10.00, 500.00);
        });
    }

    @Test
    public void testConstrutorHorasInvalidas() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("Maria", 50, 10.00, 500.00);
        });
    }

    @Test
    public void testConstrutorValorHoraMinimo() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("José", 20, 52.80, 800.00);
        Assertions.assertEquals("José", funcionario.getNome());
        Assertions.assertEquals(20, funcionario.getHorasTrabalhadas());
        Assertions.assertEquals(52.80, funcionario.getValorPorHora());
        Assertions.assertEquals(800.00, funcionario.getDespesaAdicional());
    }

    @Test
    public void testConstrutorValorHoraMaximo() {
        FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado("Ana", 35, 132.00, 300.00);
        Assertions.assertEquals("Ana", funcionario.getNome());
        Assertions.assertEquals(35, funcionario.getHorasTrabalhadas());
        Assertions.assertEquals(132.00, funcionario.getValorPorHora());
        Assertions.assertEquals(300.00, funcionario.getDespesaAdicional());
    }

    @Test
    public void testConstrutorValorHoraAbaixoMinimo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioTerceirizado("Carlos", 40, 51.00, 900.00);
        });
    }

    }
