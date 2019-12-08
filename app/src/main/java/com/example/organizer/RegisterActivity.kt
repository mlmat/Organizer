package com.example.organizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var loginText: EditText
    private lateinit var  passwordText: EditText
    private lateinit var registerButton: Button

    private lateinit var mAuth : FirebaseAuth
    private val TAG = "REGISTER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loginText = findViewById(R.id.registerName)
        passwordText = findViewById(R.id.registerPassword)

        registerButton = findViewById(R.id.firstRegister)

        mAuth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener {
            val email = loginText.text.toString()
            val password = passwordText.text.toString()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        //val user = mAuth.currentUser

                        startActivity(
                            Intent(
                                applicationContext,
                                MainActivity::class.java
                            )
                        )

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }
}
