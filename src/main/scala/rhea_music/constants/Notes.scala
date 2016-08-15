package rhea_music.constants

import rhea_music.music_types.Note
import rhea_music.constants.Tones._
import rhea_music.constants.NoteMods._
import rhea_music.constants.Octaves._
import rhea_music.constants.Durations._

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Notes {

  /*def allRests: Array[Note] = {
    var buffer = new ArrayBuffer[Note]()
    for (duration <- allDurations)
      buffer += new Note(tone = R, duration = duration)
    buffer.toArray
  }*/

  def allNotes: Array[Note] = {
    var buffer = new ArrayBuffer[Note]()
    for (tone <- allTonesSharp.dropRight(1))
      for (duration <- allDurations)
          for (octave <- allOctaves)
            buffer += new Note(tone, octave, duration)
    buffer.toArray
  }

  def allNotesAndRests: Array[Note] = allNotes //++ allRests

}
