import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class VideoPage {

    private WebDriver driver;
    private Actions actions;

    public VideoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        this.driver = driver;

        new WebDriverWait(driver,5).
                until(ExpectedConditions.visibilityOf(clearButton));
    }

    @FindBy(xpath = "//span[@class = 'input__clear input__clear_visibility_visible']")
    private WebElement clearButton;

    @FindBy(xpath = "//div[contains(@class, 'serp-item_pos')]")
    private List<WebElement> allVideos;

    public void searchAnyTrailerByNumber (int number){
        List<WebElement> videos = allVideos;
        actions.moveToElement(videos.get(number)).build().perform();
    }
}

