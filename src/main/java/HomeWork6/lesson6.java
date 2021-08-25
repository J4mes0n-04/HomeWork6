package HomeWork6;
//Glazyrin
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class lesson6 {

    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECAST_URL = "forecasts";
    private static final String DAILY_URL = "daily";
    private static final String FIVE_DAYS_URL = "5day";
    private static final String API_VERSION = "v1";
    private static final String CITY_ID = "1-295863_1_AL";
    private static final String API_KEY = "w1vKhTaC2YwYzRYTNppCnhesVAlP6sxV";
    private static final String LANGUAGE = "ru-ru";
    private static final String METRIC = "true";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(HOST)
                .addPathSegment(FORECAST_URL)
                .addPathSegment(API_VERSION)
                .addPathSegment(DAILY_URL)
                .addPathSegment(FIVE_DAYS_URL)
                .addPathSegment(CITY_ID)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", LANGUAGE)
                .addQueryParameter("metric", METRIC)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.protocol());
        System.out.println(Objects.requireNonNull(response.body()).string());

    }
}
