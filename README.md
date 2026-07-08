# Habitica UI Tests

<p align="center">
  <a href="https://habitica.com/">
    <img src="https://static.cdnlogo.com/logos/h/76/habitica_800.png" alt="Habitica" width="280"/>
  </a>
</p>

<p align="center">
  Автотесты веб-приложения <a href="https://habitica.com/">Habitica</a>
</p>

## Содержание

- [Технологии](#технологии)
- [Библиотеки](#библиотеки)
- [Варианты запуска](#варианты-запуска)
- [Запуск](#запуск)
- [Jenkins](#jenkins)
- [Allure Report](#allure-report)

## Технологии

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white)](https://gradle.org/)
[![Selenide](https://img.shields.io/badge/Selenide-43B02A?style=flat)](https://selenide.org/)
[![Selenoid](https://img.shields.io/badge/Selenoid-00B4D8?style=flat)](https://aerokube.com/selenoid/)
[![Habitica](https://img.shields.io/badge/Habitica-432874?style=flat)](https://habitica.com/)
[![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=flat&logo=jenkins&logoColor=white)](https://jenkins.autotests.cloud/view/java_students/job/ikrylov_item/)

## Библиотеки

[![JUnit 5](https://img.shields.io/badge/JUnit_5-25A162?style=flat&logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![Allure](https://img.shields.io/badge/Allure-FF6B00?style=flat)](https://allurereport.org/)
[![AssertJ](https://img.shields.io/badge/AssertJ-FF6F00?style=flat)](https://assertj.github.io/doc/)
[![Owner](https://img.shields.io/badge/Owner-5C6BC0?style=flat)](https://owner.aeonbits.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1A1A1A?style=flat&logo=lombok&logoColor=white)](https://projectlombok.org/)
[![JavaFaker](https://img.shields.io/badge/JavaFaker-00897B?style=flat)](https://github.com/DiUS/java-faker)

## Варианты запуска

```mermaid
flowchart TD
    A[Запуск тестов] --> B{Где выполняется браузер?}

    B -->|Локально| C["Локальный запуск<br/>./gradlew test"]
    C --> C1["env = local<br/>Chrome на машине разработчика"]

    B -->|Удалённо через Selenoid| D{Где запускается Gradle?}

    D -->|На локальной машине| E["Локальный Gradle + удалённый браузер<br/>./gradlew test -Denv=remote -DremoteUrl=..."]
    E --> E1["Gradle локально<br/>браузер в Selenoid"]

    D -->|В CI| F["Удалённый запуск<br/>Jenkins job ikrylov_item"]
    F --> F1["Gradle в Jenkins<br/>браузер в Selenoid"]
```

## Запуск

```bash
chmod +x gradlew
./gradlew test
```

Запуск по тегам:

| Тег | Раздел |
|-----|--------|
| `habitica` | все тесты |
| `login` | авторизация |
| `registration` | регистрация |
| `main` | главная страница, привычки |
| `case` | ежедневные дела |
| `challenge` | испытания |

```bash
./gradlew test -PincludeTags=habitica
./gradlew test -PincludeTags=login
./gradlew test -PincludeTags=registration
./gradlew test -PincludeTags=main
./gradlew test -PincludeTags=case
./gradlew test -PincludeTags=challenge
./gradlew test -PincludeTags=login,registration
./gradlew test -PincludeTags=habitica -PexcludeTags=challenge
```

Запуск через Selenoid (локальный Gradle + удалённый браузер):

```bash
./gradlew test \
  -Denv=remote \
  -DremoteUrl=https://user1:1234@ru.selenoid.autotests.cloud/wd/hub \
  -Dbrowser.language=ru-RU
```

## [Jenkins](https://jenkins.autotests.cloud/view/java_students/job/ikrylov_item/)

Последняя сборка: [ikrylov_item #87](https://jenkins.autotests.cloud/view/java_students/job/ikrylov_item/87/)

Allure-отчёт публикуется из Jenkins после каждой сборки — [пример отчёта](#allure-report) (build #87, блок **Executors → Jenkins**).

Параметры запуска в Jenkins:

```
-Denv=REMOTE
-DremoteUrl=https://user1:1234@ru.selenoid.autotests.cloud/wd/hub
-Dbrowser.language=ru-RU
```

## [Allure Report](https://jenkins.autotests.cloud/view/java_students/job/ikrylov_item/87/allure/)

Пример отчёта после прогона в Jenkins (build #87, 13 тестов, 92.3% success):

![Allure Report — ikrylov_item #87](docs/screenshots/allure-report.png)

Локальный Allure-отчёт:

```bash
./gradlew allureReport
./gradlew allureServe
```
