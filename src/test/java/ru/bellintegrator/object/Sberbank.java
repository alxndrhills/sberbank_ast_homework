package ru.bellintegrator.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sberbank {

    private WebDriver driver;

    public Sberbank(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.sberbank-ast.ru");
    }

    public WebElement findMenuElement(String elementName) {
        return this.driver.findElement(By.xpath(elementName));
    }

    public WebElement findSubMenuElement(String elementName, WebElement menu) {
        Select select = new Select(menu);
        List<WebElement> subMenuList = select.getOptions();
        return subMenuList.get(subMenuList.indexOf(findMenuElement(elementName)));
    }

    public void clickMenu(String menuName, String subMenuName) {
        WebElement menu = findMenuElement(menuName);
        WebElement subMenu = findSubMenuElement(subMenuName, menu);
        subMenu.click();
    }
}
