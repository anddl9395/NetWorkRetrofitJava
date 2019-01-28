package retrofitdemo.dengliang.com.retrofitdemo.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * retrofit2 Api接口
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("{path}")
    Observable<String> getData(@Path(value = "path",encoded = true) String path, @FieldMap Map<String, String> paramsMap);
}
