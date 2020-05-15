package com.example.administrator.read;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.administrator.read.Y_QA.QuestionActivity;
import com.example.administrator.read.Y_Utils.XTextView;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class fragment2 extends Fragment {
    private ViewPager mViewPager;
    private XTextView xtv;
    ImageButton Button1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment2, container, false);
        mViewPager = (ViewPager)view.findViewById(R.id.container);
        return view;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button1 = getActivity().findViewById(R.id.ch1);
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), QuestionActivity.class);
                startActivity(intent);
            }
        });
    }

}
