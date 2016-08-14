package rhea_music.constants

/**
  * @author Orestis Melkonian
  */
object NoteMods {

  // Type alias
  type NoteMod = String

  // Constants
  val noNoteMod = ""
  val s = "#"
  val ss = "##"
  val b = "b"
  val bb = "bb"
  val n = "n"

  // Array collection
  def allNoteMods: Array[NoteMod] = Array(s, ss, b, bb, n)


  def getDelta(noteMod: NoteMod): Int = noteMod match {
    case `noteMod` | `n` => 0
    case `s` => 1
    case `ss` => 2
    case `b` => -1
    case `bb` => -2
  }

}
