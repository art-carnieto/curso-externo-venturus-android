package com.example.aula12

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isFirstUse()) showWelcomeDialog()
    }

    //reference: https://developer.android.com/training/data-storage/shared-preferences
    private fun isFirstUse() : Boolean {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        if(sharedPref.getBoolean(getString(R.string.welcome_dialog_dismiss_key), false))
            return false
        return true
    }

    private fun saveWelcomeDismiss() {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(getString(R.string.welcome_dialog_dismiss_key), true)
            apply()
        }
    }

    private fun showWelcomeDialog() {
        // reference: https://developer.android.com/guide/topics/ui/dialogs?hl=pt-br
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle(R.string.alert_dialog_title)
                setMessage(R.string.alert_dialog_message)
                setPositiveButton(R.string.alert_dialog_ok) { dialog, id ->
                    // User clicked OK button
                    saveWelcomeDismiss()
                }
            }
            // Create the AlertDialog
            builder.create()
        }
        alertDialog.show()
    }
}