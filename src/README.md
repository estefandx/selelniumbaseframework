
# Selenium Automation Framework Setup Guide

This guide will walk you through the setup and execution process for running automated tests in this project using **Selenium**, **TestNG**, **Gradle**, and **Allure**.

## Prerequisites

Before running the tests, ensure that you have the following installed:

- **Java 11 or higher**
  Download and install from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use your preferred OpenJDK distribution.

- **Gradle**
  Gradle is used to manage dependencies and run tests. You can download it from [here](https://gradle.org/install/), or you can use the included Gradle wrapper if you don't have it installed globally.

- **Allure** (for generating test reports)
  This will be automatically downloaded by Gradle if it's not installed locally. If you prefer to install it manually, you can do so from [Allure's official site](https://allure.qatools.ru/).

## Setup Steps

### 1. Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/yourusername/seleniumbaseframework.git
cd seleniumbaseframework


Execution with Gradle

gradle clean test or ./gradlew clean test if you want to see the traceability of the execution, add it to the command you are going to execute


To see the report
execute  gradle allureServe
