package rhea_music.util.constants

/**
  * @author Orestis Melkonian
  */
object Ratios {

  // Type alias
  type Ratio = String

  // Constants
  val _3_2 = "3:2"
  val _5_4 = "5:4"

  // Array collection
  def allRatios: Array[Ratio] = "3:2 5:4"

  // Implicit conversion
  implicit def fromOctaveArray(str: String): Array[Ratio] = str.split(" ")
}
