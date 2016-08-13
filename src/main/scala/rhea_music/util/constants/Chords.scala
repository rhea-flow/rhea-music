package rhea_music.util.constants

import org.jfugue.theory.{Chord, Note, Intervals => Inter}
import rhea_music.util.constants.Notes.allNotes
import rhea_music.util.constants.Intervals.allIntervals

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Chords {

  def allChords: Array[Chord] = {
    var array: ArrayBuffer[Chord] = ArrayBuffer()
    // All 12 keys
    for (note: Note <- allNotes)
      // All chord types
      for (interval: Inter <- allIntervals)
        array += new Chord(note, interval)
    array.toArray
  }

  def constraintChords(notes: Array[Note]): Array[Chord] = {
    val chords = allChords filter ((c: Chord) => {
      for (n: Note <- c.getNotes)
        if (!(notes contains n))
          false
      true
    })
    chords
  }
}
