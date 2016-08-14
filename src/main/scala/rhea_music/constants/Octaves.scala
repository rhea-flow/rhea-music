package rhea_music.constants

/**
  * @author Orestis Melkonian
  */
object Octaves {

  // Type alias
  type Octave = Int

  // Constants
  val noOctave = -1
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

  // Array collection
  def allOctaves: Array[Octave] = Array(_0, _1, _2, _3, _4, _5, _6, _7, _8, _9)
}
