package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CatalogPage {

    public SelenideElement favorite = $(byClassName("favourite"));
    public SelenideElement favoritesCounter = $(byId("topFavCount"));
    public SelenideElement productName = $(byClassName("name"));

    public void favoriteClick(){
        favorite.click();
    }

    public String favoritesCount(){
        return favoritesCounter.getText();
    }

    public String getProductName(){
        return productName.getText();
    }

    public void closePopUp(){
        executeJavaScript("$('#loading').remove");
        $(".checking-location-dialog__content").shouldNotBe(Condition.visible, Duration.ofSeconds(120));
        executeJavaScript("$('#selectDelivery').remove()");
    }
}