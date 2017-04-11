package com.thougthworks.vozdamulher.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.thougthworks.vozdamulher.R;
import com.thougthworks.vozdamulher.model.Bus;

import java.util.ArrayList;

/**
 * Created by hortoni on 09/04/17.
 */

public class BusAutoCompleteAdapter extends ArrayAdapter<Bus> {

    private ArrayList<Bus> items;
    private ArrayList<Bus> itemsAll;
    private ArrayList<Bus> suggestions;
    private int viewResourceId;

    public BusAutoCompleteAdapter(Context context, int viewResourceId, ArrayList<Bus> items) {
        super(context, viewResourceId, items);
        this.items = items;
        this.itemsAll = (ArrayList<Bus>) items.clone();
        this.suggestions = new ArrayList<Bus>();
        this.viewResourceId = viewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(viewResourceId, null);
        }
        Bus item = items.get(position);
        TextView busName = (TextView) v.findViewById(R.id.item_auto_complete_bus_name);
        busName.setText(item.getName());
        return v;
    }

    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {
        @Override
        public String convertResultToString(Object resultValue) {
            String str = ((Bus)(resultValue)).getName();
            return str;
        }
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if(constraint != null) {
                suggestions.clear();
                for (Bus bus: itemsAll) {
                    if(bus.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        suggestions.add(bus);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<Bus> filteredList = (ArrayList<Bus>) results.values;
            if(results != null && results.count > 0) {
                clear();
                for (Bus bus: filteredList) {
                    add(bus);
                }
                notifyDataSetChanged();
            }
        }
    };
}
