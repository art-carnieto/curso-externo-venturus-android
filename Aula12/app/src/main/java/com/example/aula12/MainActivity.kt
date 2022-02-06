package com.example.aula12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // reference: https://developer.android.com/guide/topics/ui/dialogs?hl=pt-br
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle(R.string.alert_dialog_title)
                setMessage(R.string.alert_dialog_message)
                setPositiveButton(R.string.alert_dialog_ok) { dialog, id ->
                    // User clicked OK button
                }
            }
            // Create the AlertDialog
            builder.create()
        }

        alertDialog.show()
    }
}