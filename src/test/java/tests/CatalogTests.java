package tests;

import com.codeborne.selenide.Condition;
import enums.Endpoints;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.FavoritesPage;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTests extends BaseTests {

    CatalogPage catalogPage = new CatalogPage();
    FavoritesPage favoritesPage = new FavoritesPage();
    String expectedFavoriteProductName;

    @BeforeEach
    public void openCatalogPage(){
        step("Открыть раздел Косметика каталога", () -> {
            open(baseUrl + Endpoints.COSMETICS.getEndpoint());
            catalogPage.geoLocationPopupCloseButtonClick();
        });
    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка счетчика после добавления товара в Избранное")
    public void favoritesCounterIsNotNullAfterAddedProductToFavoriteTest(){

        step("Кликнуть по иконке сердечка", () -> {
            catalogPage.favoriteClick();
        });
        step("Проверить счетчик Избранного", () -> {
            catalogPage.favoritesCounter.shouldNotBe(Condition.text("(0)"), Duration.ofSeconds(5000));
            assertThat(catalogPage.favoritesCount())
                    .isEqualTo("(1)");
        });
    }
    @Test
    @DisplayName("Проверка добавления в Избранное")
    public void addToFavoritesTest(){

        step("Кликнуть по иконке сердечка", () -> {
            catalogPage.favoriteClick();
        });
        step("Получить название товара, добавленного в Избранное", () -> {
            expectedFavoriteProductName = catalogPage.getProductName();
        });
        step("Открыть Избранное", () -> {
            open(Endpoints.FAVORITES.getEndpoint());
        });
        step("Проверить добавление товара в Избранное", () -> {
            assertThat(favoritesPage.favoriteProductGetName())
                    .isEqualTo(expectedFavoriteProductName);
        });
    }
}
