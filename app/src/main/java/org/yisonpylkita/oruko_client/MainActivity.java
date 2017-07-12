package org.yisonpylkita.oruko_client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String ITEM_INFO_JSON_NAME = "item_info_data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItemInfo.class);
                ItemInfoModel model = new ItemInfoModel();
                model.name = "Foo";
                model.id = "123";
                model.description = "Some text";
                intent.putExtra(ITEM_INFO_JSON_NAME, model.toString());
                startActivity(intent);
            }
        });
    }
}
