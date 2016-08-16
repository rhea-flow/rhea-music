package rhea_music.constants

import rhea_music.music_types.{KeySignature, Note}
import rhea_music.constants.Tones._
import rhea_music.constants.KeySignatureTypes.major

/**
  * @author Orestis Melkonian
  */

object KeySignatures {

  /**
    * Constants
    */
  // Flat
  val Cmajor = new KeySignature(major, C)
  val Fmajor = new KeySignature(major, F)
  val Bmajor = new KeySignature(major, B)
  val Ebmajor = new KeySignature(major, Eb)
  val Abmajor = new KeySignature(major, Ab)
  val Dbmajor = new KeySignature(major, Db)
  val Gbmajor = new KeySignature(major, Gb)
  val Cbmajor = new KeySignature(major, Cb)
  // Sharp
  val Gmajor = new KeySignature(major, G)
  val Dmajor = new KeySignature(major, D)
  val Amajor = new KeySignature(major, A)
  val Emajor = new KeySignature(major, E)
  val Fsmajor = new KeySignature(major, Fs)
  val Csmajor = new KeySignature(major, Cs)

  def allKeySignatures: Array[KeySignature] = Array(
    Cmajor, Fmajor, Bmajor, Ebmajor, Abmajor, Dbmajor, Gbmajor, Cbmajor,
    Gmajor, Dmajor, Amajor, Emajor, Bmajor, Fsmajor, Csmajor
  )
}
