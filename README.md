# Android at scale example
An example/template/framework for building Android applications at scale.

This example will contain some ideas practices, tools, libraries, frameworks, proposed practices, ... for buildings large mantainable, stable, scalable apps that will support variety or markets, and platforms.

When you build an application for billion users it mist be maintainable and scalable. The code/implementation is not the only goal and objective. The testability, scalability, reusability and build process become gain a lot of weight. 

This is an example, not an example of how can you achieve this. It is not a silver bullet and will definitely not solve all of the problems but it might give some ideas on how to solve some. 

Some topics that I will try to cover.
Building at scale CI/CD for large-scale application that needs to support different stores, platforms and of course can be easily scalable to multiple apps (Jenkins, Gradle, ...)
Verification and testing process to keep the code maintainable and to find bugs as soon as possible (Custom lint rules, SonarQube, unit and integration testing, automation testing, artifact verification
How to use popular tools while keeping in mind other platforms and systems (Firebase, Google Play services, force updates, push...)
Building and testing are only the first steps. Integration, documentation, informing other teams, ... is as important as the product if not more.
Ensuring API consistency between different platforms (iOS-Android) and different systems (client-backend)


## Use buildSrc to abstract imperative logic
https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources 
Complex build logic is usually a good candidate for being encapsulated either as custom task or binary plugin. Custom task and plugin implementations should not live in the build script. It is very convenient to use buildSrc for that purpose as long as the code does not need to be shared among multiple, independent projects.

The directory buildSrc is treated as an included build. Upon discovery of the directory, Gradle automatically compiles and tests this code and puts it in the classpath of your build script. For multi-project builds there can be only one buildSrc directory, which has to sit in the root project directory. buildSrc should be preferred over script plugins as it is easier to maintain, refactor and test the code.

buildSrc uses the same source code conventions applicable to Java and Groovy projects. It also provides direct access to the Gradle API. Additional dependencies can be declared in a dedicated build.gradle under buildSrc.

Example: https://proandroiddev.com/migrate-to-gradle-kotlin-dsl-in-4-steps-f3e3b27e1f4d