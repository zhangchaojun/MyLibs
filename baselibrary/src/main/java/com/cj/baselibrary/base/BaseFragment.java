package com.cj.baselibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cj.baselibrary.utils.LogUtil;

/**
 * Created by cj on 2020/12/7.
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";

    protected View mView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LogUtil.e(TAG,this.getClass().getSimpleName()+" onCreateView");

        mView = inflater.inflate(getLayoutId(), container, false);
        initView(mView);
        return mView;
    }

    /**
     * 设置布局
     *
     * @return 布局id。例如R.layout.fragment_home
     */
    protected abstract int getLayoutId();
    /**
     * 初始化View
     *
     * @param view
     */
    protected abstract void initView(View view);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onViewCreated");


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.e(TAG,this.getClass().getSimpleName()+" onDetach");

    }

}
