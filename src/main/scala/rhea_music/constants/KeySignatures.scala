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
    buffer += new KeySignature(major, new Note(tone = E, mod = b, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = A, mod = b, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = D, mod = b, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = G, mod = b, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = C, mod = b, duration = noDuration))

    // Sharp keys
    buffer += new KeySignature(major, new Note(tone = G, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = D, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = A, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = E, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = B, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = F, mod = s, duration = noDuration))
    buffer += new KeySignature(major, new Note(tone = C, mod = s, duration = noDuration))

    buffer.toArray
  }
}
