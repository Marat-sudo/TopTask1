//package com.example.top
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.CheckBox
//import android.widget.TextView
//import androidx.cardview.widget.CardView
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.filament.View
//import com.google.android.material.internal.MaterialCheckable
//
//class HabitAdapter (
//    private var habits: MutableList<Habit>,
//    private val onCheckBoxClick: (Habit, Boolean) -> Unit,
//    private val onDeceteClick: (Habit) -> Unit):
//        RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_habit, parent, false)
//        return HabitViewHolder(view)
//    }
//
//    override fun onBindViewHolder(
//        holder: HabitViewHolder,
//        position: Int,
//    ) {
//        holder.bind(habits[position])
//    }
//
//    override fun getItemCount(): Int = habits.size
//
//    fun updateHabits(newHabits: MutableList<Habit>) {
//        habits = newHabits
//        notifyDataSetChanged()
//    }
//
//    inner class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val cardView: CardView = itemView as CardView
//        private val habitName: TextView = itemView.findViewById(R.id.habitName)
//        private val habitCheckBox: CheckBox = itemView.findViewById(R.id.habitCheckbox)
//
//        fun bind(habit: Habit) {
//            habitName.text = habit.name
//            habitCheckBox.isChecked = habit.isCompleted
//        }
//    }
//
//}