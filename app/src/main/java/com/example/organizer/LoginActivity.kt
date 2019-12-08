package com.example.organizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var TAG = "LOGIN"
    private lateinit var loginText : EditText
    private lateinit var passwordText : EditText
    private lateinit var loginButton : Button
    private lateinit var mAuth : FirebaseAuth
    private lateinit var registerButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginText = findViewById(R.id.loginText)
        passwordText = findViewById(R.id.passwordText)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null){
            startActivity(
                Intent(
                    applicationContext,
                    MainActivity::class.java
                )
            )
        }

        registerButton.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    RegisterActivity::class.java
                )
            )
        }

        loginButton.setOnClickListener {
            val emailLogin = loginText.text.toString()
            val password = passwordText.text.toString()
            if (TextUtils.isEmpty(emailLogin)) {
                Toast.makeText(this, "Email Field is Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Password Field is Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth.signInWithEmailAndPassword(emailLogin, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        //val user = mAuth.currentUser
                        startActivity(
                            Intent(
                                applicationContext,
                                MainActivity::class.java
                            )
                        )
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }

                    // ...
                }

        }

    }



}
