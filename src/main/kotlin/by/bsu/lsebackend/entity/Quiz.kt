package by.bsu.lsebackend.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID

@Document("quizzes")
class Quiz(
    @Id
    val id: String = UUID.randomUUID().toString(),
    @Field("name")
    val name: String,
    @Field("items")
    val items: List<QuizItem>,
) {
    class QuizItem(
        val question: Question,
        val answers: List<Answer>,
    ) {

        class Question(
            val id: String = UUID.randomUUID().toString(),
            val text: String,
            val multipleChoice: Boolean,
            val cost: Int,
        )

        class Answer(
            val id: String = UUID.randomUUID().toString(),
            val text: String,
            val correct: Boolean = false,
        )
    }
}
