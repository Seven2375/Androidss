package com.huangxue.s01.Fragment.Lawyer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Activity.Lawyer.LawyerAskInfoActivity;
import com.huangxue.s01.Adatper.LawyerUserEvaluateListAdapter;
import com.huangxue.s01.Beans.LawyerUserEvaluateListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.MyOnClickPosition;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

import okhttp3.MediaType;

public class LawyerUserEvaluateFragment extends Fragment implements MyOnClickPosition {

    private View mView;
    private RecyclerView rv;
    private int id;
    private String token;
    private List<LawyerUserEvaluateListBean.RowsEntity> dataList;
    private String num = "1";
    private Gson gson = new Gson();
    private LawyerUserEvaluateListAdapter adapter;
    private LinearLayoutManager manager;
    private ProgressBar pb;
    private boolean isPage = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
        token = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE).getString("token", "");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_lawyer_user_evaluate, container, false);

        initView();
        
        new Thread(()->{
            initHttp();
        }).start();

        return mView;
    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/list-evaluate?lawyerId="+id+"&"+"pageNum="+num+"&"+"pageSize="+"20", token);

        LawyerUserEvaluateListBean bean = gson.fromJson(body, LawyerUserEvaluateListBean.class);

        if (bean.getTotal()!=0){
            dataList = bean.getRows();
            if (bean.getTotal()!=20){
                isPage = false;
            }
            getActivity().runOnUiThread(()->{
                initList();
                pb.setVisibility(View.GONE);
            });
            return;
        }

    }

    private void initList() {
        adapter = new LawyerUserEvaluateListAdapter(dataList, getActivity());
        manager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState==RecyclerView.SCROLL_STATE_IDLE){
                    int lastPosition = manager.findLastVisibleItemPosition();
                    if (lastPosition>= manager.getItemCount()-1){
                        if (isPage){
                            new Thread(()->{ initLoadMore(); }).start();
                        }
                    }
                }
            }
        });
        adapter.setMyOnClick(this);
    }

    private void initView() {
        rv = mView.findViewById(R.id.lawyer_user_evaluate_rv);
        pb = mView.findViewById(R.id.item_progress);
        mView.findViewById(R.id.lawyer_user_evaluate_btn).setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), LawyerAskInfoActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });
    }

    private void initLoadMore() {
        num+=1;
        String body = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/list-evaluate?lawyerId="+id+"&"+"pageNum="+num+"&"+"pageSize="+"20", token);

        LawyerUserEvaluateListBean bean = gson.fromJson(body, LawyerUserEvaluateListBean.class);
        List<LawyerUserEvaluateListBean.RowsEntity> rows = bean.getRows();

        if (bean.getTotal()!=20){
            isPage = false;
        }

        for (LawyerUserEvaluateListBean.RowsEntity data : rows) {
            dataList.add(data);
        }
        getActivity().runOnUiThread(()->{
            adapter.notifyItemChanged(manager.getItemCount()-1);
            pb.setVisibility(View.GONE);
        });
    }


    @Override
    public void onClick(Object data,int position) {
        LawyerUserEvaluateListBean.RowsEntity origin = (LawyerUserEvaluateListBean.RowsEntity) data;
        initIsLike(!origin.isMyLikeState(),origin.getAdviceId());
        origin.setLikeCount(origin.isMyLikeState() ? origin.getLikeCount()-1:origin.getLikeCount()+1);
        origin.setMyLikeState(!origin.isMyLikeState());
        adapter.notifyItemChanged(position);

        Log.e("TAG", "onClick: "+origin.isMyLikeState() );
        Log.e("TAG", "onClick: "+dataList.get(position).isMyLikeState() );

    }

    private void initIsLike(boolean isLike,int adviceId) {
        new Thread(()->{
            MediaType jsonType = MediaType.parse("application/json");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("adviceId",adviceId);
            jsonObject.addProperty("like",isLike);
            String s = WorkOkHttp.post("/prod-api/api/lawyer-consultation/legal-advice/evaluate-like",jsonObject ,jsonType,token);
            int code = new JsonParser().parse(s).getAsJsonObject().get("code").getAsInt();
            if (code==200){
                getActivity().runOnUiThread(()->{
                    String msg = (isLike ?"点赞成功":"取消点赞成功");
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }
}
