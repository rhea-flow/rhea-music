package rhea_music.constants

import rhea_music.ImplicitConversions._
import rhea_music.constants.Intervals.Intervals

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

  val _7b5 = "dom7b5"
  val _7s5 = "dom7s5"

  val M7b5 = "maj7b5"
  val M7s5 = "maj7s5"
  val mM7 = "minmaj7"

  // Array collection
  def allChordTypes: Array[ChordType] = Array(
    M, m, aug, dim, sus4, sus2, M7, m7, _7, dim7, M6, m6, M9, m9, _9, add9, m11, _11,
    M13, m13, _13, _7b5, _7s5, M7b5, M7s5, mM7
  )

  def getNumberOfInversions(chordType: ChordType): Int =
    chordToIntervals.get(chordType).get.length
  
  val chordToIntervals: Map[ChordType, Intervals] = Map(
    M -> "3 5",
    m -> "b3 5",
    aug -> "3 #5",
    dim -> "b3 b5",

    sus4 -> "4 5",
    sus2 -> "2 5",

    M7 -> "3 5 7",
    m7 -> "b3 5 b7",
    _7 -> "3 5 b7",
    dim7 -> "b3 b5 6",

    M6 -> "3 5 6",
    m6 -> "b3 5 b6",

    M9 -> "3 5 7 9",
    m9 -> "b3 5 b7 9",
    _9 -> "3 5 b7 9",
    add9 -> "3 5 9",

    m11 -> "b3 5 b7 9 11",
    _11 -> "3 5 b7 9 11",

    M13 -> "3 5 7 9 13",
    m13 -> "b3 5 b7 9 13",
    _13 -> "3 5 b7 9 13",

    _7b5 -> "3 b5 b7",
    _7s5 -> "3 #5 b7",

    M7b5 -> "3 b5 7",
    M7s5 -> "3 #5 7",
    mM7 -> "b3 5 7"
  )
}
