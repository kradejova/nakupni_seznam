package cz.radejova.kaja.nakupniseznam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText main_title;
    private EditText main_count;
    private MainAdapter mainAdapter;
    private ListView main_list;
    private ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_title = findViewById(R.id.main_title);
        main_count = findViewById(R.id.main_count);
        main_list = findViewById(R.id.main_list);

        Hawk.init(this).build();

        arrayList = Hawk.get("data", new ArrayList<Item>());
        //arrayList = new ArrayList();


        mainAdapter = new MainAdapter(this, arrayList);
        main_list.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();

        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", main_title.getText());
                intent.putExtra("count", main_count.getText());
                startActivity(intent);


            }
        });

        /*main_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                main_list.remove(position);
                mainAdapter.notifyDataSetChanged();
                Hawk.put("data", main_list);
                return true;
            }
        });*/

    }

    @Override
    protected void onStop() {
        Hawk.put("data", arrayList);
        super.onStop();
    }

    public void pridatPolozku(View view) {
        String title = main_title.getText().toString();
        String count = main_count.getText().toString();

        Item item = new Item(title, count);
        arrayList.add(item);
        mainAdapter.notifyDataSetChanged();

        main_title.setText("");
        main_count.setText("");


    }
}
