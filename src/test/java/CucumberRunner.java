import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.mycompany.autotests"},
        plugin = {
                "ru.mycompany.autotests.util.AllureReporter",
        }
)
public class CucumberRunner {

}
