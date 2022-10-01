package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    SelenideElement geoLocationPopupCloseButton = $(".checking-location-dialog__close close-btn");

    public SelenideElement favorite = $(byClassName("favourite"));
    public SelenideElement favoritesCounter = $(byId("topFavCount"));
    public SelenideElement productName = $(byClassName("name"));

    public void geoLocationPopupCloseButtonClick(){geoLocationPopupCloseButton.click();}

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