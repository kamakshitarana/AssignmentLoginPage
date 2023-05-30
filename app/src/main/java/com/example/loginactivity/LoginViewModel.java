package com.example.loginactivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<Boolean> loginResult = new MutableLiveData<>();

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public void loginUser(String email, String password) {
        OkHttpClient client = new OkHttpClient();

        // Create the JSON request body
        JSONObject requestBodyJson = new JSONObject();
        try {
            requestBodyJson.put("email", email);
            requestBodyJson.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), requestBodyJson.toString());

        // Create the HTTP POST request
        Request request = new Request.Builder().url("https://reqres.in/api/login")
                .post(requestBody)
                .build();

        // Make the API call asynchronously
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Handle API call failure
                e.printStackTrace();
                loginResult.postValue(false);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Handle API call response
                if (response.isSuccessful()) {
                    loginResult.postValue(true);
                } else {
                    loginResult.postValue(false);
                }
                response.close();
            }
        });
    }
}
