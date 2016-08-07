package rhea_music.util.constants

import org.jfugue.theory.{Chord, Intervals => Inter}

/**
  * @author Orestis Melkonian
  */
object Intervals {

  def allIntervals: Array[Inter] =
    Chord.chordMap.values().toArray[Inter](Array())
}
