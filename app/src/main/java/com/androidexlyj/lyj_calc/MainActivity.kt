package com.androidexlyj.lyj_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    // 전역변수 설정하기
    lateinit var lyjBtn0: Button
    lateinit var lyjBtn1: Button
    lateinit var lyjBtn2: Button
    lateinit var lyjBtn3: Button
    lateinit var lyjBtn4: Button
    lateinit var lyjBtn5: Button
    lateinit var lyjBtn6: Button
    lateinit var lyjBtn7: Button
    lateinit var lyjBtn8: Button
    lateinit var lyjBtn9: Button
    lateinit var lyjBtnMul: Button
    lateinit var lyjBtnMinus: Button
    lateinit var lyjBtnPlus: Button
    lateinit var lyjBtnPoint: Button
    lateinit var lyjBtnDiv: Button
    lateinit var lyjBtnResult: Button
    lateinit var lyjBtnAC: Button
    lateinit var lyjResult: TextView
    lateinit var lyjPreview: TextView
    lateinit var lyjNum1: String
    lateinit var lyjNum2: String
    private var lyjIsOperator = false
    private var lyjHasOperator = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "lyj의 초간단 계산기"

        lyjBtn0 = findViewById<Button>(R.id.lyjBtn0);
        lyjBtn1 = findViewById<Button>(R.id.lyjBtn1);
        lyjBtn2 = findViewById<Button>(R.id.lyjBtn2);
        lyjBtn3 = findViewById<Button>(R.id.lyjBtn3);
        lyjBtn4 = findViewById<Button>(R.id.lyjBtn4);
        lyjBtn5 = findViewById<Button>(R.id.lyjBtn5);
        lyjBtn6 = findViewById<Button>(R.id.lyjBtn6);
        lyjBtn7 = findViewById<Button>(R.id.lyjBtn7);
        lyjBtn8 = findViewById<Button>(R.id.lyjBtn8);
        lyjBtn9 = findViewById<Button>(R.id.lyjBtn9);
        lyjBtnMul = findViewById<Button>(R.id.lyjBtnMul);
        lyjBtnMinus = findViewById<Button>(R.id.lyjBtnMinus);
        lyjBtnPlus = findViewById<Button>(R.id.lyjBtnPlus);
        lyjBtnPoint = findViewById<Button>(R.id.lyjBtnPoint);
        lyjBtnDiv = findViewById<Button>(R.id.lyjBtnDiv);
        lyjBtnResult = findViewById<Button>(R.id.lyjBtnResult);
        lyjBtnAC = findViewById<Button>(R.id.lyjBtnAC);
        lyjResult = findViewById<TextView>(R.id.lyjResult);
        lyjPreview = findViewById<TextView>(R.id.lyjPreview);
//        lyjBtn0.setOnClickListener {
//            if (lyjIsOperator) {
//                lyjPreview.append(" ")
//            }
//            lyjIsOperator = false
//            val lyjPreviewText = lyjPreview.text.split(" ")
//
//            if (lyjPreviewText.last().isEmpty() && lyjBtn0.text.toString() == "0") {
//                lyjResult.text = "0"
//            }
//            lyjPreview.append(lyjBtn0.text.toString())
//            lyjResult.text = calculateFun()
//        }
        lyjBtn0.setOnClickListener {
            buttonClicked(lyjBtn0)
        }
        lyjBtn1.setOnClickListener {
            buttonClicked(lyjBtn1)
        }
        lyjBtn2.setOnClickListener {
            buttonClicked(lyjBtn2)
        }
        lyjBtn3.setOnClickListener {
            buttonClicked(lyjBtn3)
        }
        lyjBtn4.setOnClickListener {
            buttonClicked(lyjBtn4)
        }
        lyjBtn5.setOnClickListener {
            buttonClicked(lyjBtn5)
        }
        lyjBtn6.setOnClickListener {
            buttonClicked(lyjBtn6)
        }
        lyjBtn7.setOnClickListener {
            buttonClicked(lyjBtn7)
        }
        lyjBtn8.setOnClickListener {
            buttonClicked(lyjBtn8)
        }
        lyjBtn9.setOnClickListener {
            buttonClicked(lyjBtn9)
        }
        lyjBtnPlus.setOnClickListener {
            buttonClicked(lyjBtnPlus)
        }
        lyjBtnMinus.setOnClickListener {
            buttonClicked(lyjBtnMinus)
        }
        lyjBtnMul.setOnClickListener {
            buttonClicked(lyjBtnMul)
        }
        lyjBtnDiv.setOnClickListener {
            buttonClicked(lyjBtnDiv)
        }
        lyjBtnResult.setOnClickListener {

            resultBtnClicked(lyjBtnResult)
        }

        lyjBtnAC.setOnClickListener {
            clearBtnClicked(lyjBtnAC)
        }

    }

     // 버튼 클릭 함수
    fun buttonClicked(v : View) {
        when (v.id) {
            R.id.lyjBtn0 -> numBtnClicked("0")
            R.id.lyjBtn1 -> numBtnClicked("1")
            R.id.lyjBtn2 -> numBtnClicked("2")
            R.id.lyjBtn3 -> numBtnClicked("3")
            R.id.lyjBtn4 -> numBtnClicked("4")
            R.id.lyjBtn5 -> numBtnClicked("5")
            R.id.lyjBtn6 -> numBtnClicked("6")
            R.id.lyjBtn7 -> numBtnClicked("7")
            R.id.lyjBtn8 -> numBtnClicked("8")
            R.id.lyjBtn9 -> numBtnClicked("9")
            R.id.lyjBtnPlus -> opBtnClicked("+")
            R.id.lyjBtnMinus -> opBtnClicked("-")
            R.id.lyjBtnMul  -> opBtnClicked("*")
            R.id.lyjBtnDiv -> opBtnClicked("/")
        }
    }

    // 연산자 클릭한 경우
     fun opBtnClicked(op: String) {
        if (lyjPreview.text.isEmpty()) return

        when {
            lyjIsOperator -> {
                val lyjText = lyjPreview.text.toString()
                lyjPreview.text = lyjText.dropLast(1) + op
            }
            lyjHasOperator -> {
                // 연산자 한 번만 사용
                return
            }
            else -> {
                lyjPreview.append(" $op")
            }
        }
        lyjIsOperator = true
        lyjHasOperator = true
    }


    // 숫자 클릭한 경우
    private fun numBtnClicked(n: String) {
        if (lyjIsOperator) {
            lyjPreview.append(" ")
        }
        lyjIsOperator = false

        val lyjPreviewText = lyjPreview.text.split(" ")
        if (n == "0" && lyjPreviewText.last().isEmpty()) {
            return
        } else if (lyjPreviewText.last().length >= 10) {
            return
        }

        lyjPreview.append(n)
        lyjResult.text = calFunc()
    }

    private fun calFunc(): String {
        val lyjTexts = lyjPreview.text.split(" ")
        if (lyjHasOperator.not() || lyjTexts.size != 3) {
            return ""
        } else if (lyjTexts[0].isNumber().not() || lyjTexts[2].isNumber().not()) {
            // 숫자임을 확인하기
            return ""
        }
        val lyjNum1 = lyjTexts[0].toBigInteger()
        val lyjOp = lyjTexts[1]
        val lyjNum2 = lyjTexts[2].toBigInteger()

        return when(lyjOp) {
            "+" -> (lyjNum1 + lyjNum2).toString()
            "-" -> (lyjNum1 - lyjNum2).toString()
            "*" -> (lyjNum1 * lyjNum2).toString()
            "/" -> (lyjNum1 / lyjNum2).toString()
            else -> ""
        }
    }

    fun resultBtnClicked(v: View) {
        val lyjTexts = lyjPreview.text.split(" ")
        // 빈 값이거나 연산자 없이 숫자만 들어온 경우
        if (lyjPreview.text.isEmpty() || lyjTexts.size == 1) {
            return
        }
        // 마지막 값 없는 경우
        else if (lyjTexts.size != 3 && lyjHasOperator) {
            return
        } else if (lyjTexts[0].isNumber().not() || lyjTexts[2].isNumber().not()) {
            return
        }
        val lyjText = lyjPreview.text.toString()
        val lyjResText = calFunc()

        lyjPreview.text = lyjResText
        lyjResult.text = lyjResText

        lyjIsOperator = false
        lyjHasOperator = false
    }

    fun clearBtnClicked(v: View) {
        lyjResult.text = ""
        lyjPreview.text = ""
        lyjIsOperator = false
        lyjHasOperator = false
    }


}

// isNumber 확장 함수 사용
private fun String.isNumber(): Boolean {
    return try {
        // 무한대 Int형
        this.toBigInteger()
        true
    } catch (e: java.lang.NumberFormatException) {
        false
    }
}



