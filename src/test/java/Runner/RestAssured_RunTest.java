package Runner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_RunTest {

    @Test
    public void RestAssured_UpdateRecords(){
        int newid = 15410;

        RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Zion"); // Cast
        requestParams.put("age", 35);
        requestParams.put("salary", 500000);
        request.body(requestParams.toJSONString());
        Response response = request.put("/update/"+ newid);
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);

    }
}
