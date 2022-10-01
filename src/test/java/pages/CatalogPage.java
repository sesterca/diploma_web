package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {

    SelenideElement geoLocationPopupCloseButton = $(".change-delivery-dialog__close close-btn desktop");

    public SelenideElement favorite = $(byClassName("favourite"));
    public SelenideElement favoritesCounter = $(byId("topFavCount"));
    public SelenideElement productName = $(byClassName("name"));

    public void geoLocationPopupCloseButtonClick(){
        geoLocationPopupCloseButton.click();
    }

    public void favoriteClick(){
        favorite.click();
    }

    public String favoritesCount(){
        return favoritesCounter.getText();
    }

    public String getProductName(){
        return productName.getText();
    }
}