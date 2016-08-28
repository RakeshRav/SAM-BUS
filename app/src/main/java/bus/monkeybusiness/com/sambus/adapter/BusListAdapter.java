package bus.monkeybusiness.com.sambus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.utility.FontClass;
import rmn.androidscreenlibrary.ASSL;

/**
 * Created by rakesh on 25/7/16.
 */
public class BusListAdapter extends BaseAdapter {

    private static final String TAG = "BusListAdapter";
    Context context;
    LayoutInflater inflater;
//    List<Event> events = new ArrayList<>();

    public BusListAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    public void setData(List<Event> events) {
////        this.events.clear();
////        this.events.addAll(events);
////        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return 5;
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
    public View getView(int position, View convertView, ViewGroup parent) {

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
