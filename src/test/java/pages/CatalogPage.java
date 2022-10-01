package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

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
}