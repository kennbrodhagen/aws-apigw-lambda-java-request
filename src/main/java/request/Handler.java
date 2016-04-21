package request;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import java.util.Map;

public class Handler implements RequestHandler<Handler.Request, String> {
    public static class Body {
        public String value;
    }

    public static class Request {
        public Body body;
        public Map<String, String> headers;
        public String method;
        public Map<String, String> params;
        public Map<String, String> query;
    }

    public String handleRequest(Handler.Request request, Context context) {
        String resultTemplate =
         "headers: %s\n" +
         "method: %s\n" +
         "params: %s\n" +
         "query: %s";

        String result = String.format(resultTemplate,
            request.headers,
            request.method,
            request.params,
            request.query);

        System.out.println("Request: \n" + result);
        return String.format("Hello, %s!", request.params.get("id"));
    }
}
