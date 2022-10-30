package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FavoritesPage {

    public SelenideElement favoriteProductName = $x("//div[@id='personalFavList']//a/span/span");

    public String favoriteProductGetName(){
       String name = favoriteProductName.getText();
       String brand = $("div#personalFavList p.caption a").getAttribute("data-brand");
       String volume = $("div#personalFavList span.black-color").getText();
       return name +" "+ brand +", "+ volume;
    }
}
