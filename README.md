WebSockets :
Les WebSockets sont un protocole qui permet d'établir une communication bidirectionnelle et
full duplex entre un client et un serveur via une seule connexion TCP. Ce protocole est particulièrement adapté
pour les applications Web nécessitant une communication en temps réel, car il permet d'échanger des données de manière
continue sans avoir besoin de recharger la page ou d'effectuer des requêtes répétées. Dans le contexte de Spring Boot,
les WebSockets facilitent l'implémentation de fonctionnalités comme le chat en temps réel ou les notifications instantanées.
web

WebFlux :
Spring WebFlux est un framework Web réactif et non bloquant qui utilise l'API de flux réactifs de Project Reactor pour permettre 
un traitement hautement simultané et asynchrone des requêtes Web de manière non bloquante et pilotée par les événements.
Spring WebFlux est un framework réactif et non bloquant de Spring Framework 5, conçu pour créer des applications web modernes et 
évolutives en Java. Il permet de gérer des requêtes et des réponses de manière asynchrone, utilisant des flux réactifs pour optimiser 
les performances et la scalabilité des applications.

Principales fonctionnalités de Spring WebFlux
E/S non bloquantes : utilise des E/S asynchrones et non bloquantes pour éviter le blocage des threads, permettant ainsi une concurrence élevée.
Prise en charge des flux réactifs : implémente entièrement la spécification Reactive Streams à l'aide de Project Reactor pour la programmation réactive.
Modèle de programmation fonctionnel : les contrôleurs renvoient les éditeurs Mono/Flux au lieu de bloquer les réponses, privilégiant le style fonctionnel.
Événements envoyés par le serveur : prend en charge les événements envoyés par le serveur prêts à l'emploi pour une communication duplex intégral en temps réel.
WebSockets : prise en charge intégrée des WebSockets pour permettre une communication bidirectionnelle en temps réel.
Accès réactif à la base de données : intégration transparente avec des bases de données réactives comme MongoDB, Cassandra, Redis, etc.
Prise en charge de la mise en cache : prend en charge la mise en cache des réponses à l'aide de l'API Cache de manière non bloquante.

Principes fondamentaux de Spring WebFlux
Opérations asynchrones : toutes les opérations d'E/S telles que l'accès à la base de données, les appels réseau, etc. sont asynchrones et non bloquantes. Cela empêche les threads de se bloquer lors des E/S.
Flux réactifs : les données sont traitées et consommées de manière asynchrone sous forme de flux de valeurs multiples au fil du temps plutôt que sous forme de réponses de blocage uniques.
Conformité aux flux réactifs : WebFlux est basé sur Project Reactor qui implémente les flux réactifs. Cela permet un traitement asynchrone et non bloquant des flux de données.
Requêtes non bloquantes : le serveur sous-jacent (Netty par défaut) est entièrement asynchrone et non bloquant. Il peut gérer beaucoup plus de requêtes simultanément sans bloquer les threads.

Voici une description textuelle d’un schéma simple :

Client Browser
|
| (WebSocket Request: ws://server)
v
WebSocket Protocol (Persistent Connection)
|
| (Real-time Data Exchange)
v
Spring WebFlux Server
|
| (Reactive Processing using Mono/Flux)
v
Application Logic
Ce schéma montre le navigateur client qui initie une requête WebSocket vers le serveur. Une fois la connexion WebSocket établie, 
le protocole permet une communication bidirectionnelle entre le client et le serveur. Spring WebFlux gère ces communications de 
manière réactive avant de transmettre les données à la logique applicative.


Synchronous and asynchronous programming are two fundamental concepts in Java, and they refer to how tasks are executed in a program.

1. **Synchronous Programming:**
   — In synchronous programming, tasks are executed one after the other, in a sequential and blocking manner.
   — When a function or method is called, the program waits for that function to complete before moving on to the next one.
   — It follows a straightforward and predictable flow, but it may lead to inefficiencies if one operation takes a long time, as it can block the execution of subsequent tasks.

Example of synchronous code:

```java
public void synchronousExample() {
System.out.println("Task 1”);
System.out.println("Task 2”);
System.out.println("Task 3”);
}
```

2. **Asynchronous Programming:**
   — In asynchronous programming, tasks are executed independently, and the program doesn’t wait for a task to complete before moving on to the next one.
   — Asynchronous operations are often handled using callbacks, promises, or Java’s CompletableFuture for more modern applications.
   — This approach is particularly useful for I/O-bound operations or tasks that might take a variable amount of time to complete.

Example of asynchronous code using CompletableFuture:

```java
import java.util.concurrent.CompletableFuture;

public class AsynchronousExample {
public static void main(String[] args) {
CompletableFuture.runAsync(() -> {
System.out.println("Task 1”);
});

CompletableFuture.runAsync(() -> {
System.out.println("Task 2”);
});

CompletableFuture.runAsync(() -> {
System.out.println("Task 3”);
});

// The program doesn’t wait for the tasks to complete.
}
}
```