package com.example.x7dev_team.order_48;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    ArrayList<List> lists;
    LayoutInflater inflater;
    Context context;

    // констуктор класса
    ListViewAdapter(Context context, ArrayList<List> list){
        this.context = context;
        this.lists = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return lists.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_item, parent, false);
        }

        List l = getProduct(position);

        ((TextView) view.findViewById(R.id.tvNumber)).setText(Integer.toString(l.index_number));

        return view;
    }

    // товар по позиции
    List getProduct(int position) {
        return ((List) getItem(position));
    }
}
