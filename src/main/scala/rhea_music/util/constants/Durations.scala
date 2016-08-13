package rhea_music.util.constants

import rhea_music.ImplicitConversions._

/**
  * @author Orestis Melkonian
  */
object Durations {

  def allDurations: Array[String] = Array(
    "w", "w.", "w..",
    "h", "h.", "h..",
    "q", "q.", "q..",
    "i", "i.", "i..",
    "s", "s.", "s..",
    "t", "t.", "t..",
    "x", "x.", "x..",
    "o", "o.", "o.."
  )

  def basicDurations: Array[String] = Array(
    "w", "h", "q", "i", "s"
  )

  def verySlow: Array[String] = allDurations.fromTo("w", "q")

  def slow: Array[String] = allDurations.fromTo("h", "q..")

  def medium: Array[String] = allDurations.fromTo("h", "i..")

  def fast: Array[String] = allDurations.fromTo("i", "s..")

  def veryFast: Array[String] = allDurations.fromTo("s", "o..")
}
