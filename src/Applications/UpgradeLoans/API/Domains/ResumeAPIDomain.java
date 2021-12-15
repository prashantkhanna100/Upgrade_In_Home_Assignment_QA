package Applications.UpgradeLoans.API.Domains;

import General.APIHelper;
import General.DomainBase;
import io.restassured.response.Response;

import java.util.HashMap;

/**
 * This class contains common methods for Resume API called By Test Classes
 */
public class ResumeAPIDomain extends DomainBase {
    String endpoint;
    HashMap<String, String> headers = new HashMap<String, String>();
    APIHelper apiHelper;

    // Constructor
    public ResumeAPIDomain() {
        apiHelper = new APIHelper();
        endpoint = getProperty("resumeAPIURL");
        headers.put("x-cf-source-id", "coding-challenge");
        headers.put("x-cf-corr-id", "12345");
        headers.put("Content-Type", "application/json");
    }

    /**
     * This method accepts the request body for Post Call to Resume API.
     *
     * @param body
     * @return
     */
    public Response postCallResumeAPI(String body) {
        return apiHelper.postCall(endpoint, headers, body);
    }

}


