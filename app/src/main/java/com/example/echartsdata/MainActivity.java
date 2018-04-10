package com.example.echartsdata;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echartsdata.gson.GeoCoordMap;
import com.example.echartsdata.gson.Geoaddress;
import com.example.echartsdata.gson.Stationone;
import com.example.echartsdata.gson.Stationtwo;
import com.example.echartsdata.gson.TJAlarmdata;
import com.example.echartsdata.gson.TJValue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView responseText;
    WebView responseWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        WebView webView = (WebView) findViewById(R.id.chartshow_wb);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("http://www.baidu.com");
        Button one_bt = (Button) findViewById(R.id.one_bt);
        Button two_bt = (Button) findViewById(R.id.two_bt);
        Button three_bt = (Button) findViewById(R.id.three_bt);
        responseText = (TextView) findViewById(R.id.response_textview);
        responseWeb = (WebView) findViewById(R.id.response_webview);
        responseWeb.getSettings().setAllowFileAccess(true);
        //支持javascript
        responseWeb.getSettings().setJavaScriptEnabled(true);
        //设置编码
        responseWeb.getSettings().setDefaultTextEncodingName("utf-8");
        responseWeb.setHorizontalScrollBarEnabled(false);
        responseWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        responseWeb.setVerticalScrollBarEnabled(false);
        responseWeb.getSettings().setDomStorageEnabled(true);
        responseWeb.getSettings().setDatabaseEnabled(true);
//        responseWeb.setWebViewClient(new WebViewClient());
//        responseWeb.loadUrl("file:///android_asset/tianjin5_add4.html");
//        responseWeb.addJavascriptInterface(new JavaScriptObject(this),"myObj");
        responseWeb.loadUrl("file:///android_asset/tianjin5_add6.html");
        one_bt.setOnClickListener(this);
        two_bt.setOnClickListener(this);
        three_bt.setOnClickListener(this);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            String tt = (String) msg.obj;
            switch(msg.what){
                case 1:
//                   responseWeb.loadUrl("javascript:funFromjs()")
                    Log.d("dd",tt);
                    responseWeb.loadUrl("javascript:createChart("+ tt +");");
                    break;
                case 2:
                    Log.d("ddd",tt);
                    responseWeb.loadUrl("javascript:createChart("+ tt +");");
                default:
                    break;
            }
        }
    };


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.one_bt:
                sendRequestWithOkHttp();
//                responseWeb.loadUrl("javascript:funFromjs()");
                break;
            case R.id.two_bt:
                sendRequestWithOkHttp2();
                break;
            case R.id.three_bt:
                break;
            default:
                break;
        }
    }

    final class JavaScriptObject{
        private Context mContxt;
        public JavaScriptObject(Context mContxt){
            this.mContxt = mContxt;
        }
        @JavascriptInterface
        public void funFromAndroid(String name){
            Toast.makeText(mContxt, "调用funFromAndroid:" + name, Toast.LENGTH_LONG).show();
        }
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request1 = new Request.Builder()
                            .url("http://192.168.43.6/geoCoordMap.json")
                            .build();
                    Response response1 = client.newCall(request1).execute();
                    String geoCoordMap = response1.body().string();

                    Request request4= new Request.Builder()
                            .url("http://192.168.43.6/TJData.json")
                            .build();
                    Response response4 = client.newCall(request4).execute();
                    String TJData = response4.body().string();
                    String TOData = "管控中心";
                    Log.d("MainActivity","responseData1 is "+ geoCoordMap);
                    Log.d("MainActivity","responseData4 is "+ TJData);
                    Log.d("MainActivity","TOData is "+ TOData);

                    Message message = new Message();
                    message.what = 1;
                    message.obj = TJData;
                    handler.sendMessage(message);
//                    parseJSONWithJSONObject(responseData);
//                    parseTJValueWithGson(responseData);
//                    parseTJAlarmdataWithJSONObject(responseData);
//                    parseGeoCoordMapWithJSONObject(geoCoordMap);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestWithOkHttp2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request1 = new Request.Builder()
                            .url("http://192.168.43.6/geoCoordMap.json")
                            .build();
                    Response response1 = client.newCall(request1).execute();
                    String geoCoordMap = response1.body().string();
                    Request request4= new Request.Builder()
                            .url("http://192.168.43.6/TJData2.json")
                            .build();
                    Response response4 = client.newCall(request4).execute();
                    String TJData = response4.body().string();

                    Message message  = new Message();
                    message.what = 2;
                    message.obj = TJData;
                    handler.sendMessage(message);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //get_data.json
    private void parseJSONWithJSONObject(String jsonData){
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("MainActivity","id is " + id);
                Log.d("MainActivity", "name is " + name);
                Log.d("MainActivity", "version is " + version);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //TJValue.json JSONArray
    private void parseTJValueWithGson(String jsonData){
        Gson gson = new Gson();
        List<TJValue> appList = gson.fromJson(jsonData,new TypeToken<List<TJValue>>(){}.getType());
        for(TJValue app:appList){
            Log.d("MainActivity", "name is" + app.getName());
            Log.d("MainActivity", "value is " + app.getValue());
        }
    }

    //geoCoordMap.json 复杂的JSONArray
    private void parseGeoCoordMapWithJSONObject(String jsonData){
        List<GeoCoordMap> geoCoordMaps = new ArrayList<GeoCoordMap>();
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                JSONObject addressJson = jsonObject.getJSONObject("address");
                String lng = addressJson.getString("lng");
                String lat = addressJson.getString("lat");
                Geoaddress geoaddress = new Geoaddress(lng,lat);
                GeoCoordMap geoCoordMap = new GeoCoordMap(name,geoaddress);
                geoCoordMaps.add(geoCoordMap);
                Log.d("MainActivity","name is " + geoCoordMap.getName());
                Log.d("MainActivity","lng " + geoCoordMap.getGeoaddress().getLng());
                Log.d("MainActivity","lat is " + geoCoordMap.getGeoaddress().getLat());
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    //TJData.json 复杂的JSONArray
    private void parseTJDataWithJSONObject(String jsonData){
        List<TJAlarmdata> TJData = new ArrayList<TJAlarmdata>();
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject stationoneJSON = jsonObject.getJSONObject("stationone");
                String nameone = stationoneJSON.getString("name");
                String value = stationoneJSON.getString("value");
                String state = stationoneJSON.getString("state");
                String baojing = stationoneJSON.getString("baojing");
                String guzhang = stationoneJSON.getString("guzhang");
                String tips = stationoneJSON.getString("tips");
                JSONObject stationtwoJSON = jsonObject.getJSONObject("stationtwo");
                String nametwo = stationtwoJSON.getString("name");
                Stationone stationone = new Stationone(nameone,value,state,baojing,guzhang,tips);
                Stationtwo stationtwo = new Stationtwo(nametwo);
                TJAlarmdata tjAlarmdata = new TJAlarmdata(stationone,stationtwo);
                TJData.add(tjAlarmdata);
                Log.d("MainActivity","name is " + tjAlarmdata.getStationone().getName());
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    //TJAlarmdata.json 复杂的JSONObject
    private void parseTJAlarmdataWithJSONObject(String jsonData){
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject stationoneJSON = jsonObject.getJSONObject("stationone");
            String nameone = stationoneJSON.getString("name");
            String value = stationoneJSON.getString("value");
            String state = stationoneJSON.getString("state");
            String baojing = stationoneJSON.getString("baojing");
            String guzhang = stationoneJSON.getString("guzhang");
            String tips = stationoneJSON.getString("tips");
            JSONObject stationtwoJSON = jsonObject.getJSONObject("stationtwo");
            String nametwo = stationtwoJSON.getString("name");
            Stationone stationone = new Stationone(nameone,value,state,baojing,guzhang,tips);
            Stationtwo stationtwo = new Stationtwo(nametwo);
            TJAlarmdata tjAlarmdata = new TJAlarmdata(stationone,stationtwo);
            Log.d("MainActivity","name is " + tjAlarmdata.getStationone().getName());
            Log.d("MainActivity","name is " + tjAlarmdata.getStationtwo().getName());

        } catch (JSONException e){
            e.printStackTrace();
        }
    }

}
