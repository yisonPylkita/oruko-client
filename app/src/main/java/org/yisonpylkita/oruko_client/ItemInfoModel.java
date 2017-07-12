package org.yisonpylkita.oruko_client;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemInfoModel {
    public String name;
    public String id;
    public String description;

    public ItemInfoModel() {}

    public ItemInfoModel(String jsonData) throws JSONException
    {
        JSONObject data = new JSONObject(jsonData);
        name = data.getString("name");
        id = data.getString("id");
        description = data.getString("description");
    }

    @Override
    public String toString() {
        return "{" +
                "name: \"" + name + "\"," +
                "id: \"" + id + "\"," +
                "description: \"" + description + "\"" +
                "}";
    }
}
