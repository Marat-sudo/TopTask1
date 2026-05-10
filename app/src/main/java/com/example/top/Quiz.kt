package com.example.top

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import models.Question
import kotlin.collections.mutableListOf

class Quiz : AppCompatActivity() {
    private lateinit var next: Button
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button

    private lateinit var textViev: TextView



    private var count = 0
    private var step = -1
    private var questionsList = mutableListOf<Question>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        // Инициализация UI
        initViews()

        // Загрузка вопросов
        loadQuestions()

        // Обработчики нажатий на варианты ответов
        setupOptionClickListeners()

        // Кнопка "Следующий вопрос"
        next.setOnClickListener {
            nextStep()

        }


    }

    private fun initViews()
    {
        next= findViewById(R.id.startNext)
        b1 = findViewById(R.id.answer1)
        b2 = findViewById(R.id.answer2)
        b3 = findViewById(R.id.answer3)
        b4 = findViewById(R.id.answer4)
        textViev = findViewById(R.id.text)
    }

    private fun displayQuestion() {
        // Сброс выбранного ответа
        resetOptionsColor()

        // Получаем текущий вопрос
        val currentQuestion = questionsList[step]

        // Отображаем текст вопроса
        textViev.text = currentQuestion.text

        // Отображаем варианты ответов
        b1.text = currentQuestion.options[0]
        b2.text = currentQuestion.options[1]
        b3.text = currentQuestion.options[2]
        b4.text = currentQuestion.options[3]




    }

    private fun setupOptionClickListeners()
    {
        b1.setOnClickListener {
            setContent(b1)

        }

        b2.setOnClickListener {
            setContent(b2)

        }

        b3.setOnClickListener {
            setContent(b3)

        }

        b4.setOnClickListener {
            setContent(b4)

        }
    }


    private fun setContent(b: Button)
    {
        val que = questionsList[step]
        val answer = que.correctAnswerIndex


        if (b.text == que.options[answer]){
            b.setBackgroundColor(getColor(R.color.MediumAquamarine))
            count++
            textViev.text = "вы ответили верно"

        }
        else{
            b.setBackgroundColor(getColor(R.color.LightCoral))
            textViev.text = "вы ответили неверно"
        }
        setStatus(false)
    }

    private fun setStatus(status: Boolean)
    {
        val options = listOf(b1, b2, b3, b4)
        for (i in 0..3)
        {
            val button = options[i]

            button.isClickable = status
        }
    }

    private fun nextStep() {
        if (step == -1) {
            b1.visibility = View.VISIBLE
            b2.visibility = View.VISIBLE
            b3.visibility = View.VISIBLE
            b4.visibility = View.VISIBLE

            textViev.visibility = View.VISIBLE


            next.text = "продолжить"
            step++

            displayQuestion()
            return
        }
        else if (step == questionsList.size - 1)
        {
            b1.visibility = View.INVISIBLE
            b2.visibility = View.INVISIBLE
            b3.visibility = View.INVISIBLE
            b4.visibility = View.INVISIBLE

            textViev.text = "конец всего правильных ответов\n$count"
            next.text = "заново"

            count = 0
            step = -1

            return
        }

        step++

        displayQuestion()

        setupOptionClickListeners()



    }

    private fun resetOptionsColor() {
        setStatus(true)
        val options = listOf(b1, b2, b3, b4)
        for (i in 0..3)
        {
            val button = options[i]
            button.setBackgroundColor(getColor(R.color.purpleTop))
        }
    }



    private fun loadQuestions() {
        questionsList = mutableListOf(
            Question(
                "Какой язык программирования использовался для создания Minecraft?",
                listOf("Python", "Java", "C++", "Swift"),
                1
            ),
            Question(
                "Моя любимая кошка из списка",
                listOf(
                    "кокао",
                    "комару",
                    "комуги",
                    "юне"
                ),
                0

            ),
            Question(
                "Какой тег используется для создания кнопки в XML?",
                listOf("<TextView>", "<Button>", "<ImageButton>", "<EditText>"),
                1,

                ),
            Question(
                "Что такое View в Android?",
                listOf(
                    "База данных",
                    "Базовый класс для всех UI компонентов",
                    "Сетевое соединение",
                    "Файловая система"
                ),
                1

            ),
            Question(
                "Какой метод вызывается при создании Activity?",
                listOf("onStart()", "onInit()", "onResume()", "onCreate()"),
                3
            ),
            Question(
                "Что такое Kotlin?",
                listOf(
                    "Язык программирования",
                    "База данных",
                    "Операционная система",
                    "Фреймворк"
                ),
                0
            ),
            Question(
                "Какой файл отвечает за макет Activity?",
                listOf(".kt файл", ".java файл", ".xml файл", ".gradle файл"),
                2
            ),
            Question(
                "Что означает ООП?",
                listOf(
                    "Объектно-Ориентированное Программирование",
                    "Основы Общего Программирования",
                    "Объединение Объектов Программы",
                    "Обработка Ошибок Программиста"
                ),
                0
            ),
            Question(
                "Какой тег используется для отображения текста?",
                listOf("<Button>", "<TextView>", "<EditText>", "<ImageView>"),
                1
            ),
            Question(
                "Как называется среда разработки от Google для Android?",
                listOf("Xcode", "Visual Studio", "Android Studio", "Eclipse"),
                2
            )
        )
    }



}


