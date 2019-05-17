import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myalistview.Databasehelper;
import com.example.myalistview.MainActivity;
import com.example.myalistview.R;

import java.sql.Array;
import java.util.ArrayList;

public class ViewListContent extends AppCompatActivity {
    Databasehelper myDB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_content);
        ListView listView = (ListView)findViewById(R.id.listview);
        myDB = new Databasehelper(this);
        ArrayList<String> thelist= new ArrayList<>();
        Cursor data =myDB.getListcontent();
        if (data.getCount()==0){
            Toast.makeText(ViewListContent.this,"empty",Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
