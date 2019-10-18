package question4;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestWorker implements Runnable{
  private String url;
  private Integer value = 0;

  public RestWorker(String url){
    this.url = url;
  }

  public Integer getValue(){
    return value;
  }

  public void run(){
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    Request request = new Request.Builder()
        .url(url)
        .build();
    try {
      Response response = client.newCall(request).execute();
      JsonParser jsonParser = new JsonParser();
      JsonObject obj = jsonParser.parse(response.body().string()).getAsJsonObject();
      ValueDto questionDto = gson.fromJson(obj, ValueDto.class);
      this.value = questionDto.value;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
