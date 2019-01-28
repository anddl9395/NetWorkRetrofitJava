package retrofitdemo.dengliang.com.retrofitdemo.network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * 数据返回统一处理
 * @param
 */
public abstract class NetWorkObserver implements Observer<String> {
    private static final String TAG = "NetWorkObserver";
    @Override
    public void onNext(String result) {
        try {
            JSONObject json = new JSONObject(result);
            int code = json.getInt("code");
            String msg = json.getString("msg");

            if(code == 0){ // 根据自己项目服务器的约定而改变
                onSuccess(msg, result);
            }else{
                onFail(new Exception(msg),msg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onError(Throwable e) {
        onError(RxExceptionUtil.exceptionHandler(e));
    }
    @Override
    public void onComplete() {
    }
    @Override
    public void onSubscribe(Disposable d) {
    }

    public abstract void onSuccess(String msg, String result);

    public abstract void onFail(Throwable e, String errorMsg);

    public abstract void onError(String errorMsg);

}
