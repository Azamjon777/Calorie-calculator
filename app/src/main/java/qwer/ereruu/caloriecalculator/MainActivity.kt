package qwer.ereruu.caloriecalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var editTextMeatWeight: EditText
    private lateinit var editTextBreadWeight: EditText
    private lateinit var editTextMilkWeight: EditText
    private lateinit var textViewCaloriesMeat: TextView
    private lateinit var textViewCaloriesBread: TextView
    private lateinit var textViewCaloriesMilk: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMeatWeight = findViewById(R.id.editTextMeatWeight)
        editTextBreadWeight = findViewById(R.id.editTextBreadWeight)
        editTextMilkWeight = findViewById(R.id.editTextMilkWeight)
        textViewCaloriesMeat = findViewById(R.id.textViewCaloriesMeat)
        textViewCaloriesBread = findViewById(R.id.textViewCaloriesBread)
        textViewCaloriesMilk = findViewById(R.id.textViewCaloriesMilk)
    }

    fun calculateCalories(view: View) {
        val meatWeight = editTextMeatWeight.text.toString().toIntOrNull() ?: 0
        val breadWeight = editTextBreadWeight.text.toString().toIntOrNull() ?: 0
        val milkWeight = editTextMilkWeight.text.toString().toIntOrNull() ?: 0

        val totalCaloriesMeat =
            calculateTotalCalories(meatWeight, 250)
        val totalCaloriesBread =
            calculateTotalCalories(breadWeight, 120)
        val totalCaloriesMilk =
            calculateTotalCalories(milkWeight, 50)

        textViewCaloriesMeat.text = "Calories: $totalCaloriesMeat"
        textViewCaloriesBread.text = "Calories: $totalCaloriesBread"
        textViewCaloriesMilk.text = "Calories: $totalCaloriesMilk"
    }

    private fun calculateTotalCalories(weight: Int, caloriesPer100g: Int): Int {
        return ((weight.toDouble() / 100) * caloriesPer100g).toInt()
    }
}