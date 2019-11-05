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
