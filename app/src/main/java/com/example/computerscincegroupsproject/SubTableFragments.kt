package com.example.computerscincegroupsproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.computerscincegroupsproject.databinding.FragmentSubTableFragmentsBinding
import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager
import com.michalsvec.singlerowcalendar.utils.DateUtils.getDay3LettersName
import com.michalsvec.singlerowcalendar.utils.DateUtils.getDayNumber
import java.util.*

class SubTableFragments : Fragment() {
    //LOGS
    private val TAG = "SubTableFragments"

    //UI
    private var binding: FragmentSubTableFragmentsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSubTableFragmentsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectionManager = object : CalendarSelectionManager {
            override fun canBeItemSelected(position: Int, date: Date): Boolean {
                return false
            }
        }


        var calendarViewManager: CalendarViewManager = object : CalendarViewManager {

            override fun bindDataToCalendarView(
                holder: SingleRowCalendarAdapter.CalendarViewHolder,
                date: Date,
                position: Int,
                isSelected: Boolean,
            ) {
                holder.itemView.setOnClickListener {
                    Log.d(TAG, "bindDataToCalendarView: item selected $position")
                }
                holder.itemView.findViewById<AppCompatTextView>(R.id.dayNum).text =
                    getDayNumber(date)
                holder.itemView.findViewById<AppCompatTextView>(R.id.dayText).text =
                    getDay3LettersName(date)
            }

            override fun setCalendarViewResourceId(
                position: Int,
                date: Date,
                isSelected: Boolean,
            ): Int {
                val cal = Calendar.getInstance()
                cal.time = date
                return if (isSelected) {
                    return when (cal[Calendar.DAY_OF_WEEK]) {
                        Calendar.FRIDAY -> R.layout.calender_item_holiday
                        Calendar.SATURDAY -> R.layout.calender_item_holiday
                        else -> R.layout.calender_item_selected
                    }
                } else {
                    return when (cal[Calendar.DAY_OF_WEEK]) {
                        Calendar.FRIDAY -> R.layout.calender_item_holiday
                        Calendar.SATURDAY -> R.layout.calender_item_holiday
                        else -> R.layout.calender_item_un_selected
                    }
                }
            }
        }

        var calendarChangesObserver: CalendarChangesObserver = object : CalendarChangesObserver {
            override fun whenCalendarScrolled(dx: Int, dy: Int) {
                super.whenCalendarScrolled(dx, dy)
            }

            override fun whenSelectionChanged(isSelected: Boolean, position: Int, date: Date) {
                super.whenSelectionChanged(isSelected, position, date)
            }

            override fun whenSelectionRefreshed() {
                super.whenSelectionRefreshed()
            }

            override fun whenSelectionRestored() {
                super.whenSelectionRestored()
            }

            override fun whenWeekMonthYearChanged(
                weekNumber: String,
                monthNumber: String,
                monthName: String,
                year: String,
                date: Date,
            ) {
                super.whenWeekMonthYearChanged(weekNumber, monthNumber, monthName, year, date)
            }
        }

        val signalRow = binding?.calenderRow?.apply {
            this.calendarViewManager = calendarViewManager
            calendarSelectionManager = selectionManager
            this.calendarChangesObserver = calendarChangesObserver
            futureDaysCount = 15
            pastDaysCount = 15
            includeCurrentDate = true

            init()
        }
    }

}