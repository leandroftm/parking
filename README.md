# Condominium Parking Management System

A Spring Boot backend for managing buildings, apartments, residents, vehicles, and bicycles in a condominium.

## Features
- CRUD for all entities (Building and Apartment entities can only READ, not CREATE UPDATE or DELETE)
- Parking rules:  
  - STANDARD apartment → max 1 parked vehicle  
  - COVERAGE apartment → max 2 parked vehicles  
- CPF (resident), vehicle plate, and bicycle identifier are unique  
- All residents must provide CPF and phone  

## Technologies
- Java 21  
- Spring Boot 3  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  

## Entities
- **Building**: code, name, floors, apartmentsPerFloor  
- **Apartment**: number, floor, type (STANDARD/COVERAGE), relationships  
- **Resident**: name, cpf, phone, type  
- **Vehicle**: plate, model, color, parked  
- **Bicycle**: model, color, identifier  
