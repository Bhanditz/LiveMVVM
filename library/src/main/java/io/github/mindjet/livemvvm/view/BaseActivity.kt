package io.github.mindjet.livemvvm.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.mindjet.livemvvm.viewmodel.BaseViewModel

/**
 * Created by Mindjet on 2017/9/25.
 */

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), BaseView<B> {

    private var mBinding: B? = null
    private var mViewModel: BaseViewModel<B>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = ViewModelProviders.of(this).get(getViewModel().javaClass)
        mViewModel?.onAttachedWithActivity(mBinding!!)

    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel?.onDetached()
    }

}