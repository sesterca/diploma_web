package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MainPageWithApiTest extends BaseTests {

    MainPage mainPage = new MainPage();
    String pictureLink;

    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8
    })

    @ParameterizedTest
    public void loadingBannerPictureTest(int number){
        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Получить номер слайда в баннере", () -> {
            pictureLink = mainPage.getBannerPictureLink(number);
        });
        step("Проверить статус загрузки изображения слайда", () -> {
            given()
                    .when()
                    .log().uri()
                    .get(baseURI + pictureLink)
                    .then()
                    .statusCode(200);
        });
    }
}
