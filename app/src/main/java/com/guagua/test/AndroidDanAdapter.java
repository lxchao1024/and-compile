package com.guagua.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Copyright (C), 2020-2020, guagua
 *
 * @author lxc
 * Date: 2020/11/18 14:22
 * Version: 1.0.0
 * Description:
 * History:
 * <author> <time> <version> <desc>
 */
public class AndroidDanAdapter extends RecyclerView.Adapter<AndroidDanAdapter.MyHolder> {

    private List<AndroidDanBean> source;
    private int type;

    public AndroidDanAdapter(int type) {
        if (type == 1) {
            source = Utils.getCompileDan(App.getAppContext());
        } else if (type == 2) {
            source = Utils.getCompileDuo(App.getAppContext());
        } else {
            source = Utils.getAndroidSingle(App.getAppContext());
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText((position + 1) + ". " + source.get(position).getTitle());
        if ("".equals(source.get(position).getE())) {
            holder.content.setText("选项A: " + source.get(position).getA() +
                    "\n选项B: " + source.get(position).getB() +
                    "\n选项C: " + source.get(position).getC() +
                    "\n选项D: " + source.get(position).getD());
        } else {
            holder.content.setText("选项A: " + source.get(position).getA() +
                    "\n选项B: " + source.get(position).getB() +
                    "\n选项C: " + source.get(position).getC() +
                    "\n选项D: " + source.get(position).getD() +
                    "\n选项E: " + source.get(position).getE());
        }
        holder.result.setText("正确答案：" + source.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        return null == source ? 0 : source.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView content;
        TextView result;

        public MyHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            result = itemView.findViewById(R.id.result);
        }
    }
}
