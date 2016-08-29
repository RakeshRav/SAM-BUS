package bus.monkeybusiness.com.sambus.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.activity.StudentListActivity;
import bus.monkeybusiness.com.sambus.model.busListResponse.Bu;
import bus.monkeybusiness.com.sambus.utility.Constants;
import bus.monkeybusiness.com.sambus.utility.FontClass;
import rmn.androidscreenlibrary.ASSL;

/**
 * Created by rakesh on 25/7/16.
 */
public class BusListAdapter extends BaseAdapter {

    private static final String TAG = "BusListAdapter";
    Context context;
    LayoutInflater inflater;
    List<Bu> buses = new ArrayList<>();

    public BusListAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Bu> buses) {
        this.buses.clear();
        this.buses.addAll(buses);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return buses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_bus, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.linearLayoutMain = (LinearLayout) view.findViewById(R.id.linearLayoutMain);
            viewHolder.imageViewEventType = (ImageView) view.findViewById(R.id.imageViewEventType);
            viewHolder.textViewEventTitle = (TextView) view.findViewById(R.id.textViewEventTitle);
            viewHolder.textViewEventDesc = (TextView) view.findViewById(R.id.textViewEventDesc);

            viewHolder.textViewEventTitle.setTypeface(FontClass.proximaRegular(context));
            viewHolder.textViewEventDesc.setTypeface(FontClass.proximaRegular(context));
//            viewHolder.textViewEventTime.setTypeface(FontClass.proximaRegular(context));

            ASSL.DoMagic(viewHolder.linearLayoutMain);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textViewEventDesc.setVisibility(View.VISIBLE);
        viewHolder.textViewEventTitle.setText(buses.get(position).getBusName());
        viewHolder.textViewEventDesc.setText("Students : "+buses.get(position).getStudentCount());
        viewHolder.linearLayoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"clicked : "+position);
                Intent studentIntent = new Intent(context, StudentListActivity.class);
                studentIntent.putExtra(Constants.BUS_ID,buses.get(position).getId());
                context.startActivity(studentIntent);
            }
        });
//        viewHolder.textViewEventTitle.setText(events.get(position).getEventName());
//
//        if (events.get(position).getEventDescription() != null && !events.get(position).getEventDescription().equalsIgnoreCase("")) {
//            viewHolder.textViewEventDesc.setText(events.get(position).getEventDescription());
//        } else {
//            viewHolder.textViewEventDesc.setVisibility(View.GONE);
//        }
//
//        if (events.get(position).getEventTypeType().equalsIgnoreCase("userLogin")){
//            viewHolder.imageViewEventType.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.dot_blue));
//        }else if (events.get(position).getEventTypeType().equalsIgnoreCase("batch")){
//            viewHolder.imageViewEventType.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.dot_light_blue));
//        }else {
//            viewHolder.imageViewEventType.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.dot_green));
//        }
//
//        viewHolder.textViewEventTime.setText(Utils.formatDateAndTime(events.get(position).getStartTime()));


        return view;
    }

    public class ViewHolder {
        LinearLayout linearLayoutMain;
        ImageView imageViewEventType;
        TextView textViewEventTitle;
        TextView textViewEventDesc;
        TextView textViewEventTime;
    }
}
