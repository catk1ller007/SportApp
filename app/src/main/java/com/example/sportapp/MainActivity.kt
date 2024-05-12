package com.example.sportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sportapp.DB.Item
import com.example.sportapp.DB.MainDB
import com.example.sportapp.databinding.ActivityRegistrationBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var blinding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blinding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(blinding.root)

        val db = MainDB.getDb(this)

        blinding.btnVoiti.setOnClickListener{
            val secondPassword = findViewById<EditText>(R.id.reppassReq)
            val item = Item(
                null,
                blinding.nickname.text.toString(),
                blinding.loginReg.text.toString(),
                blinding.passwordReg.text.toString()
            )
            if (secondPassword.text.toString() == blinding.passwordReg.text.toString()
                && secondPassword.text.isNotEmpty()
                && blinding.passwordReg.text.isNotEmpty()
                && blinding.nickname.text.isNotEmpty()
            ) {
                // Условие проверки пройдено, добавляем элемент в базу данных
                Thread {
                    db.getDao().insertItem(item)
                }.start()

                // Создаю intent, для перехода на другую страницу и передачу логина в профиль
                val intent = Intent(this, Authorization::class.java)

                intent.putExtra("LOGIN_EXTRA", blinding.loginReg.text.toString())
                intent.putExtra("NICKNAME_EXTRA", blinding.nickname.text.toString())
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                startActivity(intent)

            } else if (secondPassword.text.toString() != blinding.passwordReg.text.toString()){
                // Условие проверки не пройдено, выводим сообщение об ошибке
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show()

            } else if (secondPassword.text.isEmpty()
                || blinding.passwordReg.text.isEmpty()
                || blinding.loginReg.text.isEmpty()
                || blinding.nickname.text.isEmpty()) {
                Toast.makeText(this, "Введите все данные", Toast.LENGTH_LONG).show()
            }
        }
    }
}