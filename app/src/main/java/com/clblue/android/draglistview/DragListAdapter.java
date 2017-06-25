package com.clblue.android.draglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/***
 * 自定义适配器
 */
public class DragListAdapter extends BaseAdapter {

    private List<ListItemNormal> listItemNormals;

    private Context context;

    public DragListAdapter(Context context, List<ListItemNormal> listItemNormals) {
        this.listItemNormals = listItemNormals;
        this.context = context;
    }

    public DragListAdapter() {
    }

    @Override
    public int getCount() {
        return listItemNormals.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.drag_list_item,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.drag_list_item_text);
            holder.tv2 = (TextView) convertView.findViewById(R.id.drag_list_item_text2);
            holder.ckb = (CheckBox) convertView.findViewById(R.id.check_item);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        ListItemNormal listItemNormal = listItemNormals.get(position);
        holder.tv.setText(listItemNormal.getValue());
        holder.tv2.setText(listItemNormal.getDst());
//        holder.ckb

        return convertView;
    }

    class ViewHolder
    {
        TextView tv;
        CheckBox ckb;
        TextView tv2;
    }
}
