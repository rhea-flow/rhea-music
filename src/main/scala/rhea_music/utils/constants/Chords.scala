package rhea_music.utils.constants

import jm.constants.Pitches._
import jm.constants.Chords._
import jm.constants.Durations._
import jm.music.data.{CPhrase, Note, Phrase}

/**
  * @author Orestis Melkonian
  */
object Chords {

  def Cmaj7: CPhrase = {
    construct(C4, MAJOR_SEVENTH)
  }

  def Fmaj7: CPhrase = {
    construct(F4, MAJOR_SEVENTH)
  }

  def G7: CPhrase = {
    construct(G4, SEVENTH)
  }

  def Bdim7: CPhrase = {
    construct(B3, DIMINISHED_SEVENTH)
  }

  def Am9: CPhrase = {
    construct(A3, MINOR_NINTH)
  }

  def construct(root: Int, chordTones: Array[Int]): CPhrase = {
    val p: CPhrase = new CPhrase()
    p.addChord(Array(root) ++ chordTones.map(i => root + i), QN)
    p
  }

}
