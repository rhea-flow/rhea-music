package rhea_music.util.constants

import org.jfugue.theory.Note
import org.jfugue.theory.Note._

/**
  * @author Orestis Melkonian
  */
object Notes {

  def noteStrings: Array[String] = NOTE_NAMES_COMMON

  def allNotes: Array[Note] = noteStrings.map(s => new Note(s))

//  def pitches: Array[Note] = TODO
}
