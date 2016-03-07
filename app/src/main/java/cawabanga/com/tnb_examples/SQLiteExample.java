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

    Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete;
    EditText sqlName, sqlHotness, sqlRow;

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

        sqlRow = (EditText) findViewById(R.id.etSQLrowInfo);
        sqlModify = (Button) findViewById(R.id.bSQLmodify);
        sqlGetInfo = (Button) findViewById(R.id.bGetInfo);
        sqlDelete = (Button) findViewById(R.id.bSQLdelete);

        sqlModify.setOnClickListener(this);
        sqlGetInfo.setOnClickListener(this);
        sqlDelete.setOnClickListener(this);
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
                } catch (Exception e) {
                    didItWork = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle(":'(");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                } finally {
                    if (didItWork) {
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
            case R.id.bGetInfo:
                String s = sqlRow.getText().toString();
                long l = Long.parseLong(s);
                HotOrNot hon = new HotOrNot(this);
                hon.open();
                String returnedName = hon.getName(l);
                String returnedHotness = hon.getHotness(l);
                hon.close();

                sqlName.setText(returnedName);
                sqlHotness.setText(returnedHotness);

                break;
            case R.id.bSQLmodify:
                break;
            case R.id.bSQLdelete:
                break;
        }
    }
}
