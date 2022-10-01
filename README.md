# diploma_web

# Тестирование UI сайта компании
[![naumen](https://user-images.githubusercontent.com/71780020/172861017-4db52962-4e9d-4a63-bf61-fed7e5bfbb52.png)](https://www.naumen.ru/)

>*Группа компаний NAUMEN — российский вендор ПО и облачных сервисов, технологический партнер в цифровой трансформации для компаний и органов власти [(c)](https://www.naumen.ru/company/).* 

### В проекте протестировано :mag_right:
* переход на главную страницу при клике по логотипу в хедере;
* структура меню хедера;
* переходы по пунктам меню хедера;
* ховер при наведении курсора на меню.

### В проекте использованы :gear:
<img src="image/Java.svg" width="60"><img src="image/JUnit5.svg" width="60"><img src="image/Gradle.svg" width="60"><img src="image/Intelij_IDEA.svg" width="60"><img src="image/Selenide.svg" width="60"><img src="image/Selenoid.svg" width="60"><img src="image/GitHub.svg" width="60"><img src="image/Jenkins.svg" width="60"><img src="image/Allure_Report.svg" width="60"><img src="image/Telegram.svg" width="60">

## Для запуска тестов
### локально в терминале :computer:
```
gradle clean test
```
### удаленно в Jenkins :desktop_computer:
```
gradle clean test
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbaseUrl="${BASE_URL}"
-Dremote="${REMOTE}"
```
[Пример сборки](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/13/)
Открыть [Jenkins](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website), в меню слева выбрать ```Собрать с параметрами```
#### Параметры сборки
<details><summary>BROWSER</summary><p>Браузер, в котором будут выполняться тесты (по умолчанию <strong>Chrome</strong>)</p></details> 
<details><summary>BROWSER_SIZE</summary><p>Размер окна браузера (по умолчанию <strong>1920х1080</strong>)</p></details>
<details><summary>BASE_URL</summary><p>Адрес тестового окружения (по умолчанию <strong>https://www.naumen.ru/</strong>)</p></details>
<details><summary>REMOTE</summary><p>Адрес удаленного сервера, на котором будут запускаться тесты (по умолчанию <strong>selenoid.autotests.cloud</strong>)</p></details>

## Для просмотра отчета
Под названием проекта кликнуть [<img src="image/Allure_Report.svg" width="50">](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/allure/)
#### Главный экран отчета
<img src="image/allure trend.jpg">

#### Экран подробного просмотра тестов тест-сьюта
<img src="image/allure tests.jpg">

#### Пример выполнения теста
![test_pass](https://user-images.githubusercontent.com/71780020/173231412-7821c04d-3a8f-4513-bd02-c8eaa5179f64.gif)

## Для уведомления о результатах тестирования
<img src="image/telegram report.jpg">
