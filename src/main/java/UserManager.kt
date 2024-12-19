// UserManager.kt
package com.example.moutraki

import com.google.firebase.auth.FirebaseAuth

class UserManager {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUser (email: String, password: String, onComplete: (Boolean) -> Unit) {
        auth.createUser WithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            onComplete(task.isSuccessful)
        }
    }

    fun loginUser (email: String, password: String, onComplete: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                onComplete(task.isSuccessful)
            }
    }

    fun getCurrentUser () = auth.currentUser
}