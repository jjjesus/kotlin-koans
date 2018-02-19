package iii_conventions

// JJJ: extend data class to be Comparable
//
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {

    // JJJ: If years are unequal, that's all you need to know
    //      If same year, then, check month
    //      If same month, then, check day of month
    //
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

// JJJ: I think we assume that the 'other' MyDate is greater than 'this'
//
operator fun MyDate.rangeTo(other: MyDate): DateRange
{
    return DateRange(this, other)
}

// JJJ: This was provided
//
enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

// JJJ: To implement a range, need 'contains' and 'iterator'
//      The iterator is implemented as a separate class
//
class DateRange(override val start: MyDate, override val endInclusive: MyDate):
        ClosedRange<MyDate>, Iterable<MyDate> {
    override fun contains(value: MyDate): Boolean {
        return start <= value && value <= endInclusive
    }

    override fun iterator(): Iterator<MyDate> = DateRangeIterator(this)
}

// JJJ: To implement iterator, override hasNext() and next()
//
class DateRangeIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current = dateRange.start;

    override fun hasNext(): Boolean {
        return current <= dateRange.endInclusive
    }

    override fun next(): MyDate {
        val result = current

        // The nextDay() method was provided as a utility
        current = current.nextDay()
        return result
    }
}
