package rhea_music.util

import org.jfugue.theory.Note
import org.jfugue.theory.Note._

import scala.util.Random

/**
  * @author Orestis Melkonian
  */
package object random {
  val rand = new Random

  def randFromArray[T](array: Array[T]) : T =
    array(rand.nextInt(array.length))

  def randNote: Note =
    new Note(randFromArray(NOTE_NAMES_COMMON))
}
