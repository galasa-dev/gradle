# Gradle
Gradle plugins for Galasa

## OBR Plugin
The OBR plugin allows you to build OSGi Bundle Repositories using Gradle. If you would like to build OBRs using Maven, please refer to the [Maven OBR plugin](https://github.com/galasa-dev/maven). 

### Usage
To use the Gradle OBR plugin in a Gradle test project:

1. Create a `build.gradle` file in your project's OBR directory with the following contents:

    ```groovy
    plugins {
        id 'java'
        id 'dev.galasa.obr' version '0.15.0'
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            url = 'https://development.galasa.dev/prod/maven-repo/obr'
        }
    }

    // Here, all OSGi Bundles to be included in the OBR must be listed using the 'bundle' configuration
    dependencies {
        bundle project(':com.example.tests.manager')
        bundle project(':com.example.tests.mytests')
        ...
    }
    ```

2. Create a `settings.gradle` file in your project's root directory with the following contents:
   
    ```groovy
    pluginManagement {
        repositories {
            mavenLocal()
            mavenCentral()
            maven {
                url = "https://development.galasa.dev/prod/maven-repo/obr"
            }
            gradlePluginPortal()
        }
    }

    include 'com.example.tests.obr' // This must match the name of your OBR project directory.
    ```
    If you would like to give your OBR subproject a different name, you can create a `settings.gradle` file in your OBR directory containing the following line:
    
    ```groovy
    rootProject.name='obrProjectName'
    ```
    
    If you do this, ensure your `include` statement in your root project's `settings.gradle` file matches the name given to your OBR subproject.

3. Run `gradle build` to build the OBR.

To verify that the OBR was successfully built, A `build` directory will appear in your OBR directory and within it, a `galasa.obr` file should be present.

## To Build locally
Use the `.build-locally.sh` script to invoke a build.

See the notes at the top of the script for a list of environment variables which can be over-ridden to control build behaviour.

