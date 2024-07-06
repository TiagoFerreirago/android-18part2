package com.uninter.aula06project.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.uninter.aula06project.R
import com.uninter.aula06project.todo.presentation.view.ToDoListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtMail = findViewById<TextInputEditText>(R.id.edtMail);
        val edtPassword = findViewById<TextInputEditText>(R.id.edtPassword);

        findViewById<Button>(R.id.btnLogin).setOnClickListener{
            login(edtMail.text.toString(), edtPassword.text.toString());
        }

        findViewById<TextView>(R.id.txtForgot).setOnClickListener{
            startActivity(Intent(this, ForgotActivity::class.java))
        }
    }

    fun login(mail: String, password: String){
        try {
            Log.i("MainActivity","Usuario $mail e senha $password")

            if(mail == "th@gmail.com" && password == "1234")
                startActivity(Intent(this, ToDoListActivity::class.java))
            else
            {
//                Toast.makeText(this,"Usuário ou senha invalido",Toast.LENGTH_LONG).show()
                val dialog = AlertDialog.Builder(this).create()
                dialog.setTitle("Ops houve uma falha")
                dialog.setMessage("usuario ou senha invalidos")
                dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok") { _, w ->
                    dialog.dismiss()
                }
                dialog.show()
            }
        }catch (e : Exception)
        {
            Log.e("MainActivity", e.message.toString())
        }
    }
}