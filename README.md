# Проект по автоматизации тестирования [Habitica](https://habitica.com/)

# 📝 Содержание:

- [Стек](#стек)
- [Реализованные проверки](#реализованные-проверки)
- [Структура проекта](#структура-проекта)
- [Запуск тестов из терминала](#запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Allure Report](#allure-report)

<a id="стек"></a>

## ☕ Стек:

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white)](https://gradle.org/)
[![Selenide](https://img.shields.io/badge/Selenide-43B02A?style=flat)](https://selenide.org/)
[![JUnit 5](https://img.shields.io/badge/JUnit_5-25A162?style=flat&logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=flat&logo=jenkins&logoColor=white)](https://www.jenkins.io/)
[![Selenoid](https://img.shields.io/badge/Selenoid-00B4D8?style=flat)](https://aerokube.com/selenoid/)
[![Allure](https://img.shields.io/badge/Allure-FF6B00?style=flat)](https://allurereport.org/)
[![AssertJ](https://img.shields.io/badge/AssertJ-FF6F00?style=flat)](https://assertj.github.io/doc/)
[![Owner](https://img.shields.io/badge/Owner-5C6BC0?style=flat)](https://owner.aeonbits.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1A1A1A?style=flat&logo=lombok&logoColor=white)](https://projectlombok.org/)
[![JavaFaker](https://img.shields.io/badge/JavaFaker-00897B?style=flat)](https://github.com/DiUS/java-faker)

В проекте автотесты написаны на **Java**. Сборка — **Gradle**, тесты — **JUnit 5**.

Для UI используется **Selenide**. Отчёты формируются в **Allure Report**. Проверки в тестах — через **AssertJ**, тестовые данные генерируются **JavaFaker**. Конфигурация окружения — через **Owner**.

<a id="реализованные-проверки"></a>

## 📠 Реализованные проверки:

### Авторизация

- логин зарегистрированного пользователя
- логин с незарегистрированным логином и паролем
- логин с некорректным паролем

### Регистрация

- смена имени пользователя после регистрации

### Главная страница

- отображение имени пользователя после регистрации
- добавление привычки с разными параметрами (параметризованный тест)

### Ежедневные дела

- добавление нового ежедневного дела

### Испытания

- добавление официального испытания к себе
- создание испытания *(тест отключён — `@Disabled`)*

<a id="структура-проекта"></a>

## 📁 Структура проекта

```text
src/test/java
├── allure       # вложения для Allure (скриншот, видео, логи)
├── config       # настройки браузера и окружения
├── data         # тестовые данные и генераторы
├── model        # модели для создания дел и испытаний
├── pages        # page object'ы для UI
└── tests
    ├── steps    # шаги авторизации и сценариев
    └── ...      # тестовые классы

src/test/resources
├── local.properties   # настройки локального запуска
└── remote.properties  # настройки запуска через Selenoid
```

<a id="запуск-тестов-из-терминала"></a>

## 💻 Запуск тестов из терминала

Команды запускать из корня проекта.

Первый запуск (Unix / macOS):

```bash
chmod +x gradlew
```

Все тесты:

```bash
./gradlew test
```

### Запуск по тегам

| Тег | Раздел |
|-----|--------|
| `habitica` | все тесты |
| `login` | авторизация |
| `registration` | регистрация |
| `main` | главная страница, привычки |
| `case` | ежедневные дела |
| `challenge` | испытания |

Все тесты по общему тегу:

```bash
./gradlew test -PincludeTags=habitica
```

По разделам:

```bash
./gradlew test -PincludeTags=login
./gradlew test -PincludeTags=registration
./gradlew test -PincludeTags=main
./gradlew test -PincludeTags=case
./gradlew test -PincludeTags=challenge
```

Несколько разделов за один запуск:

```bash
./gradlew test -PincludeTags=login,registration
```

Исключить раздел:

```bash
./gradlew test -PincludeTags=habitica -PexcludeTags=challenge
```

Запуск в удалённом браузере (Selenoid):

```bash
./gradlew test \
  -Denv=remote \
  -DremoteUrl=https://user1:1234@ru.selenoid.autotests.cloud/wd/hub \
  -Dbrowser.language=ru-RU
```

<a id="сборка-в-jenkins"></a>

## [🔧 Сборка в Jenkins](https://jenkins.autotests.cloud/view/java_students/job/ikrylov_item/)

После настройки Jenkins тесты можно запускать удалённо через Selenoid.

Параметры запуска:

```
-Denv=REMOTE
-DremoteUrl=https://user1:1234@ru.selenoid.autotests.cloud/wd/hub
-Dbrowser.language=ru-RU
```

<a id="allure-report"></a>

## 📊 Allure Report

Собрать отчёт:

```bash
./gradlew allureReport
```

Открыть в браузере:

```bash
./gradlew allureServe
```

В отчёт автоматически прикладываются скриншот, page source, логи консоли браузера и видео записи сессии (при запуске через Selenoid).
