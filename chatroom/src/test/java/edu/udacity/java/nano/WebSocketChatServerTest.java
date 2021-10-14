package edu.udacity.java.nano;

//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;


// Credit to Abdulla H. for adding the reference link below in Student Hub:
// https://stackoverflow.com/questions/54599169/how-to-configure-selenium-webdriver-with-spring-boot-for-ui-testing

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class WebSocketChatServerTest {

    @Autowired
    private Environment environment;

    private static String BASE_URL;
    private static String CHAT_URL;
    private static final String USERNAME = "java-nano";
    private static final int TIME_OUT_IN_SECONDS = 5;

    private WebDriver webDriver;

    @PostConstruct
    public void initUrls() {
        BASE_URL = environment.getProperty("app.base.url");
        CHAT_URL = environment.getProperty("app.chat.url");
    }
//
//    @Before
//    public void init() {
//        webDriver = initWebDriver();
//    }
//
//    @Test
//    public void navigate_to_login_page() {
//        webDriver.get(BASE_URL);
//        Assert.assertEquals(webDriver.getTitle(), "Chat Room Login");
//    }
//
//    @Test
//    public void join_chat_room() {
//        webDriver.get(BASE_URL);
//
//        WebElement usernameInput = webDriver.findElement(By.id("username"));
//        usernameInput.sendKeys(USERNAME);
//
//        WebElement loginButton = webDriver.findElement(By.className("submit"));
//        loginButton.click();
//
//        waitForServerEndpointResponse(0);
//
//        String currentUrl = webDriver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, String.format(CHAT_URL, USERNAME));
//
//        WebElement onlineUsers = webDriver.findElement(By.id("chat-num"));
//        Assert.assertEquals(onlineUsers.getText(), "1");
//    }
//
//    @Test
//    public void send_chat_message() {
//        String message = "Project 1";
//
//        webDriver.get(String.format(CHAT_URL, USERNAME));
//
//        int oldMessageCount = webDriver.findElements(By.className("message-content")).size();
//
//        WebElement messageInput = webDriver.findElement(By.id("msg"));
//        messageInput.sendKeys(message);
//
//        WebElement sendButton = webDriver.findElement(By.id("send"));
//        sendButton.click();
//
//        waitForServerEndpointResponse(oldMessageCount);
//
//        String expectedMessage = String.format("%s:   %s", USERNAME, message);
//        List<WebElement> messageElements = webDriver.findElements((By.className("message-content")));
//        WebElement messageElement = messageElements.get(messageElements.size() - 1);
//        Assert.assertEquals(expectedMessage, messageElement.getText());
//    }
//
//    @Test
//    public void exit_to_app() {
//        webDriver.get(String.format(CHAT_URL, USERNAME));
//        WebElement exitButton = webDriver.findElement(By.id("exit"));
//        exitButton.click();
//        Assert.assertEquals(BASE_URL, webDriver.getCurrentUrl());
//    }
//
//    @After
//    public void finalize() {
//        if (webDriver != null) {
//            webDriver.close();
//        }
//    }
//
//    private WebDriver initWebDriver() {
//        String driverPath = environment.getProperty("selenium.chromedriver");
//        assert driverPath != null;
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File(driverPath))
//                .build();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--start-minimized", "--disable-extensions", "--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu");
//
//        return new ChromeDriver(service, options);
//    }
//
//    private void waitForServerEndpointResponse(int oldMessageCount) {
//        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("message-content"), oldMessageCount));
//    }
}
