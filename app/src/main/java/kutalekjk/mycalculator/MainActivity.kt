package kutalekjk.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null

    // var dotPresent : Boolean = false
    private var lastNumeric: Boolean = true
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    // the "view" represent the actual buttons in this case
    fun onDigit(view: View) {
        // need to access the view text, but it doesn't have a ".text" property (a Button does) (?)
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View) {
        tvInput?.text = ""
        // dotPresent = false
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            tvInput?.append((view as Button).text)

            // dotPresent = true
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)

                lastNumeric = false
                lastDot = false
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        }
        else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}