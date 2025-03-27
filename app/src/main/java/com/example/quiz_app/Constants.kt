package com.example.quiz_app

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.que1,
            "Argentina","Australia","Israel","Denmark",
            3
        )
        questionList.add(que1)
        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.que2,
            "Argentina","Australia","Israel","Denmark",
            1
        )
        questionList.add(que2)
        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.que3,
            "Argentina","Australia","Israel","Denmark",
            4
        )
        questionList.add(que3)
        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.que4,
            "Argentina","Australia","Israel","Denmark",
            2
        )
        questionList.add(que4)
        val que5 = Question(
            5,
            "Who is known as the father of the computer?",
            R.drawable.que5,
            "Charles Babbage","Alan Turing","Tim Berners-Lee","Bill Gates",
            1
        )
        questionList.add(que5)
        val que6 = Question(
            6,
            "Who invented the telephone?",
            R.drawable.que6,
            "Thomas Edison", "Alexander Graham Bell","Nikola Tesla","Albert Einstein",
            2
        )
        questionList.add(que6)
        val que7 = Question(
            7,
            "Which country is famous for the Eiffel Tower?",
            R.drawable.que7,
            "Italy", "Spain","France","Germany",
        3
        )
        questionList.add(que7)
        val que8 = Question(
            8,
            "Which planet is known as the Red Planet?",
            R.drawable.que8,
            "Earth", "Mars","Venus","Jupiter",
            2
        )
        questionList.add(que8)
        val que9 = Question(
            9,
            "Which car brand has this logo?",
            R.drawable.qwe9,
            "BMW", "Tesla","Mercedes","Ford",
            2
        )
        questionList.add(que9)
        val que10 = Question(
            10,
            "Who is considered the author of the Mahabharata?",
            R.drawable.que10,
            "Valmiki", "Ved Vyasa", "Tulsidas", "Kalidasa",
            2
        )
        questionList.add(que10)

        val que11 = Question(
            11,
            "Which king is known for renouncing his kingdom and becoming a Jain monk?",
            R.drawable.que11,
            "Ashoka", "Chandragupta Maurya", "Harsha", "Krishna Deva Raya",
            2
        )
        questionList.add(que11)

        val que12 = Question(
            12,
            "Which temple is known as the richest Hindu temple in the world?",
            R.drawable.que12,
            "Kedarnath Temple", "Tirupati Balaji Temple", "Padmanabhaswamy Temple", "Somnath Temple",
            3
        )
        questionList.add(que12)

        val que13 = Question(
            13,
            "Which ancient Indian university was a center of Hindu learning?",
            R.drawable.que13,
            "Takshashila University", "Nalanda University", "Vikramshila University", "Kanchipuram University",
            2
        )
        questionList.add(que13)

        val que14 = Question(
            14,
            "Which Indian ruler was known as ‘Vikramaditya’ and promoted Hindu culture?",
            R.drawable.que14,
            "Samudragupta", "Chandragupta II", "Harsha", "Raja Raja Chola",
            2
        )
        questionList.add(que14)

        val que15 = Question(
            15,
            "Which Hindu king rebuilt the Somnath temple after its destruction?",
            R.drawable.que15,
            "Raja Raja Chola", "Vikramaditya", "Prithviraj Chauhan", "King Bhoja",
            4
        )
        questionList.add(que15)

        return questionList
    }
}