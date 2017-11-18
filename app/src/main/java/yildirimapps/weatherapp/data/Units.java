package yildirimapps.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by hmy on 10/12/2017.
 */

public class Units implements JSONPopulator {

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {

        temperature = data.optString("temp");
    }
}
