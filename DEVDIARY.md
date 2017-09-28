# Development Diary
Each entry into this diary will contain the choice being made, the type of choice being made (e.g. architecture, technology, implementation) and a rationale for making the choice.

## Briefing 1 - The simplest possible game

| Choice | Type        | Rationale |
| ------ | ----------- | --------- |
| Gradle build system | Technology | Gradle can be shipped as part of a project, making it easier for others to build the project. Leveraging the Maven dependency management allows Gradle projects to resolve dependencies, without needing to ship binaries with a project. |
| FXGL game engine | Technology | FXGL offers a lot of the building blocks of a game engine with a simple API. FXGL is tightly coupled to JavaFX, which may make it difficult to change this decision in the future! | 
| Travis-CI continuous integration | Technology | Simple CI system, free to use and integrated nicely into Github. |