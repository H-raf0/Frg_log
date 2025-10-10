# Infos étudiant :

Par binôme Nom Prénom:
 * EL ALLALI achraf
 * ABDELLAOUI wiam 

[le pourcentage de couverture de code est: ](https://gitlab.isima.fr/forges_wiam_achraf/frg_log/badges/main/coverage.svg)

# TP 3

Le but de ce TP est de mettre en place un processus d'intégration continue en se basant sur le projet précédent.

## 1 Création d'un espace projet dédié sous gitlab
1. Pour mettre en place une chaine d'intégration continue initialisez un nouveau projet sous [GitLab](https://gitlab.isima.fr).
1. Ajouter dans la liste des développeurs votre binôme. (Settings/Members)
1. Ajouter en reporter `tjouve` & `iia_samorel`.
1. Ajoutez ce compte rendu comme readme de votre projet.
    * Vous pouvez le faire directement depuis l'interface avec *new File*
    * Copier le code markdown, il est possible d'editer le document via l'interface web directement sur gitlab
    * **Renseignez vos noms en haut du compte rendu**
1. Ajoutez une licence pour indiquer sous quels termes votre production est disponible
    * Cliquez sur **Add License**, il est possible de rédiger soi-même le contenu, ou de selectionner une licence existante (Apache, MIT, GNU ...). Le site [choose a license](https://choosealicense.com/licenses/) propose un comparatif entre les différentes liences les plus courantes.


## 2 Initialisation du projet
Pour prendre en charge la gestion des dépendances et l'automatisation de la construction de l'application nous utiliserons `Maven`.
Pour démarrer rapidement le projet nous allons faire du *scaffolding*. Pour ce faire nous utiliserons [Spring Boot](https://projects.spring.io/spring-boot/). Et plus particuliérement [Spring initializr](https://start.spring.io/). 

### 2.1 Spring Initializer (Optionel)
1. Créer un squelette d'application avec [Spring initializr](https://start.spring.io/) :
    1. choisissez comme groupe id **isima.F2**
    2. comme nom d'artefact vous saisirez **TP3.`nom binome`** 
    3. téléchargez ce template de projet.
1. clonez votre nouveau projet localement
    1. dézippez l'archive dans votre repo local, ce dernier ne devrait contenir que l'arborescence des sources, le pom et votre readme
    1. commitez et pushez sur le serveur


### 2.2 Utilisation de maven
Avant de reporter le code du TP2 nous allons nous familiariser avec *Maven*

#### 2.2.1 Convention over configuration
Pour permettre de développer plus rapidement des applications une bonne pratique est de respecter certaines normes.

Dans notre cas en utilisant **Spring Initializer** nous avons rapidement généré un squelette d'application utilisant maven et fournissant un certain nombre de fonctionnalitées transverses.
Notamment un framework de test **JUnit** et un framework de logging **Logback**


* A quoi correspondent les fichiers présents dans le zip ? 
    * pom.xml
    * .gitignore
    * décrire l'arborescence de répertoire
            
* **RÉPONSE:** 
    * **pom.xml** : nous permet d'ajouter les dépondence dont on a besion.
    * **.gitignore** : sert à indiquer à Git quels fichiers ou dossiers il doit ignorer dans le dépôt.
    * **src/main/java** : contient le code source Java de l’application.
    * **src/main/resources** : contient les fichiers de configuration et ressources qui seront inclus dans le classpath.
    * **src/test/java** : contient les classes de tests (par convention, même package que la classe testée).
    * **target/** : C’est un dossier “de build” où tout ce que Maven génère est mis là-dedans.
#### 2.2.2 Gestion des dépendances 

Dans le nouveau projet on retrouve une classe *Application.java* sous *src/main/java* dans le package *isima.F2.TP3.`nom binome`*
* Dans cette classe créez un logger et loggez un `Hello Word` en *warning*

```java
private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
    logger.warn("Hello Word");

}
```

* Exécutez votre programme

**RÉPONSE:**
```
C:\Users\Achraf\Desktop\School\frg_log>mvnw.cmd spring-boot:run
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< isima.F2:TP3.ABDELLAOUI_EL-ALLALI >------------------
[INFO] Building TP3.ABDELLAOUI_EL-ALLALI 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] >>> spring-boot:3.5.6:run (default-cli) > test-compile @ TP3.ABDELLAOUI_EL-ALLALI >>>
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO]
[INFO] --- compiler:3.14.0:compile (default-compile) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] skip non existing resourceDirectory C:\Users\Achraf\Desktop\School\frg_log\src\test\resources
[INFO]
[INFO] --- compiler:3.14.0:testCompile (default-testCompile) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Nothing to compile - all classes are up to date.
[INFO]
[INFO] <<< spring-boot:3.5.6:run (default-cli) < test-compile @ TP3.ABDELLAOUI_EL-ALLALI <<<
[INFO]
[INFO]
[INFO] --- spring-boot:3.5.6:run (default-cli) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.6)

2025-10-02T19:08:32.818+02:00  INFO 16140 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.ABDELLAOUI_EL_ALLALI.Application   : Starting Application using Java 17.0.14 with PID 16140 (C:\Users\Achraf\Desktop\School\frg_log\target\classes started by Achraf in C:\Users\Achraf\Desktop\School\frg_log)
2025-10-02T19:08:32.833+02:00  INFO 16140 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.ABDELLAOUI_EL_ALLALI.Application   : No active profile set, falling back to 1 default profile: "default"
2025-10-02T19:08:33.489+02:00  INFO 16140 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.ABDELLAOUI_EL_ALLALI.Application   : Started Application in 1.39 seconds (process running for 1.868)
2025-10-02T19:08:33.489+02:00  WARN 16140 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.ABDELLAOUI_EL_ALLALI.Application   : Hello Word
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.861 s
[INFO] Finished at: 2025-10-02T19:08:33+02:00
[INFO] ------------------------------------------------------------------------
```

Vous remarquerez qu'il n'est pas nécessaire d'ajouter la dépendance vers un logger (ici *logback*). C'est une dépendance classique d'un projet java. Elle est déjà présente dans le pom de *spring boot*.

Pour illustrer la gestion des dépendances automatiques vous ajouterez une dépendance vers la librairie **commons-lang3** de **apache**
* Ajout de la dépendance *Apache commons lang3*
    * Pour ce faire recherche `commons-lang3` sur [MVNrepository](https://mvnrepository.com).
    * selectionnez la derniére version
    * copiez la déclaration et collez là dans votre *pom.xml*
    * Décrivrez rapidement le fonctionnement de la résolution de dépendance
 
**RÉPONSE:**

Maven lit ton pom.xml et récupère toutes les librairies déclarées dans **<dependencies>** depuis un repository central.

* Utilisez la classe utilitaire `StringUtils` et sa méthode `reverse` pour afficher dans la log au niveau *debug* vos noms à la suite du Hello Word.
    * La ligne de log n'apparait pas dans la console car le niveau de trace par defaut est `WARN`.
    * [Spring boot logging](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html) indique comment changer le niveau de trace. (Il n'est pas nécessaire d'ajouter la dépendance elle est déjà présente).
    * Un fois le niveau de trace par defaut changé vous devriez voir le résultat de votre commande.
    * Quel fichier de configuration est modifié ? 

**RÉPONSE:**

le fichier **application.properties**

#### 2.2.3 Gestion du cycle de vie

Dans cette partie nous allons utiliser les commandes de build de manven. Ces commandes permettentent d'automatiser certaines taches.
[Maven Lyfe Cycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html) décrit l'ensemble des instructions et l'enchainement des différentes phases de **Maven**.

L'archive générée via spring initializer contient un répertoire `.mvn` et 2 scripts `mvnw` et `mvnw.bat`. Le projet contient par defaut un *wrapper* qui permet d'avoir une installation locale de maven pour ne pas être dépendant du systéme sur lequel on développe.

Il est possible de lancer directement des taches maven en appellant le script (`mvnw` pour *linux* et `mvnw.bat` pour *windows* ). 

Par example `./mvnw.bat clean` permet de supprimer les classes compilées dans le repertoire target.

En utilisant la ligne de commande nous allons compiler, tester et packager l'application sous la forme d'un jar.

##### 2.2.3.1 Compilation
* Quelle est la commande à lancer pour compiler l'application ?
* Quelle est la commande à lancer pour compiler & éxécuter les tests ?
* Quel sont les fichiers / répertoires générés par cette commande ?

**RÉPONSE:**

* Commande pour compiler l'application :
    * sous linux
        ```bash
        ./mvnw compile
        ```
    * sous windows
        il suffit de remplacer `./mvnw` par `mvnw.cmd`.

* Commande pour compiler & éxécuter les tests :
    ```bash
    ./mvnw test
    ```
* les fichiers / répertoires générés sont
    * **classes/**
    * **generated-sources/**
    * **generated-test-sources/**
    * **maven-status/**
    * **surefire-reports/**
    * **test-classes/**

    
##### 2.2.3.2 Packaging
* Quelle est la commande à lancer ?
* Quel sont les fichiers / répertoires générés par cette commande ?

**RÉPONSE:**

* **Commande à lancer :** `./mvnw package`
* **Fichiers / répertoires générés : target/**
    *   **classes/** – classes compilées
    *   **generated-sources/** – sources générées
    *   **generated-test-sources/** – sources de test générées
    *   **maven-archiver/** – métadonnées du build Maven
    *   **maven-status/** – statut de compilation
    *   **surefire-reports/** – rapports des tests
    *   **test-classes/** – classes de test compilées
    *   **TP3.ABDELLAOUI_EL-ALLALI-0.0.1-SNAPSHOT.jar** – fichier JAR exécutable
    *   **TP3.ABDELLAOUI_EL-ALLALI-0.0.1-SNAPSHOT.original** – fichier original du build
      
    
### 2.3 Reportez le code du TP2           
* Reportez vos classes d'implémentation et de test dans le nouveau projet
    * Votre implémentation dans le repertoire src/main/java/*pakcage_name*/*Application
    * Votre classe de test dans le repertoire src/test/java/*pakcage_name*/*ApplicationTests
* Effectuez le packaging de votre application pour lancer la compilation et les tests.

**RÉPONSE:**

```
C:\Users\Achraf\Desktop\School\frg_log>mvnw.cmd clean package
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< isima.F2:TP3.ABDELLAOUI_EL-ALLALI >------------------
[INFO] Building TP3.ABDELLAOUI_EL-ALLALI 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.4.1:clean (default-clean) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Deleting C:\Users\Achraf\Desktop\School\frg_log\target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO]
[INFO] --- compiler:3.14.0:compile (default-compile) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug parameters release 17] to target\classes
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] skip non existing resourceDirectory C:\Users\Achraf\Desktop\School\frg_log\src\test\resources
[INFO]
[INFO] --- compiler:3.14.0:testCompile (default-testCompile) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug parameters release 17] to target\test-classes
[INFO]
[INFO] --- surefire:3.5.4:test (default-test) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running isima.F2.TP3.ABDELLAOUI_EL_ALLALI.ApplicationTests
14:07:13.307 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [isima.F2.TP3.ABDELLAOUI_EL_ALLALI.ApplicationTests]: ApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
14:07:13.475 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration isima.F2.TP3.ABDELLAOUI_EL_ALLALI.Application for test class isima.F2.TP3.ABDELLAOUI_EL_ALLALI.ApplicationTests

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.6)

2025-10-03T14:07:14.827+02:00  INFO 4704 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.A.ApplicationTests                 : Starting ApplicationTests using Java 17.0.14 with PID 4704 (started by Achraf in C:\Users\Achraf\Desktop\School\frg_log)
2025-10-03T14:07:14.827+02:00  INFO 4704 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.A.ApplicationTests                 : No active profile set, falling back to 1 default profile: "default"
2025-10-03T14:07:15.992+02:00  INFO 4704 --- [TP3.ABDELLAOUI_EL-ALLALI] [           main] i.F.T.A.ApplicationTests                 : Started ApplicationTests in 1.996 seconds (process running for 4.374)
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.884 s -- in isima.F2.TP3.ABDELLAOUI_EL_ALLALI.ApplicationTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.4.2:jar (default-jar) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Building jar: C:\Users\Achraf\Desktop\School\frg_log\target\TP3.ABDELLAOUI_EL-ALLALI-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot:3.5.6:repackage (repackage) @ TP3.ABDELLAOUI_EL-ALLALI ---
[INFO] Replacing main artifact C:\Users\Achraf\Desktop\School\frg_log\target\TP3.ABDELLAOUI_EL-ALLALI-0.0.1-SNAPSHOT.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to C:\Users\Achraf\Desktop\School\frg_log\target\TP3.ABDELLAOUI_EL-ALLALI-0.0.1-SNAPSHOT.jar.original
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  13.259 s
[INFO] Finished at: 2025-10-03T14:07:20+02:00
[INFO] ------------------------------------------------------------------------
```

## 3 Intégration continue

Gitlab permet de faire de l'intégration continue sur votre code.
Nous allons mettre en place un job permettant de réaliser la compilation,les test et le packaging à chaque commit en utilisant [Gitlab CI](https://about.gitlab.com/features/gitlab-ci-cd/)

### 3.1 Mettre en place une intégration continue en utilisant gitlab-ci

Liens utiles:
* [Gitlab CI](https://docs.gitlab.com/ce/ci/yaml/README.html#gitlab-ci-yml)

Sur la page d'acceuil de votre projet, à coté du bouton pour ajouter une licence, il y a un acces rapide pour créer à partir d'un template un fichier `.gitlab-ci.yml`.
On utilisera un template maven pour initialiser le descriptif des actions à réaliser.

* Désormais dans la partie CI/CD de votre projet vous pouvez voir vos pipelines en cours d'éxécution ou passé et leurs status.
* Le yml par defaut devrait faire echouer votre pipeline.
* Quelles est l'erreur ?

**RÉPONSE:**

    deploy:jdk8  

* Le script template proposé par defaut est relativement complexe.
* Pour la suite nous utiliserons le template suivant : 

```yaml
variables:
  # This will supress any download for dependencies and plugins or upload messages which would clutter the console log.
  # `showDateTime` will show the passed time in milliseconds. You need to specify `--batch-mode` to make this work.
  MAVEN_OPTS: "-Dmaven.repo.local=.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true"
  # As of Maven 3.3.0 instead of this you may define these options in `.mvn/maven.config` so the same config is used
  # when running from the command line.
  # `installAtEnd` and `deployAtEnd` are only effective with recent version of the corresponding plugins.
  MAVEN_CLI_OPTS: "--batch-mode --errors --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true"

# Cache downloaded dependencies and plugins between builds.
# To keep cache across branches add 'key: "$CI_JOB_REF_NAME"'
cache:
  paths:
    - .m2/repository

#Definition des différentes étapes présent dans le pipeline
stages:
  - build
  - test

#Définition du job de compilation
compilation:
  image: maven:3.3.9-jdk-8
  stage: build
  script:
    - echo "A Completer";exit 1


validation:
  image: maven:3.3.9-jdk-8
  stage: test
  script:
      - echo "A Completer";exit 1
```
 
* Remplacez le `.gitlab-ci.yml` par celui-ci et completez le avec les commandes maven précédement utilisées pour réaliser la phase de build et de test

* Completez le `.gitlab-ci.yml` pour inclure un nouveau stage de packaging qui vas construire le jar de votre application

`Quels sont les lignes que vous avez rajouté dans votre déclaration de pipeline ?`  

**RÉPONSE:** 

* `- package` dans `stage:` 
* `- ./mvnw $MAVEN_CLI_OPTS compile`
* `- ./mvnw $MAVEN_CLI_OPTS test`
 
*   ```
        packaging:
        image: maven:3.3.9-jdk-8
        stage: package
        script:
            - ./mvnw $MAVEN_CLI_OPTS package
        artifacts:
            paths:
            - target/*.jar
    ```
* et aussi la version du jdk de `maven:3.3.9-jdk-8` à `maven:3.9.11-jdk-17`
#### 3.1.1 Badge

**Gilab** permet d'afficher dans votre readme le status de votre pipeline dynamiquement pour celà : 
* Rendez vous dans la partie [Settings > CI/CD > General pipelines settings](https://docs.gitlab.com/ee/user/project/pipelines/settings.html) de votre projet. A l'aide de la documentation sur les [badges](https://docs.gitlab.com/ee/user/project/pipelines/settings.html#badges) 
rajoutez un bdage indiquant le status de votre pipeline de build dans votre readme.

**Réponse**

[Badge](https://gitlab.isima.fr/forges_wiam_achraf/frg_log/-/commits/main) 
### 3.2 Couverture de code 

Nous allons ajouter un outil permettant de réaliser des statistiques sur la qualité des tests. Il sagit ici de [jacoco](http://www.eclemma.org/jacoco/) une librairie permettant de réaliser des statistiques sur le taux de couverture de code par les tests unitaires.

* Ce plugin lors de la compilation vas modifier votre code pour injecter du code permettant de savoir quelles lignes sont exécutées ou non.
    * Pour ce faire il faut rajouter dans votre **pom.xml**, dans la partie *build/pulgins*, la déclaration suivante :

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.0</version>
    <executions>
        <execution>
            <id>default-prepare-agent</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

* Nous allons rajouter au readme du projet un badge indiquant le % de code couvert.
    * Sur gitlab, dans les settings de la partie CI/CD dans General pipeline settings, vous trouverez une zone de saisie pour **Test coverage parsing**.
En effet il est nécessaire d'indiquer à **Gitlab CI** où trouver l'information sur le pourcentage de code couvert : `A regular expression that will be used to find the test coverage output in the job trace.`
    * Cette information se trouve dans le rapport généré par jacoco. Par defaut le rapport n'est pas généré. Il faut donc modifier le paramètrage du plugin pour lui demander de générer le rapport. 
Dans le code suivant on indique au plugin qu'il doit exécuter sa tache **report** lorsque de la phase **test** de maven.   

```xml
<execution>
    <id>default-report</id>
    <phase>test</phase>
    <goals>
        <goal>report</goal>
    </goals>
</execution>
```

* Le rapport est généré dans le repertoire target/site/jacoco sous la forme d'un fichier html.
    * Il faut dans la partie settings de votre CI indiquer l'expression réguliére permettant de retrouver le % de code couvert. Utilisez `Total.*?([0-9]{1,3})%`.
    * Ajoutez à votre `.gitlab-ci.yml` la commande permettant de faire apparaitre le contenu de ce fichier dans la log de votre job.
    
`Comment affichez vous l'information dans la log du job ?`

**Réponse**

```
validation:
  image: maven:3.8.5-openjdk-17
  stage: test
  script:
    # Exécuter les tests avec JaCoCo
    - ./mvnw $MAVEN_CLI_OPTS clean test
    # Extraire le pourcentage de couverture depuis le fichier HTML
    - COVERAGE=$(grep -Po 'Total.*?([0-9]{1,3})%' target/site/jacoco/index.html | grep -Po '[0-9]{1,3}' | tail -1)
    - echo "Total $COVERAGE%"
  coverage: '/Total.*?([0-9]{1,3})%/'
```


* Rajoutez en début de votre readme le badge indiquant le pourcentage de couverture de code.

### 3.3 Analyse de code avec Sonar
Nous allons mettre en place à chaque éxécution de notre pipeline une analyse sonar.

Le serveur sonar à utiliser se trouve à l'adresse suivante : [Sonar Cloud](https://sonarcloud.io)
Il faut créer un compte puis définit un token qui vas  être utilisé par vos scripts de CI pour éxécuté une analyse

* à la suite de la phase de test ajoutez dans votre job une analyse Sonar.
* Pour exécuter une analyse sonar il suffit de lancer la commande : 

```
mvn sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=TOKEN
```

* Généré un token pour votre user est utilisez votre token.
* Une fois la première analyse lancée, rendez vous sur l'application pour constater quels sont les anomalies détectées et les indicateurs de qualimétrie de votre code.
* Corrigez votre code en conséquence pour obtenir la meilleur note possible.
* Il est possible de spécifier directement dans le pom.xml l'adresse du serveur cible
    * pour ce faire on ajoutera dans la balise properties une entrée tel que : 
    
    ```xml
    <sonar.host.url>https://sonarcloud.io</sonar.host.url>
    ```
    * on peux alors appeler directement `mvn sonar:sonar -Dsonar.login=TOKEN` l'URL du serveur est prise dans les properties de votre projet maven
    
* Pour le login il est possible de faire de même, mais en terme de sécurité ce n'est pas une bonne idée d'indiquer le token d'acces dans vos sources
    * Gitlab-ci permet d'injecter de manière caché certaines propriétés [secret variables](https://gitlab.isima.fr/help/ci/variables/README#secret-variables)
    * Définissez une variable secrete contenant le login et utilisez la dans votre .gitlab-ci.yml   


