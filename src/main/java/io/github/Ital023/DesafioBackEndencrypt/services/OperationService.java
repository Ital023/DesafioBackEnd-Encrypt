package io.github.Ital023.DesafioBackEndencrypt.services;

import io.github.Ital023.DesafioBackEndencrypt.domain.operation.Operation;
import io.github.Ital023.DesafioBackEndencrypt.dto.OperationDTO;
import io.github.Ital023.DesafioBackEndencrypt.repositories.OperationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Operation read(Long id){
        Optional<Operation> operation = this.repository.findById(id);

        if(operation.isEmpty()){
            throw new EntityNotFoundException();
        }

        Operation operationFound = operation.get();

        String userDocumentDecoded = this.encryptService.decryptData(operationFound.getUserDocument());
        String creditCardDecoded = this.encryptService.decryptData(operationFound.getCreditCardToken());

        Operation operationDecrypted = Operation.builder()
                .id(operationFound.getId())
                .userDocument(userDocumentDecoded)
                .creditCardToken(creditCardDecoded)
                .value(operationFound.getValue())
                .build();

        return operationDecrypted;
    }

    public void delete(Long id){
        Optional<Operation> operation = this.repository.findById(id);

        if(operation.isEmpty()){
            throw new EntityNotFoundException();
        }

        Operation operationFound = operation.get();

        this.repository.delete(operationFound);
    }

    public void alter(OperationDTO operationDTO,Long id){
        Optional<Operation> operation = this.repository.findById(id);

        if(operation.isEmpty()){
            throw new EntityNotFoundException();
        }

        Operation operationFound = operation.get();

        if(userDocumentHasContent(operationDTO)){
            operationFound.setUserDocument(this.encryptService.encryptData(operationDTO.userDocument()));
        }
        if(creditCardTokenHasContent(operationDTO)){
            operationFound.setCreditCardToken(this.encryptService.encryptData(operationDTO.creditCardToken()));
        }
    }

    //REFACTOR: EXTRACTOR METHOD
    public Boolean userDocumentHasContent(OperationDTO operationDTO){
        return !operationDTO.userDocument().isEmpty();
    }

    public Boolean creditCardTokenHasContent(OperationDTO operationDTO){
        return !operationDTO.creditCardToken().isEmpty();
    }
}
