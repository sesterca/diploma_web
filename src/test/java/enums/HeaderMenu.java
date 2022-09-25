package enums;

public enum HeaderMenu {
    ABOUT_US("/about/","О нас"),
    DELIVERY("/delivery/", "Доставка"),
    PAYMENT("/payment/", "Оплата"),
    SERVICES("/services/", "Сервисы"),
    BLOG("/blog/", "Блог"),
    CONTACTS("/contacts/", "Контакты");

    public String headerMenuUrl;
    public String headerMenuName;

    HeaderMenu(String headerMenuUrl, String headerMenuName){
        this.headerMenuUrl = headerMenuUrl;
        this.headerMenuName = headerMenuName;
    }
}
