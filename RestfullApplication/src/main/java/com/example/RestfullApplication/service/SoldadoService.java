package com.example.RestfullApplication.service;

import com.example.RestfullApplication.controller.request.SoldadoEditRequest;
import com.example.RestfullApplication.dto.Soldado;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoldadoService {

    public Soldado buscarSoldado(String cpf) {
        Soldado soldado = new Soldado();

        soldado.setCpf(cpf);
        soldado.setNome("Rodrigo");
        soldado.setRaca("Humano");
        soldado.setArma("AK47");

        return soldado;
    }

    public void criarSoldado(Soldado soldado) {

    }

    public void alterarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest) {

    }

    public void deletarSoldado(String cpf) {

    }

    public List<Soldado> buscarTodos() {

        Soldado soldado1 = new Soldado();

        soldado1.setCpf("123456789");
        soldado1.setNome("Rodrigo");
        soldado1.setRaca("Humano");
        soldado1.setArma("AK47");

        Soldado soldado2 = new Soldado();

        soldado2.setCpf("987654321");
        soldado2.setNome("Thiago");
        soldado2.setRaca("Elfo");
        soldado2.setArma("Arco");

        return Arrays.asList(soldado1, soldado2);
    }
}
