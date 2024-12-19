package com.example.moutraki

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        auth = FirebaseAuth.getInstance()

        val resetPasswordButton = findViewById<Button>(R.id.resetPasswordButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        resetPasswordButton.setOnClickListener {
            showResetPasswordDialog()
        }

        logoutButton.setOnClickListener {
            logoutUser ()
        }
    }

    private fun showResetPasswordDialog() {
        val dialog = ResetPasswordDialog(this) { email ->
            resetPassword(email)
        }
        dialog.show()
    }

    private fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Password reset email sent.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun logoutUser () {
        auth.signOut()
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
        // Navigate back to LoginActivity
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}