package rhea_music.util.constants


/**
  * @author Orestis Melkonian
  */

object ChordTypes {

  // Type alias
  type ChordType = String

  // Constants
  val M = "maj"
  val m = "min"
  val aug = "aug"
  val dim = "dim"

  val sus4 = "sus4"
  val sus2 = "sus2"

  val M7 = "maj7"
  val m7 = "min7"
  val _7 = "dom7"
  val dim7 = "dim7"

  val M6 = "maj6"
  val m6 = "min6"

  val M9 = "maj9"
  val m9 = "min9"
  val _9 = "dom9"
  val add9 = "add9"

  val m11 = "min11"
  val _11 = "dom11"

  val M13 = "maj13"
  val m13 = "min13"
  val _13 = "dom13"

  val _7b5 = "dom7<5"
  val _7s5 = "dom7>5"
  val _7b5b9 = "dom7<5<9"
  val _7b5s9 = "dom7<5>9"
  val _7s5b9 = "dom7>5<9"
  val _7s5s9 = "dom7>5>9"

  val M7b5 = "maj7<5"
  val M7s5 = "maj7>5"
  val mM7 = "minmaj7"

  // Array collection
  def allChordTypes: Array[ChordType] = Array(
    M, m, aug, dim, sus4, sus2, M7, m7, _7, dim7, M6, m6, M9, m9, _9, add9, m11, _11,
    M13, m13, _13, _7b5, _7s5, _7b5b9, _7b5s9, _7s5b9, _7s5s9, M7b5, M7s5, mM7
  )
}
