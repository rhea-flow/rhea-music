package rhea_music.util.constants

/**
  * @author Orestis Melkonian
  */
object NoteMods {

  // Type alias
  type NoteMod = String

  // Constants
  val s = "#"
  val ss = "##"
  val b = "b"
  val bb = "bb"
  val n = "n"

  // Array collection
  def allNoteMods: Array[NoteMod] = "# ## b bb n"

  // Implicit conversion
  implicit def fromOctaveArray(str: String): Array[NoteMod] = str.split(" ")
}
