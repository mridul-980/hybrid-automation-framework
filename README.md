# Hybrid Automation Framework

## Overview

A Hybrid Test Automation Framework built using Selenium WebDriver, TestNG, Maven, Rest Assured, Jenkins, and GitHub.

The framework supports both UI Automation and API Automation with reusable design patterns, reporting, logging, CI/CD integration, and schema validation.

---

## Technology Stack

### UI Automation

* Java 17
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Log4j2
* Extent Reports

### API Automation

* Rest Assured
* Request Specifications
* Response Specifications
* JSON Schema Validation
* Serialization
* Deserialization
* Authentication Framework

### CI/CD

* Jenkins Freestyle Jobs
* Jenkins Pipeline
* GitHub Integration

---

## Framework Features

### UI Framework

* Page Object Model
* Driver Factory using ThreadLocal
* Cross Browser Execution
* Chrome Support
* Edge Support
* Headless Execution
* Utility Classes
* Extent Reports
* Screenshot Capture
* Retry Analyzer
* TestNG Listeners

### API Framework

* GET API Testing
* POST API Testing
* PUT API Testing
* DELETE API Testing
* Serialization
* Deserialization
* Request Specifications
* Response Specifications
* JSON Schema Validation

---

## Project Structure

src/main/java

* api
* base
* drivers
* factory
* listeners
* pages
* utilities

src/test/java

* UI Tests
* API Tests

src/test/resources

* config
* schemas

---

## Execution

Run UI Tests

mvn clean test

Run API Test Suite

testng-api.xml

---

## Reporting

* Extent Reports
* Console Logs
* TestNG Reports

---

## Future Enhancements

* PATCH API Automation
* Data Driven API Testing
* Docker Integration
* Selenium Grid
* Parallel Execution
* GitHub Actions Integration

---

## Author

Mridul Tripathi
Software QA Engineer | SDET
