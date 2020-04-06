[![CircleCI][circleCiStatusBadge]][circleCiUrl]     [![GitHub release (latest SemVer)][gitHubRelease]][gitHubUrl]       [![Maintenance][isMaintained]][gitHubActivity]      [![coverage][coverageBadge]][sonarCloudUrl]     [![GitHub commit activity][gitHubActivityBadge]][gitHubUrl]     [![License: GPL v3][licenceBadge]][licenceUrl]

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


## Benchmark
Android Jetpack provides a very good library for performance testing on the device. There are very good blogs and official documentation written about this.

[Official documentation](https://developer.android.com/studio/profile/benchmark)
[A really good blog](https://tech.olx.com/android-jetpack-benchmark-json-parsers-performance-1e76031a296b) [with am accompanying github repo](https://github.com/mootazltaief/android-json-benchmark)
[A bit older but more detailed blog](https://blog.mindorks.com/improving-android-app-performance-with-benchmarking)

<!--
    Reference-style links
-->

<!-- CircleCi URL -->
[circleCiUrl]: https://circleci.com/gh/aljosamrak/android-at-scale-example
[circleCiMaster]: https://circleci.com/gh/aljosamrak/android-at-scale-example/tree/master
[circleCiDevelop]: https://circleci.com/gh/aljosamrak/android-at-scale-example/tree/develop
[circleCiMasterStatus]: https://circleci.com/gh/aljosamrak/android-at-scale-example/tree/master.svg?style=svg
[circleCiDevelopStatus]: https://circleci.com/gh/aljosamrak/android-at-scale-example/tree/develop.svg?style=svg
[circleCiStatusBadge]:  https://circleci.com/gh/aljosamrak/android-at-scale-example.svg?style=shield

<!-- GitHub URL -->
[gitHubUrl]: https://github.com/aljosamrak/android-at-scale-example
[gitHubRelease]: https://img.shields.io/github/release/aljosamrak/android-at-scale-example.js.svg?style=shield
[gitHubActivityBadge]: https://img.shields.io/github/commit-activity/m/aljosamrak/android-at-scale-example?style=shield
[gitHubActivity]: https://GitHub.com/aljosamrak/android-at-scale-example/graphs/commit-activity

<!-- Sonar Cloud URL -->
[sonarCloudUrl]: https://sonarcloud.io/dashboard?id=aljosamrak_android-at-scale-example

<!-- Badge URLs -->
[bugsBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=bugs
[codeSmellsBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=code_smells
[coverageBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=coverage
[duplicatedLinesDensityBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=duplicated_lines_density
[nclocBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=ncloc
[sqaleRatingBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=sqale_rating
[alertStatusBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=alert_status
[reliabilityRatingBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=reliability_rating
[securityRatingBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=security_rating
[sqaleIndexBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=sqale_index
[vulnerabilitiesBadge]: https://sonarcloud.io/api/project_badges/measure?project=aljosamrak_android-at-scale-example&metric=vulnerabilities

[qualityGateBadge]: https://sonarcloud.io/api/project_badges/quality_gate?project=aljosamrak_android-at-scale-example

<!--Licence references-->
[licenceUrl]: https://www.gnu.org/licenses/gpl-3.0
[licenceBadge]: https://img.shields.io/badge/License-GPLv3-blue.svg

<!--Is maintained reference-->
[isMaintained]: https://img.shields.io/badge/Maintained%3F-yes-green.svg
<!--[![Maintenance](https://img.shields.io/badge/Maintained%3F-no-red.svg)](https://bitbucket.org/lbesson/ansi-colors)-->
<!--[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/)-->