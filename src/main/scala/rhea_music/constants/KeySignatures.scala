package rhea_music.constants

import rhea_music.music_types.{KeySignature, Note}
import rhea_music.constants.Tones._
import rhea_music.constants.NoteMods.{s, b}
import rhea_music.constants.KeySignatureTypes.{major, minor}
import rhea_music.constants.Durations.noDuration

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */

object KeySignatures {
  

  def allKeySignatures: Array[KeySignature] = {
    var buffer = new ArrayBuffer[KeySignature]()

    buffer += new KeySignature(major, new Note(tone = C, duration = noDuration))
    
    // Flat keys
    buffer += new KeySignature(major, new Note(tone = F, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = B, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Eb, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Ab, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Db, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Gb, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Cb, duration = noDuration))

    // Sharp keys
    buffer += new KeySignature(major, new Note(tone = G, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = D, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = A, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = E, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = B, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Fs, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = Cs, duration = noDuration))

    buffer.toArray
  }
}
