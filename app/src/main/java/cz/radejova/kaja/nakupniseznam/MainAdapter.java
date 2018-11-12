package cz.radejova.kaja.nakupniseznam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<Item> data;

    public MainAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Item getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_main, parent, false );

        TextView title = view.findViewById(R.id.list_item_main_title);
        TextView count = view.findViewById(R.id.list_item_main_count);

        Item item = data.get(position);

        title.setText(item.getTitle());
        count.setText(item.getCount());
        return view;
    }
}
