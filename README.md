[![CircleCI][circleCiStatusBadge]][circleCiUrl]     [![GitHub release (latest SemVer including pre-releases)][gitHubRelease]][gitHubReleaseUrl]       [![Maintenance][isMaintained]][gitHubActivityUrl]      [![alert_status][alertStatusBadge]][sonarCloudUrl]     [![GitHub commit activity][gitHubActivityBadge]][gitHubActivityUrl]     [![License: GPL v3][licenceBadge]][licenceUrl]      [![Website][websiteBadge]][websiteUrl]

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



### Build status
| master | develop |
|--|--|
| [![CircleCI][circleCiMasterStatus]][circleCiMaster] | [![CircleCI][circleCiDevelopStatus]][CircleCiDevelop] |
| [![TravisCI][travisCiMasterStatus]][travisCiMaster] | [![TravisCI][travisCiDevelopStatus]][travisCiDevelop] |



### Repository status

![GitHub Hacktoberfest combined status (suggestion label override)](https://img.shields.io/github/hacktoberfest/2019/aljosamrak/android-at-scale-example?logo=GitHub&style=plastic)
![GitHub issues](https://img.shields.io/github/issues/aljosamrak/android-at-scale-example?style=plastic)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/aljosamrak/android-at-scale-example.svg)](http://isitmaintained.com/project/aljosamrak/android-at-scale-example "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/aljosamrak/android-at-scale-example.svg)](http://isitmaintained.com/project/aljosamrak/android-at-scale-example "Percentage of issues still open")



### Code quality
[![alert_status][alertStatusBadge]][sonarCloudUrl]
[![sqale_rating][sqaleRatingBadge]][sonarCloudUrl]
[![reliability_rating][reliabilityRatingBadge]][sonarCloudUrl]
[![security_rating][securityRatingBadge]][sonarCloudUrl]
[![coverage][coverageBadge]][sonarCloudUrl]
[![code_smells][codeSmellsBadge]][sonarCloudUrl]
[![sqale_index][sqaleIndexBadge]][sonarCloudUrl]
[![bugs][bugsBadge]][sonarCloudUrl]
[![vulnerabilities][vulnerabilitiesBadge]][sonarCloudUrl]
[![ncloc][nclocBadge]][sonarCloudUrl]
[![duplicated_lines_density][duplicatedLinesDensityBadge]][sonarCloudUrl]




##  Support
__Bugs and requests__: submit them through the project's issues tracker.<br>
[![Issues](http://img.shields.io/github/issues/USER/REPO.svg)][gitHubIssuesUrl]



## Git commit format
Git commit format (source: https://www.conventionalcommits.org/en/v1.0.0/)

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```
Issue tags/ids should be in the footer. Like `Fixes #468`

https://www.datree.io/resources/git-commit-message
https://www.regextester.com/97567

Git message regex:

`^((fixup! |squash! )?(\w+)(?:\(([^\)\s]+)\))?: (.+))(?:\n|$){0,2}?((?:^.+(\n|$))+(?:\n|$){0,2}?)+((?:^.+(\n|$))+)+`

https://hackernoon.com/on-git-commit-messages-and-issue-trackers-f700f3cbb5a7
https://dev.to/puritanic/how-are-you-writing-a-commit-message-1ih7
https://nitayneeman.com/posts/understanding-semantic-commit-messages-using-git-and-angular/


## Use buildSrc to abstract imperative logic
https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources 
Complex build logic is usually a good candidate for being encapsulated either as custom task or binary plugin. Custom task and plugin implementations should not live in the build script. It is very convenient to use buildSrc for that purpose as long as the code does not need to be shared among multiple, independent projects.

The directory buildSrc is treated as an included build. Upon discovery of the directory, Gradle automatically compiles and tests this code and puts it in the classpath of your build script. For multi-project builds there can be only one buildSrc directory, which has to sit in the root project directory. buildSrc should be preferred over script plugins as it is easier to maintain, refactor and test the code.

buildSrc uses the same source code conventions applicable to Java and Groovy projects. It also provides direct access to the Gradle API. Additional dependencies can be declared in a dedicated build.gradle under buildSrc.

Example: https://proandroiddev.com/migrate-to-gradle-kotlin-dsl-in-4-steps-f3e3b27e1f4d





  # https://circleci.com/orbs/registry/orb/mizotake/unity-ci







## Logging framework
http://logback.qos.ch/manual/mdc.html

## Code optimizations

### Size optimization
https://imageoptim.com/mac

## Debug Utils
TODO test/debug activity before the real app??? or debug drawer
### Debug Drawer
### Android-Debug-Tools
### Stetho
### Android Debug Database
### Leak cannary


## Testing environment

### Spek
### AssertJ
### MockK

## Analysis tools

### Android Lint
### Custom lint
### SonarCube

## Build pipeline
### Verify preconditions
### Build
### Test
#### Unit tests
https://www.vogella.com/tutorials/AndroidTesting/article.html

70-80 % unit tests to ensure stability of your code basis

20-30 % functional tests to ensure that the application really works

some cross functional tests if your application integrates intensively with other Application components
#### Integration tests
#### Automation tests
### Verify
### Verify artefact
- compare with previous artefact (permission, certificake, features, activites, ...)
- verify constraints (size, ...)

## Publish

## Publish documentation

## Notify

## Monitoring
### Crashlitics

## Build Features ??
### API keys
Build src -> build config

TODO - some thing on qa to manifest metadata - can be read from APK without lanching
### Verified timestamp

## Features
### Push
### User support









  # https://circleci.com/orbs/registry/orb/mizotake/unity-ci







## Logging framework
http://logback.qos.ch/manual/mdc.html

## Code optimizations

### Size optimization
https://imageoptim.com/mac

## Debug Utils
TODO test/debug activity before the real app??? or debug drawer
### Debug Drawer
### Android-Debug-Tools
### Stetho
### Android Debug Database
### Leak cannary


## Testing environment

### Spek
### AssertJ
### MockK

## Analysis tools

### Android Lint
### Custom lint
### SonarCube

## Build pipeline
### Verify preconditions
### Build
### Test
#### Unit tests
https://www.vogella.com/tutorials/AndroidTesting/article.html

70-80 % unit tests to ensure stability of your code basis

20-30 % functional tests to ensure that the application really works

some cross functional tests if your application integrates intensively with other Application components
#### Integration tests
#### Automation tests
### Verify
### Verify artefact
- compare with previous artefact (permission, certificake, features, activites, ...)
- verify constraints (size, ...)

## Publish

## Publish documentation

## Notify

## Monitoring
### Crashlitics

## Build Features ??
### API keys
Build src -> build config

TODO - some thing on qa to manifest metadata - can be read from APK without lanching
### Verified timestamp

## Features
### Push
### User support


## Benchmark
Android Jetpack provides a very good library for performance testing on the device. There are very good blogs and official documentation written about this.

[Official documentation](https://developer.android.com/studio/profile/benchmark)
[A really good blog](https://tech.olx.com/android-jetpack-benchmark-json-parsers-performance-1e76031a296b) [with am accompanying github repo](https://github.com/mootazltaief/android-json-benchmark)
[A bit older but more detailed blog](https://blog.mindorks.com/improving-android-app-performance-with-benchmarking)

## Plugins

### dependency-check-gradle

### gradle-version-plugin
https://github.com/ben-manes/gradle-versions-plugin


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

<!-- travisCi URL -->
[travisCiUrl]: https://travis-ci.org/aljosamrak/android-at-scale-example
[travisCiMaster]: https://travis-ci.org/github/aljosamrak/android-at-scale-example/branches/master
[travisCiDevelop]: https://travis-ci.org/github/aljosamrak/android-at-scale-example/branches/develop
[travisCiMasterStatus]:https://api.travis-ci.org/aljosamrak/android-at-scale-example.png?branch=master
[travisCiDevelopStatus]: https://api.travis-ci.org/aljosamrak/android-at-scale-example.png?branch=develop
[travisCiStatusBadge]: https://api.travis-ci.org/aljosamrak/android-at-scale-example.png

<!-- GitHub URL -->
[gitHubRelease]: https://img.shields.io/github/release/aljosamrak/android-at-scale-example.js.svg
[gitHubActivityBadge]: https://img.shields.io/github/commit-activity/m/aljosamrak/android-at-scale-example
[gitHubActivityUrl]: https://GitHub.com/aljosamrak/android-at-scale-example/graphs/commit-activity
[gitHubReleaseUrl]: https://github.com/aljosamrak/android-at-scale-example/releases
[gitHubIssuesUrl]: https://github.com/aljosamrak/android-at-scale-example/issues

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

<!--Licence references-->
[licenceUrl]: https://www.gnu.org/licenses/gpl-3.0
[licenceBadge]: https://img.shields.io/badge/License-GPLv3-blue.svg

<!--Website references-->
[websiteBadge]: https://img.shields.io/website?url=https%3A%2F%2Faljosamrak.github.io%2Fandroid-at-scale-example%2F
[websiteUrl]: https://aljosamrak.github.io/android-at-scale-example

<!--Is maintained reference-->
[isMaintained]: https://img.shields.io/badge/Maintained%3F-yes-green.svg
<!--[![Maintenance](https://img.shields.io/badge/Maintained%3F-no-red.svg)](https://bitbucket.org/lbesson/ansi-colors)-->
<!--[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/)-->