package com.practise.calculator_mini

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    fun vibratePhone() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            Toast.makeText(this,"Not Vibrate",Toast.LENGTH_SHORT).show()
        }
    }
    var model = Model(0,0,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Plus_btn.isChecked=true
        Multiply_btn.isChecked=true

        Plus_btn.setOnClickListener {
            Multiply_btn.isChecked=false
            if(Plus_btn.isChecked==true){
                Plus_btn.setBackgroundResource(R.drawable.selected_button)
                Plus_btn.setTextColor(Color.parseColor(R.color.colorAccent.toString()))
            }

            model.sign="+"
            //vibratePhone()
        }

        Multiply_btn.setOnClickListener {
            Plus_btn.isChecked=false
            if(Multiply_btn.isChecked==true) {
                Multiply_btn.setBackgroundResource(R.drawable.selected_button)
                Multiply_btn.setTextColor(Color.parseColor(R.color.colorAccent.toString()))
            }
            model.sign="*"
            //vibratePhone()
        }

        Proceed_btn.setOnClickListener {
            var x=0
            try {
                x=Num_1.text.toString().toInt()
            }
            finally {
                println("Doen")
            }

            var y=0
            try{
                y=Num_2.text.toString().toInt()
            }
            finally {
                println("Doen")
            }


            if (x==0 || y==0){
                Toast.makeText(this,"Please enter the numbers",Toast.LENGTH_SHORT).show()
            }
            if(model.sign==""){
                Toast.makeText(this,"Enter Sign",Toast.LENGTH_SHORT).show()
            }
            if(x!=0 && y!=0 && model.sign!=""){
                model.num_1=x
                model.num_2=y
                //var ans=0
                var intentx=Intent(this,Main2Activity::class.java)
                intentx.putExtra("ANS",model)
                //intent.putExtra(obj_num_2,model.num_2)
                //intent.putExtra(obj_sign,model.sign)
                startActivity(intentx)
                //Toast.makeText(this,"$ans",Toast.LENGTH_LONG).show()
            }
            vibratePhone()
        }
    }
}
