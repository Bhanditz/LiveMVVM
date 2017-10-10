package io.github.mindjet.sample

import io.github.mindjet.livemvvm.view.BaseActivity
import io.github.mindjet.livemvvm.viewmodel.BaseViewModel
import io.github.mindjet.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainModel>() {

    override fun getVariableId(): Int {
        return BR.data
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): BaseViewModel<ActivityMainBinding, MainModel> {
        return MainViewModel()
    }
}
