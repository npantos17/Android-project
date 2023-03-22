package rs.raf.jul.nikola_pantos_rn5117.data.models

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun arrayListToString(arrayList: ArrayList<String>?): String? {
        if (arrayList.isNullOrEmpty()) return null
        val string = StringBuilder()
        for (item in arrayList) {
            val isNotTheLastItemInTheArrayList = (item == arrayList.last()).not()
            if (isNotTheLastItemInTheArrayList) {
                string.append(item).append(",")
            } else {
                string.append(item)
            }
        }
        return string.toString()
    }

    @TypeConverter
    fun stringToArrayList(string: String?): ArrayList<String>? {
        when {
            string.isNullOrEmpty() -> {
                return null
            }
            string.contains(",").not() -> {
                val list = ArrayList<String>()
                list.add(string)
                return list
            }
            else -> {
                return string.split(",".toRegex())
                    .dropLastWhile { it.isEmpty() } as ArrayList<String>
            }
        }
    }
}