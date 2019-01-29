package retrofitdemo.dengliang.com.retrofitdemo.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 根据后台返回数据格式，统一响应
 * @param
 */
public class NetReqResponse {

    public int status;
    public int code;
    public String data;
    public int count;
    public int page;

    public NetReqResponse(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            code = jsonObject.getInt("code");
            status = jsonObject.getInt("status");
            count = jsonObject.getInt("count");
            page = jsonObject.getInt("page");
            data = jsonObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "NetReqResponse{" + "status=" + status + ", data='" + data + '\'' + ", count=" + count + ", page=" + page + '}';
    }
}
