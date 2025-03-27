package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mUserName : String? = null
    private var mCorrectAnswers : Int =0

    private  var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private var progressBar: ProgressBar? = null
    private var tvprogress : TextView? = null
    private var tvquestion : TextView? = null
    private var ivimage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null

    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvprogress = findViewById(R.id.tv_progress)
        tvquestion = findViewById(R.id.tv_question)
        ivimage = findViewById(R.id.iv_image)

        tvOptionOne = findViewById(R.id.tv_OptionOne)
        tvOptionTwo = findViewById(R.id.tv_OptionTwo)
        tvOptionThree = findViewById(R.id.tv_OptionThree)
        tvOptionFour = findViewById(R.id.tv_OptionFour)

        btnSubmit = findViewById(R.id.btn_submit )

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvquestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text="Finish"
        }else{
            btnSubmit?.text = "Submit"
        }

    }

    private  fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089") )
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }
    override fun onClick(view: View?) {
        when (view?.id){
            R.id.tv_OptionOne->{
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_OptionTwo->{
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_OptionThree->{
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_OptionFour->{
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else->{
                            val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val  question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "Finish"
                    }else{
                        btnSubmit?.text = "Go To Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
        }
    }
}