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

  // Ranges
  val low = 2 to 3 toArray
  val lowmid = 2 to 4 toArray
  val mid = 3 to 4 toArray
  val midhigh = 3 to 5 toArray
  val high = 4 to 5 toArray

  // Array collection
  def allOctaves: Array[Octave] = 0 to 9 toArray
}
