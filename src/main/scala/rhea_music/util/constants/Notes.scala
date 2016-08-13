package rhea_music.util.constants

import org.jfugue.theory.Note.NOTE_NAMES_COMMON
import rhea_music.music_types.Note

/**
  * @author Orestis Melkonian
  */
object Notes {

  def noteStrings: Array[String] = NOTE_NAMES_COMMON

  def allNotes: Array[Note] = noteStrings.map(s => new Note(s))

  def eminor: Array[Note] = Array("E", "F#", "G", "A", "B", "C", "D").map(s => new Note(s))

//  def pitches: Array[Note] = TODO
}
