package bus.monkeybusiness.com.sambus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.model.studentSearchdata.Student;
import rmn.androidscreenlibrary.ASSL;

/**
 * Created by rakesh on 25/7/16.
 */
public class StudentSearchListAdapter extends ArrayAdapter<Student> {

    private static final String TAG = "EventsListAdapter";
    Context context;
    LayoutInflater inflater;
    List<Student> students = new ArrayList<>();

    public StudentSearchListAdapter(Context context, List<Student> students) {
        super(context, R.layout.item_search_event);
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.students = students;
    }

    public void setData(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
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
            view = inflater.inflate(R.layout.item_search_event, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.linearLayoutMain = (LinearLayout) view.findViewById(R.id.linearLayoutMain);
            viewHolder.textViewRollNo = (TextView) view.findViewById(R.id.textViewRollNo);
            viewHolder.textViewEventName = (TextView) view.findViewById(R.id.textViewEventTitle);
            viewHolder.textViewEventClass = (TextView) view.findViewById(R.id.textViewEventDesc);

            ASSL.DoMagic(viewHolder.linearLayoutMain);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textViewEventClass.setVisibility(View.VISIBLE);
        viewHolder.textViewRollNo.setText(students.get(position).getRollno());
        viewHolder.textViewEventName.setText(students.get(position).getStudentName());
        viewHolder.textViewEventClass.setText(students.get(position).getBatch().getClassAlias());

        return view;
    }

    public class ViewHolder {
        LinearLayout linearLayoutMain;
        TextView textViewRollNo;
        TextView textViewEventName;
        TextView textViewEventClass;
    }
}
