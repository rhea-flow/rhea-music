package rhea_music.constants

import rhea_music.util.ImplicitConversions._

/**
  * @author Orestis Melkonian
  */
object Durations {

  // Type alias
  type Duration = String

  // Constants
  val noDuration = ""
  val wh = "w"
  val wh_ = "w."
  val wh__ = "w.."
  val hf = "h"
  val hf_ = "h."
  val hf__ = "h.."
  val qr = "q"
  val qr_ = "q."
  val qr__ = "q.."
  val eh = "i"
  val eh_ = "i."
  val eh__ = "i.."
  val sh = "s"
  val sh_ = "s."
  val sh__ = "s.."
  val th = "t"
  val th_ = "t."
  val th__ = "t.."
  val sx = "x"
  val sx_ = "x."
  val sx__ = "x.."
  val ote = "o"
  val ote_ = "o."
  val ote__ = "o.."

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
