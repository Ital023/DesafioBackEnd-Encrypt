package io.github.Ital023.DesafioBackEndencrypt.repositories;

import io.github.Ital023.DesafioBackEndencrypt.domain.operation.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
