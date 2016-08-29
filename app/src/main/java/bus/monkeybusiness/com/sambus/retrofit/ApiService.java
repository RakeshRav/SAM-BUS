package bus.monkeybusiness.com.sambus.retrofit;

//
//import com.monkeybusiness.bus.model.ExamGroupData.ExamGroupData;
//import com.monkeybusiness.bus.model.addEventResponse.AddEventResponseData;
//import com.monkeybusiness.bus.model.addRemarksResponseData.AddRemarksResponseData;
//import com.monkeybusiness.bus.model.addTestResponse.AddTestResponse;
//import com.monkeybusiness.bus.model.attdSavedResponse.AttdSavedResponseData;
//import com.monkeybusiness.bus.model.batchesData.BatchesResponseData;
//import com.monkeybusiness.bus.model.checkLoginResponse.CheckLoginResponse;
//import com.monkeybusiness.bus.model.eventResponse.EventResponseData;
//import com.monkeybusiness.bus.model.examData.ExamData;
//import com.monkeybusiness.bus.model.examStudentMarks.ExamStudentMarks;
//import com.monkeybusiness.bus.model.imageUploadResponse.ImageUploadResponse;
//import com.monkeybusiness.bus.model.lectureResponse.LectureResponseData;
//import com.monkeybusiness.bus.model.loginResponseData.LoginResponse;
//import com.monkeybusiness.bus.model.simpleResponseDaa.SimpleResponseData;
//import com.monkeybusiness.bus.model.studentDetailsForMarks.StudentDetailsForMarksResponse;
//import com.monkeybusiness.bus.model.studentDetailsResponse.StudentsDetailsResponseData;
//import com.monkeybusiness.bus.model.studentRemarksData.StudentsRemarksResponse;
//import com.monkeybusiness.bus.model.studentSearchdata.SearchStudentData;
//import com.monkeybusiness.bus.model.studentsResponse.StudentsListResponseData;
//import com.monkeybusiness.bus.model.testListResponseData.TestListResponse;
//import com.monkeybusiness.bus.model.testMarksResponseData.TestMarksResponseData;

import bus.monkeybusiness.com.sambus.model.addRemarksResponseData.AddRemarksResponseData;
import bus.monkeybusiness.com.sambus.model.announcementResponse.AnnouncementsResponseData;
import bus.monkeybusiness.com.sambus.model.busListResponse.BusListResponse;
import bus.monkeybusiness.com.sambus.model.busStudentList.BusStudentList;
import bus.monkeybusiness.com.sambus.model.changeRoleRespnse.ChangeRoleResponse;
import bus.monkeybusiness.com.sambus.model.checkLoginResponse.CheckLoginResponse;
import bus.monkeybusiness.com.sambus.model.loginResponseData.LoginResponse;
import bus.monkeybusiness.com.sambus.model.studentDetailsResponse.StudentsDetailsResponseData;
import bus.monkeybusiness.com.sambus.model.studentRemarksData.StudentsRemarksResponse;
import bus.monkeybusiness.com.sambus.model.studentSearchdata.SearchStudentData;
import bus.monkeybusiness.com.sambus.model.studentsResponse.StudentsListResponseData;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedInput;

/**
 * Define all server calls here
 */
public interface ApiService {

    @GET("/session")
    void apiCall(@Query("latlng") String latlng, @Query("sensor") String sensor, Callback<String> callback);

//    @FormUrlEncoded
//    @POST("/session")
//    public void apiCallLogin(@Field("session") String session,@Field("password") String password, Callback<String> callback);

    @POST("/session")
    void apiCallLogin(@Body TypedInput loginRequestObject, Callback<LoginResponse> callback);

    @POST("/change_role")
    void apiCallChangeRole(@Body TypedInput changeRoleObject, Callback<ChangeRoleResponse> callback);
//
    @GET("/check_login")
    void apiCallCheckLogin(Callback<CheckLoginResponse> callback);

    @GET("/bus")
    void apiCallGetBusList(Callback<BusListResponse> callback);
//
//    @GET("/lectures")
//    void apiCallLectures(Callback<LectureResponseData> callback);
//
//    //for getting list of students
//    @GET("/students")
//    void apiCallGetStudents(@Query("lecture_id") String lectureId, Callback<StudentsListResponseData> callback);
//
    //for getting list of students
    @GET("/students")
    void apiCallGetStudentsByBatch(@Query("batch_id") String batchId, Callback<StudentsListResponseData> callback);
//
//    //for getting  student details
    @GET("/students/{id}")
    void apiCallGetStudentDetails(@Path("id") String studentId, Callback<StudentsDetailsResponseData> callback);
//
//    @GET("/tests")
//    void apiCallTestList(Callback<TestListResponse> callback);
//
//    @POST("/lectures/{lecture_id}/tests")
//    void apiCallPostTest(@Path("lecture_id") String lectureId, @Body TypedInput testPostObject, Callback<AddTestResponse> callback);
//
    @POST("/remarks")
    void apiCallSendRemarks(@Body TypedInput remarksPostObject, Callback<AddRemarksResponseData> callback);
//
    @GET("/search/students")
    void apiCallSearchStudent(@Query("search_text") String searchText, Callback<SearchStudentData> callback);
//
//    @GET("/events")
//    void apiCallGetEvents(@Query("from_time") String fromTime, @Query("to_time") String toTime, Callback<EventResponseData> callback);
//
//    @POST("/events")
//    void apiCallPostEvent(@Body TypedInput eventPostObject, Callback<AddEventResponseData> callback);
//
//    @GET("/batches")
//    void apiCallGetBatches(Callback<BatchesResponseData> callback);
//
//    @GET("/batches/{batch_id}/student_attendances")
//    void apiCallGetAttendanceDetail(@Path("batch_id") String batchId, @Query("group_by") String groupBy, @Query("page") String page, @Query("limit") String limit, Callback<String> callback);
//
//    @GET("/batches/{batch_id}/student_attendances")
//    void apiCallGetSingleDayAttendanceDetail(@Path("batch_id") String batchId, @Query("current_date") String currentDate, Callback<String> callback);
//
//    @PUT("/lectures/{lecture_id}/tests/{test_id}")
//    void apiCallPutTest(@Path("lecture_id") String lectureId, @Path("test_id") String testId, @Body TypedInput testPostObject, Callback<AddTestResponse> callback);
//
//    @POST("/batches/{batch_id}/student_attendances")
//    void apiCallPostAttendances(@Path("batch_id") String batchId, @Body TypedInput attdPostObject, Callback<AttdSavedResponseData> callback);
//
//    @GET("/batches/{batch_id}/student_attendances")
//    void apiCallMonthAttendanceDetail(@Path("batch_id") String batchId, @Query("from_date") String currentDate, @Query("to_date") String toDate, Callback<String> callback);
//
    @GET("/students/{student_id}/remarks")
    void apiCallFetchSingleStudentRemarks(@Path("student_id") String studentId, @Query("all") String all, Callback<StudentsRemarksResponse> callback);
//
//    @GET("/lectures/{lecture_id}/tests")
//    void apiCallGetTestByLectures(@Path("lecture_id") String lectureId, Callback<TestListResponse> callback);
//
////    @GET("lectures/{lecture_id}/tests/{test_id}")
////    void apiCallGetTestDetails(@Path("lecture_id") String lectureId,@Path("test_id") String testId,Callback<String> callback);
//
//
//    @GET("/tests/{test_id}/test_marks")
//    void apiCallGetTestMarks(@Path("test_id") String testId, Callback<TestMarksResponseData> callback);
//
//    @GET("/students")
//    void apiCallGetTestStudents(@Query("lecture_id") String lectureId, Callback<StudentDetailsForMarksResponse> callback);
//
//    @POST("/tests/{test_id}/test_marks")
//    void apiCallSendStudentMarks(@Path("test_id") String testId, @Body TypedInput marksPostObject, Callback<SimpleResponseData> callback);
//
//    @POST("/upload")
//    void apiCallSendStudentPicture(@Body TypedInput pictureObject, Callback<ImageUploadResponse> callback);
//
//    @PUT("/upload/{picture_id}")
//    void apiCallSendStudentPictureWithId(@Path("picture_id") String pictureId, @Body TypedInput pictureObject, Callback<ImageUploadResponse> callback);
//
//    @PUT("/students/{id}")
//    void apiCallPutStudentPicture(@Path("id") String id, @Body TypedInput pictureObject, Callback<String> callback);
//
//    @PUT("/students/{id}")
//    void apiCallPutStudentNumber(@Path("id") String id, @Body TypedInput NumberObject, Callback<String> callback);
//
//    @GET("/exam_groups")
//    void apiCallGetExamGroupByBatch(Callback<ExamGroupData> callback);
//
//    @GET("/exam_groups/{group_id}/exams")
//    void apiCallGetExamsByBatch(@Path("group_id") String grpId, @Query("grade_id") String gradeId, Callback<ExamData> callback);
//
//    @GET("/students")
//    void apiCallGetExamStudents(@Query("batch_id") String batchId, Callback<StudentDetailsForMarksResponse> callback);
//
//    @GET("/exams/{exam_id}/exam_marks")
//    void apiCallGetExamMarks(@Path("exam_id") String examId, @Query("batch_id") String batchId, Callback<ExamStudentMarks> callback);
//
//    @POST("/exams/{exam_id}/exam_marks")
//    void apiCallSendStudentExamMarks(@Path("exam_id") String examId, @Body TypedInput marksPostObject, Callback<SimpleResponseData> callback);

    //for getting list of students
    @GET("/bus/{bus_id}")
    void apiCallGetStudentsByBusID(@Path("bus_id") String batchId, Callback<BusStudentList> callback);

    //for posting announcements
    @POST("/announcements")
    void apiCallPostAnnouncment(@Body TypedInput announceObject, Callback<String> callback);

    //for getting announcements
    @GET("/announcements")
    void apiCallGetAnnouncements(@Query("from_time") String fromDate,@Query("to_time") String toDate, Callback<AnnouncementsResponseData> callback);
}