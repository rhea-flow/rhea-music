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

    buffer += new KeySignature(major, new Note(root = C, duration = noDuration))
    
    // Flat keys
    buffer += new KeySignature(major, new Note(root = F, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = B, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Eb, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Ab, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Db, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Gb, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Cb, duration = noDuration))

    // Sharp keys
    buffer += new KeySignature(major, new Note(root = G, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = D, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = A, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = E, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = B, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Fs, duration = noDuration))
    buffer += new KeySignature(major, new Note(root = Cs, duration = noDuration))

    buffer.toArray
  }
}
