# 🏥 Plateforme de Gestion de Santé – Architecture Microservices

Ce projet a été développé dans le cadre d’un travail pratique afin de concevoir une plateforme de gestion de santé reposant sur une architecture **API Gateway + Microservices**. L’application permet la gestion des patients, des rendez-vous, des dossiers médicaux et de la facturation.

## 🎯 Objectifs du projet

- Implémenter une architecture microservices pour une plateforme de santé modulaire et scalable.
- Développer un système de communication entre microservices avec une API Gateway en Node.js.
- Permettre aux utilisateurs (patients / personnel médical) de gérer facilement les différents aspects de leur parcours de soin.

## 🧩 Microservices Développés

- **Patient Service** Node.js (Express.js)
- **Appointment Service** (Spring Boot)
- **Doctor Service** (Spring Boot)
- **Availability Service** (Spring Boot)

## 🌐 API Gateway

- Développée en **Node.js (Express.js)**  
- Route les requêtes vers les bons microservices  
- Gère les erreurs et la centralisation des endpoints

## 🛠️ Technologies & Outils

- **Langages** : Java, JavaScript
- **Frameworks** : Spring Boot, Express.js
- **Bases de données** : MySQL (données relationnelles), MongoDB 
- **Outils de test** : Postman
- **Environnement** : Docker (pour l’orchestration locale possible)

## 📊 Fonctionnalités Clés

- Création et gestion des patients et medecins
- Prise de rendez-vous
- Gestion des disponibilités
- Communication inter-services via REST

## 👥 Travail en Équipe

- Répartition claire des microservices entre les membres de l’équipe
- Intégration finale à travers l’API Gateway
- Tests d’intégration avec des jeux de données réels


---

