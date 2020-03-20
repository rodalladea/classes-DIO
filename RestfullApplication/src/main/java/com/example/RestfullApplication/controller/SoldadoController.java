package com.example.RestfullApplication.controller;

import com.example.RestfullApplication.controller.request.SoldadoEditRequest;
import com.example.RestfullApplication.dto.Soldado;
import com.example.RestfullApplication.service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;

    private SoldadoController(SoldadoService soldadoService) {
        this.soldadoService = soldadoService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable("cpf") String cpf) {
        Soldado soldado = soldadoService.buscarSoldado(cpf);
        return ResponseEntity.ok(soldado);
    }

    @PostMapping
    public ResponseEntity<Soldado> criarSoldado(@RequestBody Soldado soldado) {

        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).body(soldado);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@RequestBody SoldadoEditRequest soldadoEditRequest, @PathVariable String cpf) {
        soldadoService.alterarSoldado(cpf, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarSoldado(@PathVariable String cpf) {
        soldadoService.deletarSoldado(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Soldado>> buscarSoldado() {
        List<Soldado> soldados = soldadoService.buscarTodos();
        return ResponseEntity.ok(soldados);
    }
}
