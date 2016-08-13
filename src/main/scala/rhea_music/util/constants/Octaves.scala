package rhea_music.util.constants

/**
  * @author Orestis Melkonian
  */
object Octaves {

  // Type alias
  type Octave = Int

  // Constants
  val _0 = 0
  val _1 = 1
  val _2 = 2
  val _3 = 3
  val _4 = 4
  val _5 = 5
  val _6 = 6
  val _7 = 7
  val _8 = 8
  val _9 = 9
  val _10 = 10

  // Array collection
  def allOctaves: Array[Octave] = "0 1 2 3 4 5 6 7 8 9 10"

  // Implicit conversion
  implicit def fromOctaveArray(str: String): Array[Octave] = str.split(" ").map(_.toInt)
}
