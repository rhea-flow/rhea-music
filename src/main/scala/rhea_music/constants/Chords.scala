package rhea_music.constants

import rhea_music.constants.Notes.allNotes
import rhea_music.constants.ChordTypes.{allChordTypes, getNumberOfInversions}
import rhea_music.music_types.{Chord, Note, Scale}

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Chords {

  // TODO Constants

  def allChords: Array[Chord] = {
    var buffer = new ArrayBuffer[Chord]()
    for (note <- allNotes)
      for (chordType <- allChordTypes)
        for (inversion <- 0 until getNumberOfInversions(chordType))
          buffer += new Chord(note.clean, chordType, inversion)
    buffer.toArray
  }

  def constraintChords(scale: Scale): Array[Chord] = {
    val chords = allChords filter ((c: Chord) => {
      for (n: Note <- c.getNotes)
        if (!(scale.getNotes contains n))
          false
      true
    })
    chords
  }
}
