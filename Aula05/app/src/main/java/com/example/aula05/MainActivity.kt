package com.example.aula05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentLang = Locale.getDefault().language
        val radioGroup =  findViewById<RadioGroup>(R.id.radioGroup)

        if (currentLang == "pt") radioGroup.check(R.id.radioButton_ptBR)
        else if(currentLang == "en") radioGroup.check(R.id.radioButton_en)
    }

    // reference: https://developer.android.com/guide/topics/ui/controls/radiobutton
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButton_en ->
                    if (checked) {
                        changeLanguageTo("en")
                    }
                R.id.radioButton_ptBR ->
                    if (checked) {
                        changeLanguageTo("pt")
                    }
            }
        }
    }

    // reference: https://stackoverflow.com/questions/2900023/change-app-language-programmatically-in-android
    // reference: https://www.geeksforgeeks.org/how-to-change-the-whole-app-language-in-android-programmatically/
    private fun changeLanguageTo(new_lang: String) {
        val config = resources.configuration
        val locale = Locale(new_lang)
        Locale.setDefault(locale)
        config.setLocale(locale)
        val context = createConfigurationContext(config)
        val resources = context.resources

        val title = findViewById<TextView>(R.id.textView2)
        val mainText = findViewById<TextView>(R.id.textView)

        title.text = resources.getString(R.string.title)
        mainText.text = resources.getString(R.string.main_text)
    }
}