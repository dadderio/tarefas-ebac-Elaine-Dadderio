package br.com.dadderio;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PessoaTest {

    Pessoa p = new Pessoa();

    @Test
    public void testarListaMulheres(){


        p.setListaDePessoas(Arrays.asList("MARIA - F, JOANA - F"));
        List<String> mulheresListadas = p.listarMulheres();
        List<String> testeEsperado = Arrays.asList("MARIA - F, JOANA - F");
        assertEquals(testeEsperado, mulheresListadas);

    }
}
