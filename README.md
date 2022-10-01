# diploma_web

# Тестирование UI сайта компании
[<<img src="image/4fresh_logo.png">](https://4fresh.ru/)

>*[4fresh](https://4fresh.ru/about/why/) Первый мультибрендовый интернет-магазин натуральной косметики и органической косметики ручной работы.* 

### В проекте протестировано :mag_right:
* Переход к страницам меню хедера
* Показ подменю и его структура при наведении курсора на пункт меню хедера
* Проверка автоопределения геопозиции
* Проверка отображения только товаров со скидкой в блоке Распродажа
* Проверка загрузки логотипов брендов
* Проверка загрузки изображений в слайдере
* Проверка счетчика после добавления товара в Избранное
* Проверка добавления в Избранное 

### В проекте использованы :gear:
<img src="image/Java.svg" width="60"><img src="image/JUnit5.svg" width="60"><img src="image/Gradle.svg" width="60"><img src="image/Intelij_IDEA.svg" width="60"><img src="image/Selenide.svg" width="60"><img src="image/Selenoid.svg" width="60"><img src="image/GitHub.svg" width="60"><img src="image/Jenkins.svg" width="60"><img src="image/Allure_Report.svg" width="60"><img src="image/Telegram.svg" width="60">

## Для запуска тестов
### локально в терминале :computer:
```
gradle clean test -Dhost=local
```
### удаленно в Jenkins :desktop_computer:
```
gradle clean test -Dhost=remote
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbaseUrl="${BASE_URL}"
```
[Пример сборки](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/13/)
Открыть [Jenkins](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website), в меню слева выбрать ```Собрать с параметрами```
#### Параметры сборки
<details><summary>BROWSER</summary><p>Браузер, в котором будут выполняться тесты (по умолчанию <strong>Chrome</strong>)</p></details> 
<details><summary>BROWSER_SIZE</summary><p>Размер окна браузера (по умолчанию <strong>1920х1080</strong>)</p></details>
<details><summary>BASE_URL</summary><p>Адрес тестового окружения (по умолчанию <strong>https://www.naumen.ru/</strong>)</p></details>
<details><summary>REMOTE</summary><p>Адрес удаленного сервера, на котором будут запускаться тесты (по умолчанию <strong>selenoid.autotests.cloud</strong>)</p></details>

## Для просмотра отчета
Под названием проекта кликнуть [<img src="image/Allure_Report.svg" width="30">](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/allure/)
#### Главный экран отчета
<img src="image/allure trend.jpg">

#### Экран подробного просмотра тестов тест-сьюта
<img src="image/allure tests.jpg">

#### Пример выполнения теста
![test_pass](https://user-images.githubusercontent.com/71780020/173231412-7821c04d-3a8f-4513-bd02-c8eaa5179f64.gif)

## Для уведомления о результатах тестирования
<img src="image/telegram report.jpg">
