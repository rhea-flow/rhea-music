package rhea_music.util.constants

import rhea_music.ImplicitConversions._

/**
  * @author Orestis Melkonian
  */
object Durations {

  // Type alias
  type Duration = String

  // Constants
  val whole = "w"
  val whole_ = "w."
  val whole__ = "w.."
  val half = "h"
  val half_ = "h."
  val half__ = "h.."
  val quarter = "q"
  val quarter_ = "q."
  val quarter__ = "q.."
  val eighth = "i"
  val eighth_ = "i."
  val eighth__ = "i.."
  val sixteenth = "s"
  val sixteenth_ = "s."
  val sixteenth__ = "s.."
  val thirty_second = "t"
  val thirty_second_ = "t."
  val thirty_second__ = "t.."
  val sixty_fourth = "x"
  val sixty_fourth_ = "x."
  val sixty_fourth__ = "x.."
  val one_twenty_eighth = "o"
  val one_twenty_eighth_ = "o."
  val one_twenty_eighth__ = "o.."

  // Array collection
  def allDurations: Array[Duration] = Array(
    "w", "w.", "w..",
    "h", "h.", "h..",
    "q", "q.", "q..",
    "i", "i.", "i..",
    "s", "s.", "s..",
    "t", "t.", "t..",
    "x", "x.", "x..",
    "o", "o.", "o.."
  )
  
  def basicDurations: Array[Duration] = Array(
    "w", "h", "q", "i", "s"
  )

  def verySlow: Array[Duration] = allDurations.fromTo("w", "q")

  def slow: Array[Duration] = allDurations.fromTo("h", "q..")

  def medium: Array[Duration] = allDurations.fromTo("h", "i..")

  def fast: Array[Duration] = allDurations.fromTo("i", "s..")

  def veryFast: Array[Duration] = allDurations.fromTo("s", "o..")
}
