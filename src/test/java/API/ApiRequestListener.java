package API;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
public class ApiRequestListener implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        System.out.println("Method: " + requestSpec.getMethod());
        System.out.println("URI: " + requestSpec.getURI());
        System.out.println("Headers: " + requestSpec.getHeaders());
        System.out.println("Parameters: " + requestSpec.getQueryParams());
        // Proceed with the request
        Response response = ctx.next(requestSpec, responseSpec);

        // Capture response details if needed
        System.out.println("Response Status Code: " + response.getStatusCode());
        return response;
    }
}
