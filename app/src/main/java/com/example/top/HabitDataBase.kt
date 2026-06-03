package com.example.top

import android.content.Context
import android.content.SharedPreferences

class HabitDatabase(context: Context) {
    val pref: SharedPreferences = context.getSharedPreferences("habits_prefs", Context.MODE_PRIVATE)

    fun saveHabits(habits: List<Habit>) {
        val editor = pref.edit()
        editor.putInt("count", habits.size)

        for ((index, habit) in habits.withIndex()) {
            editor.putInt("${index}_id", habit.id)
            editor.putString("${index}_name", habit.name)
            editor.putBoolean("${index}_isCompleted", habit.isCompleted)
        }
        editor.apply()
    }

    fun loadHabits(): MutableList<Habit> {
        val habits = mutableListOf<Habit>()
        val count = pref.getInt("count", 0)

        for (i in 0 until count) {
            val id = pref.getInt("${i}_id", 0)
            val name = pref.getString("${i}_name", "") ?: ""
            val isCompleted = pref.getBoolean("${i}_isCompleted", false)
            habits.add(Habit(id, name, isCompleted))
        }
        return habits
    }
}