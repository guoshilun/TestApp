package com.test.appe.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Adapter的优化简写
 *
 * @param <T>
 * @author zhaotun
 */
public abstract class SimpleBaseAdapter<T> extends BaseAdapter {

    protected int VIEW_TYPE_COUNT = 1;
    protected int ITEM_VIEW_TYPE_ZERO = 0;

    protected List<T> mData;
    protected Context mContext;

    public SimpleBaseAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.mData = data == null ? new ArrayList<T>() : new ArrayList<>(data);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        if (position < 0 || mData == null || position >= mData.size()) {
            return null;
        } else {
            return mData.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 该方法需要子类实现，需要返回item布局的resource id
     *
     * @return
     */
    public abstract int getItemResId(int position);

    /**
     * 使用该getItemView方法替换原来的getView方法，需要子类实现
     *
     * @param position
     * @param holder
     * @param info
     * @return
     */
    public abstract void onBindViewHolder(int position, View convertView, ViewHolder holder, T info);

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return ITEM_VIEW_TYPE_ZERO;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, getItemResId(position), null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        onBindViewHolder(position, convertView, holder, getItem(position));

        return convertView;
    }

    public boolean add(T elem) {
        boolean result = mData.add(elem);
        notifyDataSetChanged();
        return result;
    }

    public void add(int location, T elem) {
        mData.add(location, elem);
        notifyDataSetChanged();
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean result = mData.addAll(collection);
        notifyDataSetChanged();
        return result;
    }

    public boolean addAll(int location, Collection<? extends T> collection) {
        boolean result = mData.addAll(location, collection);
        notifyDataSetChanged();
        return result;
    }

    public boolean remove(T elem) {
        boolean result = mData.remove(elem);
        notifyDataSetChanged();
        return result;
    }

    public T remove(int location) {
        T t = mData.remove(location);
        notifyDataSetChanged();
        return t;
    }

    public boolean removeAll(Collection<? extends T> collection) {
        boolean result = mData.removeAll(collection);
        notifyDataSetChanged();
        return result;
    }

    public void replaceAll(List<T> collection) {
        if (collection != null) {
            mData.clear();
            mData.addAll(collection);
        } else {
            mData = collection;
        }
        notifyDataSetChanged();
    }

    public void clearData() {
        if (mData != null) {
            mData.clear();
            notifyDataSetChanged();
        }
    }

    public List<T> getDataList() {
        return mData;
    }


    public static class ViewHolder {

        private SparseArray<View> views = new SparseArray<View>();
        private View convertView;

        public ViewHolder(View convertView) {
            this.convertView = convertView;
        }

        @SuppressWarnings("unchecked")
        public <E extends View> E getView(int resId) {
            View v = views.get(resId);
            if (null == v) {
                v = convertView.findViewById(resId);
                views.put(resId, v);
            }

            return (E) v;
        }
    }

}
