package by.bsu.lsebackend.extension

import by.bsu.lsebackend.dto.QuizRequest
import by.bsu.lsebackend.dto.QuizResponse
import by.bsu.lsebackend.entity.Quiz

fun Quiz.toResponse() = QuizResponse(
    this.id,
    this.name,
    this.items.map { it.toResponse() }
)

fun Quiz.QuizItem.toResponse() = QuizResponse.QuizItemResponse(
    this.question.toResponse(),
    this.answers.map { it.toResponse() }
)

fun Quiz.QuizItem.Answer.toResponse() = QuizResponse.QuizItemResponse.AnswerResponse(
    this.id,
    this.text
)

fun Quiz.QuizItem.Question.toResponse() = QuizResponse.QuizItemResponse.QuestionResponse(
    this.id,
    this.text,
    this.multipleChoice
)

fun QuizRequest.toEntity() = Quiz(
    name = this.name,
    items = this.items.map { it.toEntity() },
    maxScore = this.maxScore
)

fun QuizRequest.QuizItemRequest.toEntity() = Quiz.QuizItem(
    this.question.toEntity(),
    this.answers.map { it.toEntity() }
)

fun QuizRequest.QuizItemRequest.AnswerRequest.toEntity() = Quiz.QuizItem.Answer(
    text = this.text,
    correct = this.correct
)

fun QuizRequest.QuizItemRequest.QuestionRequest.toEntity() = Quiz.QuizItem.Question(
    text = this.text,
    multipleChoice = this.multipleChoice,
    cost = this.cost
)
