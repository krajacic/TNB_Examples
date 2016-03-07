package cawabanga.com.tnb_examples;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by croatan on 5.3.2016. TNB_Examples.
 */
public class SQLiteExample extends AppCompatActivity implements View.OnClickListener {

    Button sqlUpdate, sqlView;
    EditText sqlName, sqlHotness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqliteexample);
        sqlName = (EditText) findViewById(R.id.etSQLName);
        sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlView = (Button) findViewById(R.id.bSQLopenView);
        sqlUpdate.setOnClickListener(this);
        sqlView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSQLUpdate:
                boolean didItWork = true;
                try {
                    String name = sqlName.getText().toString();
                    String hotness = sqlHotness.getText().toString();

                    HotOrNot entry = new HotOrNot(SQLiteExample.this);
                    entry.open();
                    entry.createEntry(name, hotness);
                    entry.close();
                }catch (Exception e){
                    didItWork = false;
                }finally {
                    if (didItWork){
                        Dialog d = new Dialog(this);
                        d.setTitle("Yeah!");
                        TextView tv = new TextView(this);
                        tv.setText("Succes!");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;
            case R.id.bSQLopenView:
                Intent i = new Intent("cawabanga.com.tnb_examples.SQLVIEW");
                startActivity(i);
                break;
        }
    }
}
