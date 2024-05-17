Restfull API mit Spring Boot

In diesem Projekt existiert keine Datenbank.
Dafür wird widerwillig fiktives Objekt in CustomerServices.class verwendet.

-   Kunden Microservices
-   RestController mit Spring Boot Implementierung
    *   GET    Methode für das Laden von Kundenlisten
    *   GET    Methode für das Laden eines einzelnen Kunden
    *   POST   Methode für das Speichern von neuen Kunden
    *   DELETE Methode für das Löschen von bestehenden Kunden
-   ExceptionHandling für Rest API
    *   Http Statuscode
    *   NotFound Exception
    *   ServiceException Handler
    *   Conflict Exception
-   JUnit Test
    *   Mock Klasse erstellen für Controller
    *   Test für Controller GET Methode
