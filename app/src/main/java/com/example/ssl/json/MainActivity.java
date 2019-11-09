package com.example.ssl.json;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ssl.json.adapter.MenuAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ssl.json.bean.HttpResult1;
import com.example.ssl.json.bean.Menu;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnshow;
    private RecyclerView mRecyclerView;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnshow = (Button) findViewById(R.id.btn_Show);
        mRecyclerView = (RecyclerView) findViewById(R.id.Recycler_View);

        btnshow.setOnClickListener(this);

//        创建handler接受子线程
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
//                获取子线程里面的数据
                String strdata = msg.getData().getString("data");
//                获取网络数据资源
                Gson gson = new Gson();
                HttpResult1 httpResult1 = gson.fromJson(strdata,HttpResult1.class);
                List<Menu> data = httpResult1.getData();
//                适配器
                MenuAdapter adapter = new MenuAdapter(R.layout.item_view,data);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecyclerView.setAdapter(adapter);

            }
        };


    }

    @Override
    public void onClick(View v) {
//        创建子线程 得到服务器端的数据；
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    URL url = new URL("http://10.0.2.2/img/getdata.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    if (urlConnection.getResponseCode() == 200) {
                        InputStream is = urlConnection.getInputStream();
                        StringBuffer sBuffer = new StringBuffer();
                        int hasRead = -1;
                        byte[] buffer = new byte[512];
                        while ((hasRead = is.read(buffer))!= -1) {
                            sBuffer.append(new String(buffer, 0, hasRead));
                        }
//                        通过handler获取消息
                        Message msg= mHandler.obtainMessage();
                        Bundle bundle = new Bundle();
                        bundle.putString("data",sBuffer.toString());
                        msg.setData(bundle);
                        mHandler.sendMessage(msg);


                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }
}





