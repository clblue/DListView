package com.clblue.android.draglistview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DragListView1.DragItemListener dragItemListener;

    private DragListView1 dragListView;

    private DragListAdapter adapter;

    private List<ListItemNormal> listItemNormals = new ArrayList<>();

    private boolean canDrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        listItemNormals.add(new ListItemNormal("1"));
        listItemNormals.add(new ListItemNormal("2"));
        listItemNormals.add(new ListItemNormal("3"));
        listItemNormals.add(new ListItemNormal("4"));
        listItemNormals.add(new ListItemNormal("5"));
        listItemNormals.add(new ListItemNormal("6"));
        listItemNormals.add(new ListItemNormal("7"));
        listItemNormals.add(new ListItemNormal("8"));
        listItemNormals.add(new ListItemNormal("9"));
        listItemNormals.add(new ListItemNormal("10"));
        listItemNormals.add(new ListItemNormal("11"));
        listItemNormals.add(new ListItemNormal("12"));
        listItemNormals.add(new ListItemNormal("13"));
        listItemNormals.add(new ListItemNormal("14"));
        listItemNormals.add(new ListItemNormal("15"));
    }

    private void initView() {
        dragItemListener = new DragListView1.SimpleAnimationDragItemListener() {
            @Override
            public boolean canExchange(int srcPosition, int position) {

                Log.e("canExchange", srcPosition + "================" + position);
                ListItemNormal listItemNormal = listItemNormals.get(srcPosition);
                if(position == srcPosition)
                {
                    return false;
                }
                if(Math.abs(position - srcPosition) == 1)
                {
                    listItemNormals.set(srcPosition,listItemNormals.get(position));
                    listItemNormals.set(position,listItemNormal);
                }
                else if(srcPosition>position) {
                    List<ListItemNormal> temList = listItemNormals.subList(position, srcPosition - 1);
                    listItemNormals.set(position,listItemNormal);
                    for (int i = position+1; i <= srcPosition; i++) {
                        listItemNormals.set(i,temList.remove(0));
                    }
                    listItemNormals = temList;
                }
                else if(srcPosition < position) {
                    List<ListItemNormal> temList = listItemNormals.subList(srcPosition + 1, position);
                    for (int i = srcPosition; i < position; i++) {
                        listItemNormals.set(i, temList.remove(0));
                    }
                    listItemNormals.set(position, listItemNormal);
                    listItemNormals = temList;
                }
                return true;
            }


            @Override
            public void startDrag(int position, View itemView) {
                super.startDrag(position, itemView);

            }

            @Override
            public void onExchange(int srcPosition, int position, View srcItemView, View itemView) {
                super.onExchange(srcPosition, position, srcItemView, itemView);
                adapter.notifyDataSetChanged();

            }

            @Override
            public boolean canDrag(View itemView, int x, int y) {
                return true;
            }

            @Override
            public void beforeDrawingCache(View itemView) {

            }

            @Override
            public Bitmap afterDrawingCache(View itemView, Bitmap bitmap) {
                return null;
            }
        };
        adapter = new DragListAdapter(this, listItemNormals);
        dragListView = (DragListView1) findViewById(R.id.drag_list);
        dragListView.setDragItemListener(dragItemListener);
        dragListView.setAdapter(adapter);

    }


}
