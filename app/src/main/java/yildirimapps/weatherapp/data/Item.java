package yildirimapps.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by hmy on 10/12/2017.
 */

public class Item implements JSONPopulator {

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {

        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
