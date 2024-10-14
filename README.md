## Содержание

- [Требования](#требования)
- [Установка](#установка)
- [Запуск](#запуск)
- [Настройка БД](#использование)
- [Использование](#лицензия)

## Требования

Перед тем как начать, убедитесь, что у вас установлены следующие компоненты:

- [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)
- [IntelliJ IDEA Ultimate](https://www.jetbrains.com/ru-ru/idea/buy/?section=discounts&billing=yearly) (пробная версия на месяц)
- [Git](https://git-scm.com/downloads)
- [Postman](https://www.postman.com/downloads/)
- [MySQL](https://www.mysql.com/downloads/) (либо другая реляционная СУБД)

## Установка

1. Запустите Git Bash, перейдите в каталог, в который вы хотите клонировать репозиторий, с помощью команды cd:

   cd каталог

2. Клонируйте репозиторий:

   git clone https://github.com/DANCHENSKI/SensorDataHandler.git

## Запуск

1. Запустите проект в IntelliJ IDEA Ultimate с помощью File-Open-каталог-репозиторий. Убедитесь, что все зависимости загружены, для этого справа на панели инструментов выберите Gradle - ИмяПроекта - build - build
![Gradle](https://github.com/DANCHENSKI/SensorDataHandler/blob/main/img.jpg?raw=true)

## Настройка БД

1. Настройка базы данных:
   - Запустите MySQL Workbench и создайте пользователя
   - Создайте новую схему sensor_data_db
   - Создайте 2 новых БД в этой схеме:

CREATE TABLE Sensor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Measurement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    value DOUBLE NOT NULL,
    raining BOOLEAN NOT NULL,
    measurement_date_time TIMESTAMP NOT NULL,
    sensor VARCHAR(100),
    FOREIGN KEY (sensor) REFERENCES Sensor(name);

2. Настройте подключение к БД:
- Справа на панели инструментов IntelliJ IDEA Ultimate в выберите Database - + - Data Source - MySQL
- В поле User и Password введите имя и пароль созданного пользователя в MySQL Workbench, в поле URL введите ваш URL схемы из MySQL Workbench.
- Проверьте с помощью Test Connection снизу и нажмите apply.
- Откройте конфигурационный файл SensorDataHandler - src - main - resources - application.yml и поменяйте данные (пароль и логин пользователя и URL БД) на свои, если они отличаются.

## Использование

Запустите приложение.

Проверка с помощью Postman:
1. Убедитесь, что сервер запущен (по умолчанию на http://localhost:8080).
2. Откройте Postman.
3. Создайте HTTP-запросы для тестирования API:
   - POST http://localhost:8080/sensors/registration - создание сенсора:
      {"name": "название сервера"}
   - POST http://localhost:8080/measurements/add - создание измерения на основе сенсора:
      {"value" : 24.7, "raining" : false, "sensor": {"name": "название сенсора"}}
   - GET http://localhost:8080/measurements — получить список измерений.
   - GET http://localhost:8080/measurements/rainyDaysCount.

