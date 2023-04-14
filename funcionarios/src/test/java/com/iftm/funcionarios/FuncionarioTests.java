package com.iftm.funcionarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuncionarioTests {
    @Test
    public void testConstrutorValido() {
        Funcionario funcionario = new Funcionario("João", 35, 50.00);
        Assertions.assertEquals("João", funcionario.getNome());
        Assertions.assertEquals(35, funcionario.getHorasTrabalhadas());
        Assertions.assertEquals(50.00, funcionario.getValorPorHora());
    }

    @Test
    public void testConstrutorHorasInvalidas() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("Maria", 50, 60.00);
        });
    }

    @Test
    public void testConstrutorValorPorHoraInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("José", 50, 30.00);
        });
    }

    @Test
    public void testSetNome() {
        Funcionario funcionario = new Funcionario("Pedro", 20, 40.00);
        funcionario.setNome("Carlos");
        Assertions.assertEquals("Carlos", funcionario.getNome());
    }

    @Test
    public void testSetHorasTrabalhadas() {
        Funcionario funcionario = new Funcionario("Fernanda", 25, 45.00);
        funcionario.setHorasTrabalhadas(30);
        Assertions.assertEquals(30, funcionario.getHorasTrabalhadas());
    }

    @Test
    public void testSetHorasTrabalhadasInvalidas() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("Paula", 45, 50.00);
            funcionario.setHorasTrabalhadas(50);
        });
    }

    @Test
    public void testSetValorPorHora() {
        Funcionario funcionario = new Funcionario("Lucas", 30, 55.00);
        funcionario.setValorPorHora(60.00);
        Assertions.assertEquals(60.00, funcionario.getValorPorHora());
    }

    @Test
    public void testSetValorPorHoraInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = new Funcionario("Marcos", 35, 35.00);
            funcionario.setValorPorHora(20.00);
        });
    }
}


