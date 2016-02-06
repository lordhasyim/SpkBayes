package com.hasyim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hasyim.response.ViewData;
import com.hasyim.spkbayes.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created by Diiyo on 12/20/15.
 */
public class ViewDataAdapter extends RecyclerView.Adapter<ViewDataAdapter.ViewHolder> {

    //context
    Context context;

    //menangkap list yang akan digunakan
    //list yg ada di viewData
    List<ViewData> items;

    OnItemClickListener onItemClickListener;

    public ViewDataAdapter(Context context, List<ViewData> items) {
        this.context = context;
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_data, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ViewData data = items.get(position);

        holder.txtId.setText(data.getId());
        holder.txtNoToko.setText(data.getNo_toko());
        holder.txtStatus.setText(data.getStatus());
        holder.txtAlamat.setText(data.getAlamat());

        holder.areaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position);
                }
            }
        });

    }

    //utk memastikan jumlah item
    @Override
    public int getItemCount() {
        return items.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.spv_area_item)
        LinearLayout areaItem;
        @Bind(R.id.txt_id)
        TextView txtId;
        @Bind(R.id.txt_no_toko)
        TextView txtNoToko;
        @Bind(R.id.txt_alamat)
        TextView txtAlamat;
        @Bind(R.id.txt_status)
        TextView txtStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface OnItemClickListener {
        void onClick(int position);
    }
}
