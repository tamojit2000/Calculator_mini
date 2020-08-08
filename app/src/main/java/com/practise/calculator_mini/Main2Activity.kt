package com.practise.calculator_mini


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var intentx=intent
        var model= intentx.getParcelableExtra<Model>("ANS")
        var ans=0
        if(model.sign=="+"){
            ans=model.num_1+model.num_2
        }else{
            ans=model.num_1*model.num_2
        }


        Ans_display.text="Ans is $ans ."
    }
}
