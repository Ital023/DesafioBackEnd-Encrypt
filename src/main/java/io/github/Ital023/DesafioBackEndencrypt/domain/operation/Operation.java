package io.github.Ital023.DesafioBackEndencrypt.domain.operation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(name = "userdocument",nullable = false)
    private String userDocument;

    @Column(name = "creditcardtoken",nullable = false)
    private String creditCardToken;

    @Column(name = "operationvalue",nullable = false)
    private Long value;




}
