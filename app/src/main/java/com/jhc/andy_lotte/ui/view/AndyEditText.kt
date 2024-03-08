package com.jhc.andy_lotte.ui.view

import android.app.Instrumentation
import android.content.Context
import android.graphics.Rect
import android.text.InputType
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.jhc.andy_lotte.R
import com.jhc.andy_lotte.common.KeyTrans
import com.jhc.andy_lotte.common.n

//ver. 2

class AndyEditText: androidx.appcompat.widget.AppCompatEditText {

    var model = android.os.Build.MODEL
    val modelA124 = "iData18"
    val modelA2 = "A65"
    val modelA128 = "m52"
    val modelA132 = "i3"
    val modelA132Pro = "i3 Pro"

    lateinit var imm: InputMethodManager

    //attrs input 인풋 타입
    var input = "num"
    val Num = "Num"
    val Kor = "Kor"

    var maxLength = 15
    var onKeyListener: (i: Int, keyEvent: KeyEvent)->Boolean = {_,_ -> false}

    private var clickToClear = true

    private var editDone: (String) -> Unit = {}

    constructor(context: Context) : super(context){ init(context) }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){ init(context, attrs) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){ init(context, attrs) }

    fun init(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0){

        imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        //커스텀 attrs input 가져옴
        context.theme.obtainStyledAttributes(attrs, R.styleable.AndyEditText, 0, 0).apply {
            try { input = getString(R.styleable.AndyEditText_input) ?: "Num" }finally { recycle() }
        }

        // maxLength 설정작업
        val typedArray = context.obtainStyledAttributes(attrs, intArrayOf(android.R.attr.maxLength))
        try { maxLength = typedArray.getInteger(0, 0) }
        finally { typedArray.recycle() }

        // 클릭시 텍스트 클리어
        if(clickToClear){
            setOnClickListener {
                (it as EditText).text = null
            }
        }

        //  `ok`버튼 클릭 또는 확인버튼 터치시 소프트키보드 가리고 람다호출
        setOnEditorActionListener { v, actionId, event ->
            if(event?.action == KeyEvent.ACTION_DOWN) return@setOnEditorActionListener true
            editDone(v.text.toString())
            (v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(v.windowToken, 0)
            true
        }

        if(input == Num) {

            this.showSoftInputOnFocus = false
            this.inputType = InputType.TYPE_CLASS_NUMBER

            setOnKeyListener { v, keyCode, event ->

                if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
                    true
                } else if (onKeyListener(keyCode, event)) {
                    true
                } else if (event.action == KeyEvent.ACTION_DOWN) {

                    val key = KeyTrans.keyTrans(keyCode, event)

                    if (keyCode in KeyEvent.KEYCODE_0.n()..KeyEvent.KEYCODE_9)
                        return@setOnKeyListener false
                    when (key) {
                        KeyEvent.KEYCODE_DEL -> delCheck(event)
                        in KeyEvent.KEYCODE_0.n()..KeyEvent.KEYCODE_9 -> transKey(key)
                        else -> super.onKeyDown(keyCode, event)
                    }

                } else {
                    false
                }
            }

        }else {
            this.inputType = InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
            setOnKeyListener { view, i, keyEvent ->
                if(keyEvent.keyCode == KeyEvent.KEYCODE_ENTER){
                    keyEvent.scanCode == 0
                } else
                    false
            }
        }

    }

    fun transKey(keyCode: Int): Boolean{
        if(keyCode == KeyEvent.KEYCODE_DEL || this.length() < maxLength) {
            val key = KeyEvent(KeyEvent.ACTION_DOWN, keyCode)
            Thread {
                Instrumentation().sendKeySync(key)
            }.start()
        }
        return true
    }

    val delScanCode = when(model){
        modelA124 -> 102
        modelA132 -> 111
        modelA132Pro -> 111
        else -> 14
    }
    fun delCheck(event: KeyEvent): Boolean = event.scanCode != delScanCode


    fun setKeyListener(listener: (keyCode: Int, keyEvent: KeyEvent)->Boolean){
        onKeyListener = listener
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        if(focused) {
            this.setSelection(this.length())
            if(input != Num) imm.showSoftInput(this, 0)
            else imm.hideSoftInputFromWindow(this.windowToken, 0)
        } else if(input != Num){
            imm.hideSoftInputFromWindow(this.windowToken, 0)
        }
    }

    fun setClickToClear(clickToClear: Boolean){
        this.clickToClear = clickToClear
    }

    fun setEditDone(recv: (String) -> Unit){
        editDone = recv
    }

}

@BindingAdapter("liveData")
fun <T> AndyEditText.setLiveData(liveData: LiveData<T>){
    this.findViewTreeLifecycleOwner()?.let { lifeCycleOwner ->
        liveData.observe(lifeCycleOwner){
            this.setText(it.toString())
        }
    }
}