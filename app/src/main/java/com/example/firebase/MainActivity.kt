package com.example.firebase


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonRegistration.setOnClickListener {
            val resultemail=edit1.text.toString()
            val resultpassword=edit2.text.toString()

            if (resultemail.isEmpty() || resultpassword.isEmpty()) {
                Toast.makeText(this, "გრაფა ცარიელია", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(resultemail,resultpassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "მომხმარებელი დარეგისტრირდა", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, "მომხმარებელი ვერ დარეგისტრირდა", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

}