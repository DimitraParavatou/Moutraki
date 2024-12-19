package com.example.moutraki

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog

class ResetPasswordDialog(context: Context, private val onReset: (String) -> Unit) : AppCompatDialog(context) {

    private lateinit var emailEditText: EditText
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_reset_password)

        emailEditText = findViewById(R.id.emailEditText)
        resetButton = findViewById(R.id.resetButton)

        resetButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isNotEmpty()) {
                onReset(email)
                dismiss()
            } else {
                Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}