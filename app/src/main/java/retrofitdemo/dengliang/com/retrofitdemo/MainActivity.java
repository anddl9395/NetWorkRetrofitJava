package retrofitdemo.dengliang.com.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofitdemo.dengliang.com.retrofitdemo.network.NetReqResponse;
import retrofitdemo.dengliang.com.retrofitdemo.network.NetWorkObserver;
import retrofitdemo.dengliang.com.retrofitdemo.network.RequestUtils;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        getData();

    }

    private void getData() {
        Map<String,String> map = new HashMap<>();
        map.put("clientId","");
        map.put("token","");
        map.put("uid",0+"");

        RequestUtils.getData(this, MConfig.index, map, new NetWorkObserver() {
            @Override
            public void onSuccess(String msg, String result) {
                NetReqResponse netReqResponse = new NetReqResponse(result);
                int state = netReqResponse.status;
                try {
                    JSONObject array = new JSONObject(netReqResponse.data);
                    Log.i("res","msg："+msg+"============result："+array.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(Throwable e, String errorMsg) {
                Log.i("res","=========onFailure===========");
            }

            @Override
            public void onError(String errorMsg) {
                Log.i("res","=========onError===========");
            }
        });

    }
}
