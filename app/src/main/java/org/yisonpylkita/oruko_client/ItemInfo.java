package org.yisonpylkita.oruko_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

public class ItemInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String dataAsString = getIntent().getStringExtra(MainActivity.ITEM_INFO_JSON_NAME);
        ItemInfoModel model;
        try {
            model = new ItemInfoModel(dataAsString);
        } catch (Exception ex) {
            Log.e(ItemInfo.class.getName(), "ItemInfo input data was invalid -> " + ex.getMessage());
            finish();
            return;
        }
        setContentView(R.layout.activity_item_info);
        TextView nameView = (TextView)findViewById(R.id.name);
        nameView.setText(model.id);
        TextView idView = (TextView)findViewById(R.id.id);
        idView.setText(model.id);
        TextView descriptionView = (TextView)findViewById(R.id.description);
        descriptionView.setText(model.description);
    }
}
