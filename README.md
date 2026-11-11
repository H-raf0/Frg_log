# Frg_log: Continuous Integration with GitLab CI, JaCoCo & SonarCloud

A small **Spring Boot / Maven** project used as a sandbox for a full **continuous integration pipeline**. Each push compiles the project, runs the unit tests, measures code coverage, sends the code to SonarCloud for analysis, and packages the application as a JAR.

The project was originally hosted on the ISIMA GitLab instance and is mirrored here.

## Tech stack

| Area | Tools |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.5.6 |
| Build & dependencies | Maven (with the Maven Wrapper `mvnw`) |
| Tests | JUnit 5 (`spring-boot-starter-test`) |
| Coverage | JaCoCo 0.8.11 |
| Code quality | SonarCloud (`sonar-maven-plugin`) |
| CI/CD | GitLab CI (`.gitlab-ci.yml`) |

## The application

The business logic is a single method, `Application.calcIndemnite(int nbKm)`. It computes a **mileage allowance** based on the distance travelled, using rate bands:

| Distance band | Rate |
|---|---|
| First 9 km | 1.50 per km |
| Next 39 km (10 → 48) | 0.40 per km |
| Next 59 km (49 → 107) | 0.55 per km |
| Beyond 107 km | 6.81 per 20 km block (pro-rated) |

Negative or zero distances give an allowance of `0`.

`ApplicationTests` covers simple cases, every band boundary (9, 39, 40, 59, 60, 61, 80, 81 km…), the last band, negative input, and `main`.

## CI pipeline

The pipeline has four stages and runs in the `maven:3.8.5-openjdk-17` image:

```
build  ──►  test  ──►  sonar  ──►  package
```

| Stage | Job | What it does |
|---|---|---|
| `build` | `compilation` | `./mvnw compile` |
| `test` | `validation` | `./mvnw test`. Publishes JUnit reports, extracts the total coverage from the JaCoCo report for the GitLab coverage badge, and keeps `jacoco.xml` for Sonar. |
| `sonar` | `sonar_scan` | `./mvnw sonar:sonar` against SonarCloud (only on `main`, authenticated with the `SONAR_TOKEN` CI variable) |
| `package` | `packaging` | `./mvnw package`. Publishes `target/*.jar` as a pipeline artifact. |

The pipeline caches Maven dependencies between jobs (`.m2/repository`). It uses `GIT_DEPTH: 0` so that SonarCloud gets the full git history.

## Getting started

**Requirements:** JDK 17. Maven itself is not needed because the wrapper downloads it.

```bash
git clone https://github.com/H-raf0/Frg_log.git
```

```bash
cd Frg_log
```

Compile:

```bash
./mvnw compile
```

Run the tests and generate the coverage report:

```bash
./mvnw test
```

Package the executable JAR:

```bash
./mvnw package
```

Run the application:

```bash
java -jar target/TP3.ABDELLAOUI_EL-ALLALI-0.0.1-SNAPSHOT.jar
```

On Windows, use `mvnw.cmd` instead of `./mvnw`.

When the application starts, it logs the allowance for a few sample distances (5, 10, 20, 50 and 100 km).

The coverage report is written to `target/site/jacoco/index.html`.

### SonarCloud analysis (optional)

```bash
./mvnw sonar:sonar -Dsonar.token=<YOUR_SONAR_TOKEN>
```

The organisation and project key are set in `pom.xml`.

## Project structure

```
.
├── .gitlab-ci.yml                     # CI pipeline definition
├── pom.xml                            # Maven config: Spring Boot, JaCoCo, Sonar
├── mvnw / mvnw.cmd / .mvn/            # Maven Wrapper
├── src
│   ├── main
│   │   ├── java/isima/F2/TP3/ABDELLAOUI_EL_ALLALI/Application.java
│   │   └── resources/application.properties
│   └── test
│       └── java/isima/F2/TP3/ABDELLAOUI_EL_ALLALI/ApplicationTests.java
├── docs/compte-rendu-TP3.md           # Full lab report (in French)
└── License
```

## Lab report

The full step-by-step report is in [`docs/compte-rendu-TP3.md`](docs/compte-rendu-TP3.md), in French. It covers Maven conventions, dependency management, the build lifecycle, setting up GitLab CI, the coverage badge, JaCoCo and SonarCloud.

## Authors

- **Achraf EL ALLALI**
- **Wiam ABDELLAOUI**

ISIMA, second year: Software Forge (*Forge logicielle*) lab.

## License

Distributed under the **Apache License 2.0**. See [`License`](License).
