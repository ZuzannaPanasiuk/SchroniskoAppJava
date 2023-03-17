# SchroniskoAppJava
--PL--

Projekt applikacji webowej wspomagającej korzystanie z bazy danych potencjalnego Schroniska dla zwierząt. Aplikacja zrobiona na potrzeby przedmiotu Projektowanie Aplikacji Webowych, stworzony w frameworku Spring języka Java oraz oparty o bazę danych utworzoną w PostgreSQL.

*Uwaga* - pliki przedstawione poniżej nie zawierają prawdziwych danych do logowania, niezbędnych do odtworzenia tego projektu, w związku z czym, aplikacja nie działa. Siostrzaną aplikacją jest aplikacja SchroniskoAppPHP, której działanie można zobaczyć pod linkiem: https://foka.umg.edu.pl/~s47549/schronisko/schronisko/public/domowa

Baza zawiera tabele:</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Zwierzeta - opisuje zwierzęta znajdujące się w schronisku;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Klienci - opisuje osoby, które decydują się na adopcję;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Wolontariusze - opisuje osoby, które udzielają się wolontaryjnie w schronisku;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Adopcje - opisuje adopcje - kto, jakie zwierze i kiedy adoptował;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Tymczas - opisuje pobyt zwierząt w domu tymczasowym - kto i jakie zwierze tymczasowo przygarnął;</br>

Aplikacja wspomaga wszystkie podstawowe operacje na bazie - edycję, dodawanie i usuwanie rekordów każdej z tabel, wraz z inteligentnym (kaskadowym) usuwaniem rekordów - usuwając klienta, usuwamy wszystkie rekordy o jego adopcjach.

</br></br>
--ANG--

Web application project supporting the administrative use of a database of an animal shelter. The application was made for Design of Web Applications classes, developed using Spring - a Java framework supported by a database made using PostgreSQL.

*Warning* - the files of in this repo don't contain the correct login nor password, that are nessesary for this app to work, therefore it doesn't work. A sibling app to this one is SchroniskoAppPHP, if you'd like to see how it looks and works, check out the link: https://foka.umg.edu.pl/~s47549/schronisko/schronisko/public/domowa

Database consists of tables:</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Zwierzeta - stores properties of animals in the shelter;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Klienci - stores information about clients who decide to adopt;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Wolontariusze - stores information about volunteers of the shelter;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Adopcje - describes adoptions - who adopted which animal and when;</br>
&nbsp;&nbsp;&nbsp;&nbsp;  Tymczas - describes the stay of an animal in the home of a volunteer - who, which animal was temporarily taken into temporary care;</br>

The app supports all basic operations with the database - editing, adding and deleting records from any table, including intelligent (cascading) deletion of records - when we delete a client, we delete all records of their previous adoptions.
