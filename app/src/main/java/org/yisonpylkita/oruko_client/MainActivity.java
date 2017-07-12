package org.yisonpylkita.oruko_client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

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
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "BAR_CODE_MODE");
                startActivityForResult(intent, 0);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent barcodeIntent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = barcodeIntent.getStringExtra("SCAN_RESULT");
                String format = barcodeIntent.getStringExtra("SCAN_RESULT_FORMAT");

                Intent itemIntent = new Intent(MainActivity.this, ItemInfo.class);
                ItemInfoModel model = new ItemInfoModel();
                model.name = "Foo";
                model.id = "123";
                model.description = "Some text";
                itemIntent.putExtra(ITEM_INFO_JSON_NAME, model.toString());
                startActivity(itemIntent);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Ups.. Try again", Toast.LENGTH_SHORT);
            }
        }
    }
}
