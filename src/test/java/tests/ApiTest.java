package tests;

import API.GetRequest;
import API.PostRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@Severity(SeverityLevel.NORMAL)
@Story(value = "Api test")
@RunWith(Suite.class)
@Suite.SuiteClasses({
        GetRequest.class,
        PostRequest.class
})

public class ApiTest {

}