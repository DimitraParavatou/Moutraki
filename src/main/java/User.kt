data class User(
    var id: String? = null,
    var name: String = "",
    var email: String = "",
    var age: Int = 0
)
data class User(
    val id: Int,
    var name: String,
    var email: String,
    var age: Int
) {
    // Method to display user information
    fun displayInfo() {
        println("User ID: $id")
        println("Name: $name")
        println("Email: $email")
        println("Age: $age")
    }

    // Method to update the user's email
    fun updateEmail(newEmail: String) {
        email = newEmail
        println("Email updated to: $email")
    }

//    // Method to check if the user is an adult
//    fun isAdult(): Boolean {
//        return age >= 18
//    }

   // Add Dependencies: Ensure you have the Firebase Realtime Database dependency in your build.gradle file:
//    dependencies {
//        implementation 'com.google.firebase:firebase-database-ktx:20.0.3'
//    }
}

import com.google.firebase.database.FirebaseDatabase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true) // Optional: Enable offline persistence
    }
}
fun addUser ToFirebase(user: User) {
    val database = FirebaseDatabase.getInstance()
    val userId = database.reference.child("users").push().key // Generate a unique ID
    user.id = userId // Set the generated ID to the user object

    database.reference.child("users").child(userId!!).setValue(user)
        .addOnSuccessListener {
            // User added successfully
            Log.d("Firebase", "User  added: $user")
        }
        .addOnFailureListener { error ->
            // Handle the error
            Log.e("Firebase", "Error adding user: ${error.message}")
        }
}

fun main() {
    val users = listOf(
        User(name = "John Doe", email = "john.doe@example.com", age = 25),
        User(name = "Jane Smith", email = "jane.smith@example.com", age = 30),
        User(name = "Alice Johnson", email = "alice.johnson@example.com", age = 22)
    )

    users.forEach { addUser ToFirebase(it) }
}


fun main() {
    // Creating a new User instance
    val user = User(id = 1, name = "John Doe", email = "john.doe@example.com", age = 25)

    // Displaying user information
    user.displayInfo()

    // Updating the user's email
    user.updateEmail("john.new@example.com")

    // Checking if the user is an adult
    //println("Is user an adult? ${user.isAdult()}")
}