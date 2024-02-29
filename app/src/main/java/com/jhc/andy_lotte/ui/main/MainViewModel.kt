package com.jhc.andy_lotte.ui.main

import com.jhc.andy_lotte.base.BaseViewModel
import com.jhc.andy_lotte.common.Version
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    var version="ver "+Version().getDevVersion()

}