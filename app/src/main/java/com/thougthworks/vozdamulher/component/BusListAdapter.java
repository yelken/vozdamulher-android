package com.thougthworks.vozdamulher.component;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.thougthworks.vozdamulher.R;
import com.thougthworks.vozdamulher.model.Bus;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BusListAdapter extends ArrayAdapter<Bus> {
	Context context;
	int layoutResourceId;

	ArrayList<Bus> originalList;
	private ArrayList<Bus> data = new ArrayList<Bus>();
	public DecimalFormat df = new DecimalFormat("#.00");

	public BusListAdapter(Context context, int layoutResourceId,
                          ArrayList<Bus> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RewardsHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new RewardsHolder();
			holder.txtBusName = (TextView) row.findViewById(R.id.item_bus_name);
			holder.txtBusPosition = (TextView) row.findViewById(R.id.item_bus_position);
			holder.txtBusAmount = (TextView) row.findViewById(R.id.item_bus_amount);
			row.setTag(holder);
		} else {
			holder = (RewardsHolder) row.getTag();
		}
		Bus item = data.get(position);
		holder.txtBusPosition.setText(position + 1 + "º - " );
		holder.txtBusName.setText(item.getName());
		holder.txtBusAmount.setText(String.valueOf(item.getAmount() + " Denúncias"));

		return row;
	}

	static class RewardsHolder {
		TextView txtBusName;
		TextView txtBusPosition;
		TextView txtBusAmount;
	}

}
