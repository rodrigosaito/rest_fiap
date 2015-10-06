import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class RestDemo {

    private static final String SANDBOX = "https://sandbox.moip.com.br";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String jsonOrder = "{\"ownId\":\"meu_id_de_pedido\",\"items\":[{\"product\":\"Nome do produto\",\"quantity\":1,\"detail\":\"Mais info...\",\"price\":1000}],\"customer\":{\"ownId\":\"meu_id_de_customer\",\"fullname\":\"Jose da Silva\",\"email\":\"user@domain.com\"}}";

    public static void main(String[] args) throws Exception {
        System.out.println("Response: " + sendPOST());

        System.out.println("Response: " + sendGET());
    }

    // HTTP POST request
    private static String sendPOST() throws Exception {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, jsonOrder);
        Request request = new Request.Builder()
                .url(SANDBOX + "/v2/orders")
                .addHeader("Authorization", "Basic MDEwMTAxMDEwMTAxMDEwMTAxMDEwMTAxMDEwMTAxMDE6QUJBQkFCQUJBQkFCQUJBQkFCQUJBQkFCQUJBQkFCQUJBQkFCQUJBQg==")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // HTTP GET request
    private static String sendGET() throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(SANDBOX + "/v2/orders/ORD-CYZDJRB2BEVB")
                .addHeader("Authorization", "Basic MDEwMTAxMDEwMTAxMDEwMTAxMDEwMTAxMDEwMTAxMDE6QUJBQkFCQUJBQkFCQUJBQkFCQUJBQkFCQUJBQkFCQUJBQkFCQUJBQg==")
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
