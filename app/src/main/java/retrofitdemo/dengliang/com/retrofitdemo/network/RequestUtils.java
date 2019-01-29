package retrofitdemo.dengliang.com.retrofitdemo.network;

import android.support.v7.app.AppCompatActivity;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.Map;

/**
 * 项目请求再次封装 归纳类
 */
public class RequestUtils {

    public static void getData(AppCompatActivity context, String path, Map<String,String> map, NetWorkObserver observer){
        RetrofitUtils.getApiService()
                .getData(path,map)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);

    }
}

