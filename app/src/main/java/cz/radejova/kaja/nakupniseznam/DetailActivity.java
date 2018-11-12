package cz.radejova.kaja.nakupniseznam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class DetailActivity extends AppCompatActivity {
    private TextView detail_title;
    private TextView detail_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Hawk.init(this).build();

        String title = getIntent().getStringExtra("title");
        String count = getIntent().getStringExtra("count");

        detail_title = findViewById(R.id.detail_title);
        detail_count = findViewById(R.id.detail_count);

        detail_title.setText(title);
        detail_count.setText(count);




    }
}
