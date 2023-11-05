fun main(args: Array<String>) {
    agoToText("Alex", 30)
    agoToText("Вася", 58*60)
    agoToText("Женя :)", 3610)
    agoToText("Олег", 3630)
    agoToText("Аркадий", 3600*2+1)
    agoToText("Crazy Frog", 3600*3+1)
}

fun agoToText(name: String, agoSecs: Int) {
    val agoTime: Int;
    var agoText: String;

    agoText = when {
        agoSecs < 61 -> "только что"
        agoSecs < 3601 -> agoToMinsText(agoSecs)
        agoSecs < 86401 -> agoToHoursText(agoSecs)
        agoSecs < 172801 -> "вчера"
        agoSecs < 259201 -> "позавчера"
        else -> "давно"
    }

    println(
        "$name был(а) " + agoText
    )
}

fun agoToMinsText(agoSecs: Int): String {
    val mins = agoSecs / 60
    val lastDigit = mins % 10
    return "$mins " + when {
        mins != 11 && lastDigit == 1 -> "минуту назад"
        (mins !in 12..14) && lastDigit in 2..4 -> "минуты назад"
        else -> "минут назад"
    }
}

fun agoToHoursText(agoSecs: Int): String {
    val hours = agoSecs / 3600;
    val lastDigit = hours % 10
    return "$hours " + when {
        hours != 11 && lastDigit == 1 -> "час назад"
        (hours !in 12..14) && lastDigit in 2..4 -> "часа назад"
        else -> "часов назад"
    }
}