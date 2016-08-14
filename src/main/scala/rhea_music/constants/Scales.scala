package rhea_music.constants

import org.jfugue.theory.{Chord, Note, Scale, Intervals => Inter}
import rhea_music.constants.Intervals.allIntervals
import rhea_music.constants.Notes.allNotes

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Scales {

  def allScales: Array[Scale] = {
    var array: ArrayBuffer[Scale] = ArrayBuffer()
    // All 12 keys
//    for (note: Note <- allNotes)
//      // All scale types
//      for (scaleType <- allScaleTypes) {
//        scaleType._1
////        array += new Scale(note, interval)
//      }
    array.toArray
  }


  val allScaleTypes: Map[String, String] = Map(
    "ionian" -> "1 2 3 4 5 6 7",
    "aeolian" -> "1 2 b3 4 5 b6 b7"
  )
}
