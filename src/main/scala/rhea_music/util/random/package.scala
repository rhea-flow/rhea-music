package rhea_music.util

import org.jfugue.theory.Note
import org.jfugue.theory.Intervals
import org.jfugue.theory.Chord

import rhea_music.util.constants.Notes.allNotes
import rhea_music.util.constants.Intervals.allIntervals
import rhea_music.util.constants.Chords.allChords

import scala.util.Random

/**
  * @author Orestis Melkonian
  */
package object random {
  val rand = new Random(System.currentTimeMillis())

  def randFromArray[T](array: Array[T]) : T =
    array(rand.nextInt(array.length))

  def randNote: () => Note = () =>
    randFromArray(allNotes)

  def randInterval: () => Intervals = () =>
    randFromArray(allIntervals)

  def randChord: () => Chord = () =>
    randFromArray(allChords)
}
