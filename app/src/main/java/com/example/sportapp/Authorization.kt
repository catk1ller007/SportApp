package com.example.sportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sportapp.DB.Item
import com.example.sportapp.DB.MainDB

class Authorization : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        val db = MainDB.getDb(this@Authorization)

        val button = findViewById<Button>(R.id.btnVoitiAuto)
        button.setOnClickListener {

            val loginEditText = findViewById<EditText>(R.id.loginEditText)
            val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()


            if (login.isNotEmpty() && password.isNotEmpty()) {

                // Условие проверки пройдено, добавляем элемент в базу данных
                Thread {
                    val user = db.getDao().getUserByLoginAndPassword(login, password)
                    // Проверяем, найден ли пользователь и совпадает ли его пароль с введенным пользователем
                    if (user != null && user.password == password && user.email  == login) {
                        // Авторизация успешна, переходим на следующий экран
                        val intent = Intent(this@Authorization, MyProfile::class.java)

                        // передаем данные о пользователе в профиль, если нужно
                        intent.putExtra("LOGIN_EXTRA", login)

                        val nickname = user.name.toString()
                        intent.putExtra("NICKNAME_EXTRA", nickname)

                        startActivity(intent)
                    } else {
                        Log.d("ACTV", "Я в ELSE")
                        // Пользователь не найден или пароль не совпадает, выводим сообщение об ошибке
                        Toast.makeText(this@Authorization, "Неверный логин или пароль", Toast.LENGTH_LONG).show()
                    }
                }.start()


            } else {
                // Поля логина и пароля не должны быть пустыми
                Toast.makeText(this@Authorization, "Введите логин и пароль", Toast.LENGTH_LONG).show()
            }
        }
    }
}