package rhea_music.constants

/**
  * @author Orestis Melkonian
  */
object Tones {

  // Type alias
  type Tone = String

  // Constants
  val C = "C"
  val D = "D"
  val E = "E"
  val F = "F"
  val G = "G"
  val A = "A"
  val B = "B"
  val R = "R"

  // Array collection
  def allTones: Array[Tone] = Array(C, D, E, F, G, A, B, R)
}
