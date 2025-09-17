# FGUApplication

Aplikace pro účely Fyziologického ústavu na vedení evidence PhD studentů a jejich závěrečných prací.
Poskytuje jednoduché webové rozhraní pro administrativní obsluhu a evidenci studentů, prací, fakult, oddělení a
oborových rad.

# Funkce aplikace

- Evidence a správa závěrečných prací (přidání, úprava a mazání)
- Přiřazování studentů, školitelů a konzultantů k pracím
- Evidence osob
- Správa fakult, oddělení a komisí
- REST API pro komunikaci mezi frontendem a backendem
- Webové UI postavené na Reactu + Bootstrapu

# Použité technologie

- Backend:
    - Java openjdk-19 (Oracle OpenJDK 23.0.2), Spring Boot, Spring Data JPA, Maven
- Frontend:
    - React, Bootstrap, React Router, Node.js
- Databáze:
    - MySQL (Docker kontejner)
- Docker:
    - Docker Compose
- Dokumentace:
    - Swagger

# Spouštění aplikace

1) Naklonování repozitáře
    - git clone https://github.com/NewtEvans/FGUApplication
2) Spustit přes Docker (docker-compose up --build)
    - Spustí se:
        - Spring Boot backend: https://localhost:8080
        - React frontend: http://localhost:3000
        - MySQL: localhost: 3306
3) Webové rozhraní
    - Do slozky **FGUApplication_frontend** nainstalovat vsechny potrebne zavislosti a balicky (npm install)
    - Otevři prohlížeč na: http://localhost:3000

# Struktura projektu

    FGUApplication/
        └── src/
        └── main/
        └── java/
        └── cz.newtworks.FGUApplication/
        ├── configuration/
        │   └── WebConfiguration.java
        ├── constant/
        │   ├── Employee.java
        │   └── ThesisType.java
        ├── controller/
        │   ├── CouncilController.java
        │   ├── DepartmentController.java
        │   ├── FacultyController.java
        │   ├── PersonController.java
        │   ├── SummaryController.java
        │   └── ThesisController.java
        ├── dto/
        │   ├── filter/
        │   └── mapper/
        │       ├── CouncilDTO.java
        │       ├── DepartmentDTO.java
        │       ├── FacultyDTO.java
        │       ├── PersonDTO.java
        │       ├── SummaryDTO.java
        │       └── ThesisDTO.java
        ├── entity/
        │   └── repository/
        │       ├── CouncilEntity.java
        │       ├── DepartmentEntity.java
        │       ├── FacultyEntity.java
        │       ├── PersonEntity.java
        │       └── ThesisEntity.java
        ├── exception/
        │   └── ResourceNotFoundException.java
        ├── service/
        │   ├── CouncilService.java
        │   ├── CouncilServiceImpl.java
        │   ├── DepartmentService.java
        │   ├── DepartmentServiceImpl.java
        │   ├── FacultyService.java
        │   ├── FacultyServiceImpl.java
        │   ├── PersonService.java
        │   ├── PersonServiceImpl.java
        │   ├── SummaryService.java
        │   ├── SummaryServiceImpl.java
        │   ├── ThesisService.java
        │   └── ThesisServiceImpl.java
        ├── specification/
        │   ├── CouncilSpecification.java
        │   ├── DepartmentSpecification.java
        │   ├── FacultySpecification.java
        │   ├── PersonSpecification.java
        │   └── ThesisSpecification.java
        ├── verifications/
        │   ├── VerificationService.java
        │   └── VerificationServiceImpl.java
        └── ApplicationMain.java

4) Dokumentace
    - http://localhost:8081/swagger-ui/index.html#/

# Autor

Tomáš Fišera - tomas.fisera@newtworks.cz

https://newtworks.cz

