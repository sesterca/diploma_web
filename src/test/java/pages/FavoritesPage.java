package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FavoritesPage {
    public SelenideElement favoriteProductName = $x("//div[@id='personalFavList']//a/span/span");

    public String favoriteProductGetName(){
       String name = favoriteProductName.getText();
       String brand = $x("//div[@id='personalFavList']//p[@class='caption']/a").getAttribute("data-brand");
       String volume = $x("//div[@id='personalFavList']//span[@class='black-color']").getText();
       return name +" "+ brand +", "+ volume;
    }
}
