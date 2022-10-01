package tests;

import enums.HeaderMenu;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPageUITest extends BaseTests {

    String expectedLocation;
    String goodId;

    MainPage mainPage = new MainPage();

    @BeforeEach
    public void openMainPage(){
        step("Открыть главную страницу", () -> {
            open();
            executeJavaScript("$('#loading').remove");
            executeJavaScript("$('#selectDelivery').remove()");
        });
    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    @EnumSource(HeaderMenu.class)

    @ParameterizedTest(name = "Переход к странице меню {0} хедера")
    public void headerMenuClickTest(HeaderMenu headerMenu){

        step("Кликнуть по ${headerMenu} в хедере", () -> {
            mainPage.headerMenuClick(headerMenu);
        });
        step("Проверить url открывшейся страницы", () -> {
            assertThat(url().substring(17))
                    .isEqualTo(headerMenu.headerMenuUrl);
        });
    }

    static Stream<Arguments> headerMenuItemStructure(){
        return Stream.of(
                Arguments.of("О нас", List.of(
                        "Почему мы",
                        "Программа лояльности Ohana",
                        "4fresh friends",
                        "Клуб 4fresh",
                        "Любимый товар",
                        "Партнёрская программа 4fresh Rewards",
                        "Вакансии",
                        "Сотрудничество",
                        "Предложить бренд",
                        "Оптовая торговля",
                        "Экопроекты"
                )),
                Arguments.of("Сервисы", List.of(
                        "Помощь",
                        "Вопрос эксперту",
                        "Отзывы и предложения",
                        "Глоссарий",
                        "Анализ составов PickTrue",
                        "Персональный подбор косметики"
                ))
        );
    }

    @MethodSource("headerMenuItemStructure")
    @ParameterizedTest(name = "{0}")
    public void hoverHeaderMenuTest(String headerMenuSection, List<String>expectedMenuSectionItems){

        step("Навести курсор на пункт меню", () -> {
            mainPage.headerMenuHover(headerMenuSection);
        });
        step("Проверить структуру подменю", () -> {
            List<String> actualMenuSectionItems = mainPage.getHeaderMenuSectionTexts(headerMenuSection);
            assertThat(actualMenuSectionItems)
                    .isEqualTo(expectedMenuSectionItems);
        });
    }

    @Test
    @DisplayName("Проверка автоопределения геопозиции")
    public void geoPositionAutoTest(){

        step("Получить авто геопозицию", () -> {
            expectedLocation = mainPage.geoLocationAutoGetText();
        });
        step("Подтвердить автоопределенную гео кликом по Да", () -> {
            mainPage.geoYesButtonClick();
        });
       step("Проверить запись выбранного города", () -> {
           assertThat(mainPage.geoLocationGetText()).isEqualTo(expectedLocation);
        });
    }

    @CsvSource(value = {
            "Россия, Архангельская область, Онега",
            "Беларусь, Брестская область, Барановичи",
            "Казахстан, Западно-Казахстанская область, Аксай"
    })
    @Disabled
    @ParameterizedTest(name="city from {0}")
    public void geoPositionChooseTest(String country, String region, String city){

        step("Кликнуть кнопку Выбрать другой город", () -> {
            mainPage.geoChooseButtonClick();
        });
        step("Кликнуть страну", () -> {
            mainPage.geoCountryClick(country);
        });
        step("Кликнуть регион", () -> {
            mainPage.geoRegionClick(region);
        });
        step("Кликнуть город", () -> {
            mainPage.geoCityClick(city);
        });
        step("Проверить запись выбранной геопозиции", () -> {
            assertThat(mainPage.geoLocationGetText())
                    .isEqualTo(city);
        });
    }

    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
    })
    @ParameterizedTest
    @DisplayName("Проверка товаров отображения только товаров со скидкой в Распродаже")
    public void saleSectionGoodsOnSaleOnlyTest(int number){

        step("Скроллить страницу до заголовка Распродажа", () -> {
            mainPage.salesHeadingScrollTo();
        });
        step("Получить id товара на распродаже", () -> {
            goodId = mainPage.getGoodsOnSaleId(number);
        });
        step("Проверить стиль цены товара распродажи", () -> {
            assertThat(mainPage.getCssStyleOfPrice(goodId))
                    .isEqualTo("rgba(255, 94, 29, 1)");
        });
    }

    @ValueSource(strings = {
            "4fresh BEAUTY",
            "Nonicare",
            "Synergetic",
            "Mojo Cacao",
            "Seasons",
            "СпивакЪ",
            "Whamisa",
            "Dr. Hauschka",
            "Natura Siberica",
            "Planeta Organica",
            "Levrana",
            "Bite"
    })
    @ParameterizedTest
    @DisplayName("Проверка загрузки логотипов брендов")
    public void loadingLogoBrandsImagesTest(String logoName){

        step("Скроллить страницу до иконок брендов", () -> {
            mainPage.logoImagesScrollTo();
        });

        step("Проверить наличие иконки для ${logoName}", () -> {
            assertThat(mainPage.logoImageIsLoaded(logoName))
                    .isTrue();
        });
    }
}
