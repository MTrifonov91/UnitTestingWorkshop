# <center>Repo for Workshop on Unit testing</center>

## Contents

1. <b>[Introduction](#introduction)
2. [Repo structure](#structure)
3. [Requirements](#requirements)</b>

---

### Introduction

This workshop is intended for testers and is an introduction to the topic of "Unit Testing"
of applications written on Java language.
It covers the following subjects:
- Unit testing concepts
- Mocking and Stubbing concepts
- JUnit 5 framework
- Mockito framework
- AssertJ assertion library

This repository serves as a handy tool for the workshop, containing practical examples
to be shown during the presentation, classwork with both examples and tasks, and homework
containing only tasks. The repository contains different classes with methods serving as
"code under test" and the "test classes" for all the methods.

---

### Structure

The project is structured in the following way:
```markdown
├── presentation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── junit
│   │   │   │   ├── classwork
│   │   │   │   ├── homework
│   │   │   │   └── presentation
│   │   │   └── mockito
│   │   │       ├── classwork
│   │   │       ├── homework
│   │   │       └── presentation
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── junit
│       │   │   ├── classwork
│       │   │   ├── homework
│       │   │   └── presentation
│       │   └── mockito
│       │       ├── classwork
│       │       ├── homework
│       │       └── presentation
│       └── resources
├── .gitignore
├── pom.xml
└── README.MD
```
Presentation folder contains the presentation in .pptx format.

Main and Test packages mirror each other's structure both containing the same packages.
With Main containing classes under test and Test containing test classes for the methods
from those classes.

All the code is fully commented, especially the test classes.
All the TODOs are in Test package.
Both JUnit's and Mockito's classwork package contain examples of tests and TODO tasks for
the audience for each covered topic.
The homework package contains just the TODO tasks for the audience for each covered topic.
The presentation package contains a package for each covered topic in both JUnit and Mockito parts
of the .pptx document.

---

### Requirements

* Java 22 JDK
* Maven 3.6.3 or higher