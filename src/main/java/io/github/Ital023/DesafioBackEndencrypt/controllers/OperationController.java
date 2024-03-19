package io.github.Ital023.DesafioBackEndencrypt.controllers;

import io.github.Ital023.DesafioBackEndencrypt.domain.operation.Operation;
import io.github.Ital023.DesafioBackEndencrypt.dto.OperationDTO;
import io.github.Ital023.DesafioBackEndencrypt.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping
    public ResponseEntity<Operation> create(@RequestBody OperationDTO operationDTO, UriComponentsBuilder uriBuilder){
        Operation operation = this.operationService.create(operationDTO);

        var uri = uriBuilder.path("/operation/{id}")
                .buildAndExpand(operation.getId()).toUri();

        return ResponseEntity.created(uri).body(operation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation> read(@PathVariable Long id){
         Operation operation = operationService.read(id);
         return ResponseEntity.ok().body(operation);
    }
}
