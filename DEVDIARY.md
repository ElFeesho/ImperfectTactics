# Development Diary
Each entry into this diary will contain the choice being made, the type of choice being made (e.g. architecture, technology, implementation) and a rationale for making the choice.

## Briefing 1 - The simplest possible game

| Choice | Type        | Rationale |
| ------ | ----------- | --------- |
| Kotlin Programming language | Technology | Kotlin can be compiled to JVM bytecode, transpiled to JavaScript, compiled to native code and even distributed in 'common' mode, allowing it to be used in any of the previously mentioned configurations. Kotlin is quite terse but offers a nice amount of flexibility with minimal performance overhead. |
| Gradle build system | Technology | Gradle can be shipped as part of a project, making it easier for others to build the project. Leveraging the Maven dependency management allows Gradle projects to resolve dependencies, without needing to ship binaries with a project. |
| FXGL game engine | Technology | FXGL offers a lot of the building blocks of a game engine with a simple API. FXGL is tightly coupled to JavaFX, which may make it difficult to change this decision in the future! | 
| Travis-CI continuous integration | Technology | Simple CI system, free to use and integrated nicely into Github. |
| `GameMap` model | Architecture | The GameMap is composed of `GameTile` instances. A `GameTile` can currently represent anything. The `GameMap` has separate collections for each actual kind of element (e.g. tiles, buildings.) The `GameMap` will likely start to encapsulate game logic around which pieces can move where and when. |