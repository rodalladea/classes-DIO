package com.example.restfullApplication.resource;

import com.example.restfullApplication.controller.response.SoldadoListResponse;
import com.example.restfullApplication.controller.response.SoldadoResponse;
import com.example.restfullApplication.entity.SoldadoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.restfullApplication.controller.SoldadoController;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ResourceSoldado {
    private ObjectMapper objectMapper;

    public ResourceSoldado(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldadoListResponse criarLink(SoldadoEntity soldadoEntity) {
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldadoEntity.getId())).withSelfRel();
        soldadoListResponse.add(link);
        return soldadoListResponse;
    }

    public SoldadoResponse criarLinkDetalhe(SoldadoEntity soldadoEntity) {
        SoldadoResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoResponse.class);
        if(soldadoEntity.getStatus().equals("morto")){
            Link link = linkTo(methodOn(SoldadoController.class).deletarSoldado(soldadoEntity.getId()))
                    .withRel("remover")
                    .withTitle("Deletar soldado")
                    .withType("delete");
            soldadoListResponse.add(link);
        }else if(soldadoEntity.getStatus().equals("vivo")) {
            Link link = linkTo(methodOn(SoldadoController.class).frenteCastelo(soldadoEntity.getId()))
                    .withRel("batalhar")
                    .withTitle("Ir para frente do castelo")
                    .withType("put");
            soldadoListResponse.add(link);
        }
        return soldadoListResponse;
    }
}
