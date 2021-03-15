package com.sadibul.oxyzen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sadibul.oxyzen.databinding.ListItemBinding;
import com.sadibul.oxyzen.model.ScannedData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By sakibul.haque on 15-03-2021
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>
{
    private Context context;
    private ArrayList<ScannedData> mList;
    private ListItemBinding binding;

    public DataAdapter(Context context, ArrayList<ScannedData> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        binding = ListItemBinding.inflate(inflater,parent,false);
        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.itemBinding.data.setText(mList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{
        private ListItemBinding itemBinding;

        public DataViewHolder(ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public void updateList(ArrayList<ScannedData> updatedList)
    {
        mList = updatedList;
        notifyDataSetChanged();
    }

    public ScannedData getDataAt(int position)
    {
        return mList.get(position);
    }
}
