package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.HeaderMenu;

import java.time.Duration;
import java.util.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    SelenideElement geoLocationAuto = $(".confirm-cp-city");
    SelenideElement geoYesButton = $(byTagAndText("a", "Да"));
    SelenideElement geoChooseButton = $(byTagAndText("a", "Выбрать другой город"));
    SelenideElement geoLocationText = $("div.open-delivery choose-caption delivery-input span span");

    ElementsCollection geoCities = $$(".lfs-item-link");

    SelenideElement saleHeading = $(byTagAndText("div", "Распродажа"));

    public void headerMenuClick(HeaderMenu headerMenu) {
        $x("//nav[@class='addl-menu']//li/a/span[text()='" + headerMenu.headerMenuName + "']").click();
    }

    public void headerMenuHover(String headerMenuSection) {
        $x("//li/a/span[text()='" + headerMenuSection + "']").hover();
    }

    public List<String> getHeaderMenuSectionTexts(String headerMenuSection) {
        return $$x("//a[span[text()='" + headerMenuSection + "']]/following-sibling::div[@class='expand-list b1']//span").texts();
    }

    public void geoYesButtonClick() {
        geoYesButton.click();
    }

    public String geoLocationAutoGetText() {
        return geoLocationAuto.getText();
    }

    public String geoLocationGetText() {
        return geoLocationText.getText();
    }

    public void geoChooseButtonClick() {
        geoChooseButton.click();
    }

    public void geoCountryClick(String country) {
        $x("//div[@id='choose-city-popup']//li[@data-name='" + country + "']").click();
    }

    public void geoRegionClick(String region) {
        $x("//li[@data-name='" + region + "']").scrollTo()
                .shouldNotBe(Condition.hidden).click();
    }

    public void geoCityClick(String city) {
        $x("//div[@class='cpc-offset']//li[@class='cpc-letter-list-item realCity' and @data-name='" + city + "']/a").click();
    }

    public void salesHeadingScrollTo() {
        saleHeading.scrollTo();
    }

    public String getBannerPictureLink(int number) {
        return $x("(//div[@class='swiper-slide'])[" + number + "]//source")
                .getAttribute("srcset");
    }

    public String getGoodsOnSaleId(int number) {
        return $x("(//div[@class='goodsTab Bestsellers']//div[@class='product_card'])[" + number + "]").getAttribute("id");
    }

    public String getCssStyleOfPrice(String goodId) {
        return $x("//div[@class='goodsTab Bestsellers']//div[@id='" + goodId + "']//div[@class='product_price active']/div")
                .getCssValue("color");
    }

    public void logoImagesScrollTo() {
        $(byTagAndText("span", "Популярные бренды")).scrollTo();
    }

    public boolean logoImageIsLoaded(String logoName) {
        return $x("//div[@class='row main-bottom-info-block']//img[@alt='" + logoName + "']").isImage();
    }

    public void closePopUp() {
        executeJavaScript("$('#loading').remove");
        $(".checking-location-dialog__content").shouldNotBe(Condition.visible, Duration.ofSeconds(120));
        executeJavaScript("$('#selectDelivery').remove()");
    }
}