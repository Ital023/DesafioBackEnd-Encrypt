package io.github.Ital023.DesafioBackEndencrypt.services;

import io.github.Ital023.DesafioBackEndencrypt.domain.operation.Operation;
import io.github.Ital023.DesafioBackEndencrypt.dto.OperationDTO;
import io.github.Ital023.DesafioBackEndencrypt.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    @Autowired
    private OperationRepository repository;
    @Autowired
    private EncryptService encryptService;


    public Operation create(OperationDTO operationDTO){
        String userDocumentHashed = this.encryptService.encryptData(operationDTO.userDocument());
        String creditCardHashed = this.encryptService.encryptData(operationDTO.creditCardToken());

        Operation operation = Operation.builder()
                .userDocument(userDocumentHashed)
                .creditCardToken(creditCardHashed)
                .value(operationDTO.operationValue())
                .build();

        this.repository.save(operation);

        return operation;
    }

}
