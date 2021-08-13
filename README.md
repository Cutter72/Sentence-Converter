# Sentence converter (CSV, XML)

Program for converting plain text into CSV and XML format. Input text is divided into sentences, sentences into words, then
saved to CSV and XML format. Aim of this program is to show how large files could be handled when 
heap memory may exceed. Program was written in TDD technique.
* Technologies: Junit4, JAXB, Maven, CSV, XML, Git

#### Launcher: `src/main/java/pl/project/Main.java`.

#### For test program functionality, you can use delivered samples `small.in` or `large.in` from the path `src/main/resources/sample_data/`

## Prerequisites

### Java

You need Java SE 8-13.

### Maven

You don't need to install Maven. Simply use the attached `mvnw` ([Maven Wrapper]), e.g. `./mvnw test`.

[Maven Wrapper]: https://github.com/takari/maven-wrapper
