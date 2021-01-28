package bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/bdd/scenario")
public class StepRunner extends AbstractTestNGCucumberTests {

}
