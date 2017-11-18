package yildirimapps.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by hmy on 10/12/2017.
 */

public class Channel implements JSONPopulator {

    private Units units;
    private Item item;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {

        return item;
    }

    @Override
    public void populate(JSONObject data) {

        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));

    }
}
