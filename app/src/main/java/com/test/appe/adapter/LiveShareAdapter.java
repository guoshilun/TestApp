package com.test.appe.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.appe.R;

import java.util.ArrayList;

/**
 * Created by zhaot on 2016/2/27.
 */
public class LiveShareAdapter extends SimpleBaseAdapter<String> {

    public LiveShareAdapter(Context context, ArrayList<String> data) {
        super(context, data);
    }

    @Override
    public int getItemResId(int position) {
        return R.layout.layout_item_for_dialog_live_share;
    }

    @Override
    public void onBindViewHolder(int position, View convertView, ViewHolder holder, String info) {
        TextView tvName = holder.getView(R.id.tv_name);
        tvName.setText(info);
    }
}
