package bus.monkeybusiness.com.sambus.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rey.material.widget.Button;
import com.squareup.picasso.Picasso;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bus.monkeybusiness.com.sambus.R;
import bus.monkeybusiness.com.sambus.model.busListResponse.BusListResponse;
import bus.monkeybusiness.com.sambus.model.busStudentList.BusStudentList;
import bus.monkeybusiness.com.sambus.model.busStudentList.Student;
import bus.monkeybusiness.com.sambus.model.studentsResponse.StudentsListResponseData;
import bus.monkeybusiness.com.sambus.retrofit.RestClient;
import bus.monkeybusiness.com.sambus.utility.Constants;
import bus.monkeybusiness.com.sambus.utility.Log;
import bus.monkeybusiness.com.sambus.utility.preferences.Prefs;
import bus.monkeybusiness.com.sambus.utility.preferences.PrefsKeys;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rmn.androidscreenlibrary.ASSL;

/**
 * @author rakesh
 */
public class StudentListActivity extends AppCompatActivity implements View.OnClickListener{

    public final String TAG = "FriendsActivity";
//    RelativeLayout relativeLayoutMenu;
//    TextView textViewActionTitle;

    //    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return rootView;
//    }

    ListView listViewStudents;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        new ASSL(this, (ViewGroup) findViewById(R.id.root), 1134, 720,
                false);

//        toggleLayouts(linearlayoutMyclass, textViewMyclass);
//        Utils.classFlag = 2;

//        Utils.classFlag = 6;
//
//        toggleLayouts(linearlayoutMyclassDown, textViewMyclassDown);

        listViewStudents = (ListView) findViewById(R.id.listViewStudents);

//        relativeLayoutMenu = (RelativeLayout) findViewById(R.id.relativeLayoutMenu);
//        textViewActionTitle = (TextView) findViewById(R.id.textViewActionTitle);

//        relativeLayoutMenu.setOnClickListener(this);
//        textViewActionTitle.setOnClickListener(this);

//        textViewActionTitle.setText("My Class");

        Intent intent = getIntent();
        int busId = intent.getIntExtra(Constants.BUS_ID, 0);

        getStudentListServerCall(busId);

    }

    List<Student> studentsList;
    public void setUIData(BusStudentList busStudentList) {

        studentsList= busStudentList.getData().getBus().getStudents();
        if (studentsList.size()>0){
            Log.d(TAG, "Students : " + studentsList.size());

            Collections.sort(studentsList, new Comparator<Student>() {
                @Override
                public int compare(Student self, Student other) {
                    return String.valueOf(self.getStudentName()).compareTo(String.valueOf(other.getStudentName()));
                }
            });

            FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
            listViewStudents.setAdapter(new FriendsAdapter(this, studentsList, settings));
            listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Friend f = (Friend) listViewStudents.getAdapter().getItem(position);

                    Log.d(TAG, "Position : " + position);
                    StudentsListResponseData studentsListResponseData = Prefs.with(StudentListActivity.this).getObject(PrefsKeys.STUDENT_LIST_RESPONSE_DATA, StudentsListResponseData.class);

                    if (studentsListResponseData != null) {
                        Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
                        intent.putExtra(Constants.STUDENT_ID, studentsList.get(position).getId());
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relativeLayoutMenu:
                break;
        }
    }

    public void getStudentListServerCall(final int busId) {

        String xCookies = Prefs.with(this).getString(PrefsKeys.X_COOKIES, "");
        String aCookies = Prefs.with(this).getString(PrefsKeys.A_COOKIES, "");

        RestClient.getApiServicePojo(xCookies, aCookies).apiCallGetStudentsByBusID(String.valueOf(busId), new Callback<BusStudentList>() {

            @Override
            public void success(BusStudentList busStudentList, Response response) {

//                Log.d("LectureAdapter", "Response : " + studentsListResponseData);
                Log.d("LectureAdapter", "Response : " + new Gson().toJson(busStudentList));
                Prefs.with(StudentListActivity.this).save(PrefsKeys.STUDENT_LIST_RESPONSE_DATA, busStudentList);
                setUIData(busStudentList);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("LectureAdapter", "error : " + error.toString());
            }
        });
    }

    class FriendsAdapter extends BaseFlipAdapter<Student> {

        private final int PAGES = 3;
//        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2, R.id.interest_3, R.id.interest_4, R.id.interest_5,R.id.interest_6};

        public FriendsAdapter(Context context, List<Student> items, FlipSettings settings) {
            super(context, items, settings);

        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Student friend1, Student friend2) {
            final FriendsHolder holder;

            if (convertView == null) {
                holder = new FriendsHolder();
                convertView = getLayoutInflater().inflate(R.layout.student_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.student_info, parent, false);
                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);
                holder.className = (TextView) holder.infoPage.findViewById(R.id.className);
                holder.fatherName = (TextView) holder.infoPage.findViewById(R.id.fatherName);
                holder.dateOfBirth = (TextView) holder.infoPage.findViewById(R.id.dateOfBirth);

//                for (int id : IDS_INTEREST)
//                    holder.interests.add((ImageView) holder.infoPage.findViewById(id));

                holder.buttonViewRemarks = (Button) holder.infoPage.findViewById(R.id.buttonViewRemarks);
                holder.buttonViewProfile = (Button) holder.infoPage.findViewById(R.id.buttonViewProfile);

                convertView.setTag(holder);
            } else {
                holder = (FriendsHolder) convertView.getTag();
            }

            switch (position) {
                // Merged page with 2 listViewStudents
                case 1:
                    Log.d("1234", "image");
                    if (friend1.getPicture() != null) {
                        Log.d(TAG, "url_photo : " + friend1.getPicture().getUrl());
//                        Picasso.with(FriendsActivity.this).invalidate(friend1.getPicture().getUrl());
                        Picasso.with(StudentListActivity.this).load(friend1.getPicture().getUrl()).fit().into(holder.leftAvatar);
                    } else {
                        holder.leftAvatar.setImageResource(R.drawable.anastasia);
                    }
                    if (friend2 != null) {
                        if (friend2.getPicture() != null) {
//                            Picasso.with(FriendsActivity.this).invalidate(friend2
//                                    .getPicture().getUrl());
                            Picasso.with(StudentListActivity.this).load(friend2.getPicture().getUrl()).fit().into(holder.rightAvatar);
                        } else {
                            holder.rightAvatar.setImageResource(R.drawable.irene);
                        }
                    }
//                    if (friend2 != null)
//                        holder.rightAvatar.setImageResource(R.drawable.irene);
                    break;
                default:
                    fillHolder(holder, position == 0 ? friend1 : friend2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(FriendsHolder holder, final Student friend) {
            if (friend == null)
                return;
//            Iterator<ImageView> iViews = holder.interests.iterator();
//            Iterator<String> iInterests = friend.getInterests().iterator();
//            while (iViews.hasNext() && iInterests.hasNext())
//                if (iInterests.next().equalsIgnoreCase("A"))
//                {
//                    iViews.next().setImageDrawable(drawableAbsent);
//                }else {
//                    iViews.next().setImageDrawable(drawablePresent);
//                }
            holder.infoPage.setBackgroundColor(getResources().getColor(R.color.purple));
            holder.className.setText("Roll No. " + String.valueOf(friend.getRollno()));
            holder.nickName.setText(friend.getStudentName());
            holder.fatherName.setText("Father's Name : " + friend.getFatherName());
            holder.dateOfBirth.setText("DOB : " + friend.getDob());
            holder.buttonViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "View Profile : " + friend.getStudentName());
                }
            });

            holder.buttonViewRemarks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "View Remarks : " + friend.getStudentName());
                }
            });
        }

        class FriendsHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;

            //            List<ImageView> interests = new ArrayList<>();
            TextView nickName;
            TextView className;
            TextView fatherName;
            TextView dateOfBirth;

            Button buttonViewRemarks;
            Button buttonViewProfile;
        }
    }

}
