package Test.UpgradeLoans;

import Applications.UpgradeLoans.API.Domains.ResumeAPIDomain;
import General.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the API test cases Class which contains API Test Cases (1 method for each test case)
 */
public class APITests extends TestBase {
    private ResumeAPIDomain resumeDomain;

    @BeforeTest
    public void setUp() {
        resumeDomain = new ResumeAPIDomain();
    }

    @Test
    // Test Description:
    public void test1_loanApplicationExists() {
        String body = "{\n" +
                "\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e96\",\n" +
                "\"skipSideEffects\":true\n" +
                "}";
        Response resp = resumeDomain.postCallResumeAPI(body);
        //Step1 - Validate the status code returned by API call is 200
        Assert.assertEquals(resp.getStatusCode(), 200, "Resume API did not returned 200 status code for valid loan Application");
        // Now convert this Rest Assured Response into a Hash Map and then retrieve required information from the Hash Map.
        JsonPath jsonPath = resp.jsonPath();
        HashMap<Object, Object> jsonMap = new HashMap<Object, Object>();
        jsonMap = jsonPath.get("");
        Object loanInfo = jsonMap.get("loanAppResumptionInfo");
        String productType = (String) ((Map) loanInfo).get("productType");
        //Step2 - Validate the productType attribute has value - "PERSONAL_LOAN"
        Assert.assertEquals(productType, "PERSONAL_LOAN", "product Type in API response is not equal to PERSONAL_LOAN");
    }


    @Test
    // Test Description:
    public void test2_loanApplicationNotExists() {
        String body = "{\n" +
                "\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e97\",\n" +
                "\"skipSideEffects\":true\n" +
                "}";
        Response resp = resumeDomain.postCallResumeAPI(body);
        Assert.assertEquals(resp.getStatusCode(), 404, "Resume API did not returned 404 status code for invalid loan Application");
    }
}
