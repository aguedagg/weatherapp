package com.aguedagg.weatherapp.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aguedagg.weatherapp.api.base.BaseViewHolder;
import com.aguedagg.weatherapp.data.City;
import com.aguedagg.weatherapp.databinding.ViewholderDataBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private AuthResource<List<City>> source;

    @Inject
    public MainAdapter() {
        source = AuthResource.loading(new ArrayList<>());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(ViewholderDataBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (source.data != null) {
            if (holder instanceof MainViewHolder) {
                ((MainViewHolder) holder).binder.setModel(source.data.get(position));
            }
        }
    }
    
    @Override
    public int getItemCount() {
        if (source.data != null) {
            return source.data.size();
        }
        return 0;
    }

    void setEmptySource() {
        this.source.data.clear();
        List<City> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new City());
        }
        this.source = AuthResource.loading(list);
        notifyDataSetChanged();
    }

    void setSource(List<City> list) {
        this.source.data.clear();
        this.source = AuthResource.success(list);
        notifyDataSetChanged();
    }

    public class MainViewHolder extends BaseViewHolder implements View.OnClickListener {

        private ViewholderDataBinding binder;

        MainViewHolder(ViewholderDataBinding binding) {
            super(binding.getRoot());
            this.binder = binding;
            binder.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // TODO: open detail activity
            //Intent intent = new Intent(this, DetailActivity.class);
            //intent.putExtra(ID_CITY, city);
            //startActivity(intent);
        }
    }
}
