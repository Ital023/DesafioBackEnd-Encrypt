# Cryptography-DesafioBackEnd <img align="center" alt="Italo-Spring" height="90" width="120" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original-wordmark.svg"> <img align="center" alt="Italo-Java" height="90" width="120" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-plain-wordmark.svg"> <img align="center" alt="Italo-Spring" height="90" width="120" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-plain-wordmark.svg"> <img align="center" alt="Italo-Spring" height="90" width="120" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg">


> Projeto focado em ser uma API RestFul de criptografia.
>
> Implementar a criptografia em um serviço de forma transparente para a API e para as camadas de serviço de sua aplicação. O objetivo é garantir que os campos sensíveis dos objetos de entidade não sejam visíveis diretamente, realizando a criptografia em tempo de execução durante a conversão da entidade para a coluna correspondente no banco de dados, e vice-versa..
- Link ([Desafio])(https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md) você pode clicar no link.

## Exemplo

Considere os campos `userDocument` e `creditCardToken` como campos sensíveis que devem ser criptografados. A tabela de
exemplo seria a seguinte:

| id | userDocument     | creditCardToken | value |
|:---|:-----------------|:----------------|:------|
| 1  | MzYxNDA3ODE4MzM= | YWJjMTIz        | 5999  |
| 2  | MzI5NDU0MTA1ODM= | eHl6NDU2        | 1000  |
| 3  | NzYwNzc0NTIzODY= | Nzg5eHB0bw==    | 1500  |

A estrutura da entidade correspondente seria a seguinte:

| Campo           | Tipo   |
|:----------------|:-------|
| id              | Long   |
| userDocument    | String |
| creditCardToken | String |
| value           | Long   |


## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente de `Java JDK 17`
- Você tem uma máquina `<Windows / Linux / Mac>`.
- O projeto está utilizando `PostgresSQL` como banco de dados. Sendo necessário o `FlyWay` para migração de dados.
- Para ([instalar PostgresSQL])(https://www.postgresql.org/download/) você pode clicar no link.

## 🚀 Instalando Cryptography-DesafioBackEnd

Para instalar o Cryptography-DesafioBackEnd, siga estas etapas:
Git:
```
git clone https://github.com/Ital023/DesafioBackEnd-Encrypt.git
```

## ☕ Usando Cryptography-DesafioBackEnd

Para usar Cryptography-DesafioBackEnd, siga estas etapas:

```

POST / - (localhost:8080/operation) registra as informações criptografadas no banco de dados.

```

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Ital023" title="Github do Ítalo Miranda">
        <img src="https://avatars.githubusercontent.com/u/113559117?v=4" width="100px;" alt="Foto do Ítalo Miranda no GitHub"/><br>
        <sub>
          <b>Ítalo Miranda</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
