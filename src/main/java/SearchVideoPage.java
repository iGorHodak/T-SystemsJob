import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchVideoPage {
    private WebDriver driver;

    public SearchVideoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

        new WebDriverWait(driver,5).
                until(ExpectedConditions.titleIs("Смотрите видео онлайн: сериалы, мультики, игры, клипы, фильмы на Яндексе"));
    }


    @FindBy(xpath = "//input[@class= 'input__control']")
    private WebElement searchLine;

    @FindBy(xpath = "//div[@class= 'search2__button']")
    private WebElement searchButton;


    public SearchVideoPage searchVideo (String text){
        searchLine.sendKeys(text);
        return this;
    }

    public VideoPage clickSignIn(){
        searchButton.click();
        return new VideoPage(driver);
    }

    public VideoPage searchContext (String text){
        this.searchVideo(text);
        this.clickSignIn();
        return new VideoPage(driver);
    }

}
