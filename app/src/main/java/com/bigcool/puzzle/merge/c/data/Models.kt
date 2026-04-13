package com.bigcool.puzzle.merge.c.data

data class Country(
    val id: String,
    val name: String,
    val flagEmoji: String,
    val continentId: String,
    val capital: String,
    val population: String,
    val area: String,
    val language: String,
    val currency: String,
    val landmarks: List<String>,
    val neighbors: List<String>,
    val climate: String,
    val facts: List<String>
)

data class Continent(
    val id: String,
    val name: String,
    val emoji: String,
    val description: String,
    val countries: List<Country>,
    val isSpecial: Boolean = false,
    val specialInfo: String? = null
)

data class Question(
    val text: String,
    val options: List<String>,
    val correctIndex: Int
)

data class GeoTest(
    val id: Int,
    val title: String,
    val description: String,
    val emoji: String,
    val questions: List<Question>
)

data class TestStats(
    val testId: Int,
    val bestScore: Int,
    val lastScore: Int,
    val attempts: Int,
    val completions: Int,
    val averageScore: Float,
    val totalQuestions: Int
)
