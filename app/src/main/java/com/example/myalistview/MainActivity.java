package com.example.myalistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Databasehelper myDB;
    Button btnAdd , btnView;
    EditText editText,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.pass);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnView=(Button)findViewById(R.id.btnView);
        myDB = new Databasehelper(this);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,ViewListContent.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry=editText.getText().toString();


                if (editText.length()!=0){
                    AddData(newEntry);
                    editText.setText("");
                }else {
                    Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    public void AddData(String newEntry){
        boolean insertData=myDB.addData(newEntry);

        if (insertData==true){
            Toast.makeText(MainActivity.this,"no",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(MainActivity.this,"wrong",Toast.LENGTH_LONG).show();
        }
            }
}
