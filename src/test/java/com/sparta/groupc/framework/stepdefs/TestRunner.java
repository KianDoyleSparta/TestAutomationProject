package com.sparta.groupc.framework.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        tags= "@happy or @sad or @alternate",
        plugin={"pretty", "html:target/testReport.html", "json:target/jsonReport.json"},
        publish=true
)
public class TestRunner {

}


