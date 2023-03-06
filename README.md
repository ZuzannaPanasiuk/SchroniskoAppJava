--PL--

Projekt applikacji webowej wspomagającej korzystanie z bazy danych potencjalnego Schroniska dla zwierząt. Aplikacja zrobiona na potrzeby przedmiotu Projektowanie Aplikacji Webowych, stworzony w frameworku Spring języka Java oraz oparty o bazę danych utworzoną w PostgreSQL.

Baza zawiera tabele:
    Zwierzeta - opisuje zwierzęta znajdujące się w schronisku;
    Klienci - opisuje osoby, które decydują się na adopcję;
    Wolontariusze - opisuje osoby, które udzielają się wolontaryjnie w schronisku;
    Adopcje - opisuje adopcje - kto, jakie zwierze i kiedy adoptował;
    Tymczas - opisuje pobyt zwierząt w domu tymczasowym - kto i jakie zwierze tymczasowo przygarnął;

Aplikacja wspomaga wszystkie podstawowe operacje na bazie - edycję, dodawanie i usuwanie rekordów każdej z tabel, wraz z inteligentnym (kaskadowym) usuwaniem rekordów - usuwając klienta, usuwamy wszystkie rekordy o jego adopcjach.


--ANG--

Web application project supporting the administrative use of a database of an animal shelter. The application was made for Design of Web Applications classes, developed using Spring - a Java framework supported by a database made using PostgreSQL.

Database consists of tables: 
    Zwierzeta - stores properties of animals in the shelter;
    Klienci - stores information about clients who decide to adopt;
    Wolontariusze - stores information about volunteers of the shelter; 
    Adopcje - describes adoptions - who adopted which animal and when; 
    Tymczas - describes the stay of an animal in the home of a volunteer - who, which animal was temporarily taken into temporary care;

The app supports all basic operations with the database - editing, adding and deleting records from any table, including intelligent (cascading) deletion of records - when we delete a client, we delete all records of their previous adoptions.