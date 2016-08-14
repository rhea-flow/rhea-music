package rhea_music.util

import rhea_music.music_types.{Chord, Note}
import rhea_music.constants.Notes.allNotes
import rhea_music.constants.Chords.allChords

import scala.util.{Random => Rand}

/**
  * @author Orestis Melkonian
  */
object Random {
  val rand = new Rand(System.currentTimeMillis())

  def randFromArray[T](array: Array[T]) : T =
    array(rand.nextInt(array.length))

  def randNote: () => Note = () =>
    randFromArray(allNotes)

  def randChord: () => Chord = () =>
    randFromArray(allChords)
}
