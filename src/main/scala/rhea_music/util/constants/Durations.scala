package rhea_music.util.constants

/**
  * @author Orestis Melkonian
  */
object Durations {

  def getDurationRange(s1: String, s2: String): Array[String] = {
    val from = allDurations.indexOf(s1)
    val to = allDurations.indexOf(s2)
    allDurations.slice(from, to + 1)
  }

  def allDurations: Array[String] = Array("w", "h", "q", "i", "s", "t")//, "x", "o")
}
