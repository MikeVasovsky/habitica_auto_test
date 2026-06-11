package pages.container;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainTittle {
    private SelenideElement mainTittle = $("#menu_collapse");
    private SelenideElement openSearchChallenge = $x("//*[@id=\"app\"]/div[3]/div[3]/div/nav/a[2]");

    @Step("открывть раздел 'Найти испытания'")
    public void goToSearchChallenge(){
        mainTittle.find(byText("Испытания")).click();
        openSearchChallenge.click();
    }
}
