package com.goga133.task1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/*
Задание 1. Скачать Android SDK + Eclipse (Eclipse ADT Bundle) / Android Studio http://developer.android.com/sdk/index.html,
а также последню версию java (JDK) http://www.oracle.com/technetwork/java/index-jsp-138363.html (или просто набрать в yandex "JDK" и пройти по ссылке на oracle.com).
Установить всё это. Создать новый проект, зайти в Android SDK и скачать какую-нибудь версию Android SDK (например, lollipop - 5.0.1),
выделив все инструменты для работы с ней; сконфигурировать эмулятор (желательно эмулировать своё собственное мобильное устройство,
включая версию андроид на нём в качестве Target SDK).
Изменить TextView с надписью "Hello world" на свои ФИО и группу
(далее этот TextView должен появляться в реализации каждого задания вплоть до 16).
Запустить проект на эмуляторе и убедиться, что всё работает.

Задание 2. Создать новый проект, написать программу, которая выводит в элемент TextView надпись,
введённую пользователем в текстовом поле EditText после нажатия на кнопку Button.
Помимо этого в Activity должен быть TextView с ФИО студента и группой.
Запустить на эмуляторе и убедиться, что всё работает.


 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            textView.text = editText.text;
        }
    }
}