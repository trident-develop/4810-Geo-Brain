package com.ironhidegames.android.ironmari.data

import android.content.Context
import android.content.SharedPreferences

/**
 * Simple SharedPreferences wrapper that stores per-test statistics and overall
 * user progress. Uses a stable key schema so existing data is preserved across
 * app updates.
 */
class PrefsManager(context: Context) {

    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private fun keyBest(id: Int) = "test_${id}_best"
    private fun keyLast(id: Int) = "test_${id}_last"
    private fun keyAttempts(id: Int) = "test_${id}_attempts"
    private fun keyCompletions(id: Int) = "test_${id}_completions"
    private fun keyTotalScore(id: Int) = "test_${id}_total_score"
    private fun keyTotalQuestions(id: Int) = "test_${id}_total_q"

    /**
     * Record a finished (or expired) test attempt.
     * @param score number of correct answers
     * @param totalQuestions total number of questions
     * @param completed true if the user answered all questions (not timed out)
     */
    fun recordAttempt(testId: Int, score: Int, totalQuestions: Int, completed: Boolean) {
        val editor = prefs.edit()
        val attempts = prefs.getInt(keyAttempts(testId), 0) + 1
        editor.putInt(keyAttempts(testId), attempts)

        editor.putInt(keyLast(testId), score)

        val prevBest = prefs.getInt(keyBest(testId), -1)
        if (score > prevBest) editor.putInt(keyBest(testId), score)

        if (completed) {
            val completions = prefs.getInt(keyCompletions(testId), 0) + 1
            editor.putInt(keyCompletions(testId), completions)
        }

        // Track running sum for average
        val totalScore = prefs.getInt(keyTotalScore(testId), 0) + score
        val totalQ = prefs.getInt(keyTotalQuestions(testId), 0) + totalQuestions
        editor.putInt(keyTotalScore(testId), totalScore)
        editor.putInt(keyTotalQuestions(testId), totalQ)
        editor.apply()
    }

    fun getStats(testId: Int, totalQuestions: Int): TestStats {
        val attempts = prefs.getInt(keyAttempts(testId), 0)
        val best = prefs.getInt(keyBest(testId), -1)
        val last = prefs.getInt(keyLast(testId), -1)
        val completions = prefs.getInt(keyCompletions(testId), 0)
        val totalScore = prefs.getInt(keyTotalScore(testId), 0)
        val average = if (attempts == 0) 0f
        else (totalScore.toFloat() / attempts.toFloat())
        return TestStats(
            testId = testId,
            bestScore = if (best < 0) 0 else best,
            lastScore = if (last < 0) 0 else last,
            attempts = attempts,
            completions = completions,
            averageScore = average,
            totalQuestions = totalQuestions
        )
    }

    fun hasAnyAttempt(testId: Int): Boolean =
        prefs.getInt(keyAttempts(testId), 0) > 0

    companion object {
        private const val PREFS_NAME = "geo_brain_prefs"
    }
}
