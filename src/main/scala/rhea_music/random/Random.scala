package rhea_music.random

import compose.core.{Duration, Pitch, Score}
import compose.core.Score.Note

import scala.util.{Random => Rand}

/**
  * @author Orestis Melkonian
  */
object Random {
  val rand = new Rand(System.currentTimeMillis())

  def randFromArray[T](array: Array[T]) : T =
    array(rand.nextInt(array.length))

  def randNote: Note = Score.Note(randPitch, randDuration)

  def randPitch: Pitch = {
    val tone = rand.nextInt(12)
    val octave = rand.nextInt(7)
    Pitch.C0//.transpose(tone + octave * 12)
  }

  def randDuration: Duration =
    randFromArray(Array(
      Duration.Whole,
      Duration.Half,
      Duration.Quarter,
      Duration.Eighth,
      Duration.Sixteenth,
      Duration.ThirtySecond,
      Duration.SixtyFourth
    ))
}
