# Sentence converter (CSV, XML)

Application for converting plain text into CSV and XML format. Input text is divided into sentences, sentences into
words, then saved to specified format. Aim of this program is to handle large files which may exceed heap memory. Whole
application was written in TDD technique.

* Technologies: Junit4, JAXB, Maven

## Prerequisites

### Java

You need Java SE 8-13.

### Maven

You don't need to install Maven. Simply use the attached `mvnw` ([Maven Wrapper]), e.g. `./mvnw test`.

[Maven Wrapper]: https://github.com/takari/maven-wrapper
### Wykonał Paweł Drelich grupa ININ4_PR1.1 indeks 54589

##### Jest to ulepszona/zmieniona/dostosowana do zaliczenia wersja programu jaki napisałem wcześniej, a dostepnego pod adresem: [SentenceConverter]

[SentenceConverter]: https://github.com/Cutter72/SentenceConverter
* Przedmiot: Programowanie w języku Java
* Prowadzący: mgr inż. Kacper Warda

##### W celu przetestowania aplikacji można użyć dołączonych plików `small.in` lub `large.in` z folderu `src/main/resources/sample_data/`