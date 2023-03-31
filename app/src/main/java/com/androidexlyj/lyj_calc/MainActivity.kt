package com.androidexlyj.lyj_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidexlyj.lyj_calc.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder



class MainActivity : AppCompatActivity() {
    // 전역변수 설정하기
    lateinit var lyjBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lyjBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(lyjBinding.root)
        title = "lyj의 초간단 계산기"


        lyjBinding.lyjBtn0.setOnClickListener {
            lyjBinding.lyjPreview.append("0")
        }
        lyjBinding.lyjBtn1.setOnClickListener {
            lyjBinding.lyjPreview.append("1")
        }
        lyjBinding.lyjBtn2.setOnClickListener {
            lyjBinding.lyjPreview.append("2")
        }
        lyjBinding.lyjBtn3.setOnClickListener {
            lyjBinding.lyjPreview.append("3")
        }
        lyjBinding.lyjBtn4.setOnClickListener {
            lyjBinding.lyjPreview.append("4")
        }
        lyjBinding.lyjBtn5.setOnClickListener {
            lyjBinding.lyjPreview.append("5")
        }
        lyjBinding.lyjBtn6.setOnClickListener {
            lyjBinding.lyjPreview.append("6")
        }
        lyjBinding.lyjBtn7.setOnClickListener {
            lyjBinding.lyjPreview.append("7")
        }
        lyjBinding.lyjBtn8.setOnClickListener {
            lyjBinding.lyjPreview.append("8")
        }
        lyjBinding.lyjBtn9.setOnClickListener {
            lyjBinding.lyjPreview.append("9")
        }
        lyjBinding.lyjBtnPoint.setOnClickListener {
            lyjBinding.lyjPreview.append(".")
        }
        lyjBinding.lyjBtnPlus.setOnClickListener {
            lyjBinding.lyjPreview.append(" + ")
        }
        lyjBinding.lyjBtnMinus.setOnClickListener {
            lyjBinding.lyjPreview.append(" - ")
        }
        lyjBinding.lyjBtnMul.setOnClickListener {
            lyjBinding.lyjPreview.append(" * ")
        }
        lyjBinding.lyjBtnDiv.setOnClickListener {
            lyjBinding.lyjPreview.append(" / ")
        }
        lyjBinding.lyjBtnResult.setOnClickListener {
            val lyjExpression = ExpressionBuilder(lyjBinding.lyjPreview.text.toString()).build()
            val lyjResultEx = lyjExpression.evaluate()
            val lyjLongResult = lyjResultEx.toLong()

            if (lyjResultEx == lyjLongResult.toDouble()) {
                lyjBinding.lyjResult.text = lyjLongResult.toString()

            } else {
                lyjBinding.lyjResult.text = lyjResultEx.toString()
            }
            lyjBinding.lyjPreview.text = lyjBinding.lyjResult.text.toString()
        }
        lyjBinding.lyjBtnAC.setOnClickListener {
            lyjBinding.lyjPreview.text = ""
            lyjBinding.lyjResult.text = ""
        }

    }
}



