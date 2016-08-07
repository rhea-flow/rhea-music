package rhea_music.cellular_automata

import rhea_music.ImplicitConversions._
import jm.constants.Durations._
import jm.music.data.{CPhrase, Note}
import jm.music.tools.ca.{CellularAutomata => CA}
import org.rhea_core.Stream
import rhea_music.cellular_automata.CAStream.{dim, livingsCells}
import rhea_music.music_streams.{CPhraseStream, NoteStream}
import rhea_music.utils.mapRange
import rhea_music.utils.constants.PitchRanges._

import scala.collection.mutable


/**
  * @author Orestis Melkonian
  */
class CAStream(val stream: Stream[CA]) {

  def mapToPitch(min: Int, max: Int): NoteStream =
    stream.map((ca: CA) => {
      // Get number of living cells
      val (x: Int, y: Int) = dim(ca)
      val livingCells: Int = livingsCells(ca)

      new Note(mapRange(0, x*y, min, max, livingCells).toInt, QN)
    }): Stream[Note]
  def mapToBass: NoteStream =
    mapToPitch _ tupled bassRange
  def mapToBaritone: NoteStream =
    mapToPitch _ tupled baritoneRange
  def mapToTenor: NoteStream =
    mapToPitch _ tupled tenorRange
  def mapToAlto: NoteStream =
    mapToPitch _ tupled altoRange
  def mapToSoprano: NoteStream =
    mapToPitch _ tupled sopranoRange

  def mapToHarmony(mapper: HarmonyMapper): CPhraseStream =
    stream.map[CPhrase]((ca: CA) => {
      // Count chord occurences
      val count = new mutable.HashMap[CPhrase, Int]

      // Iterate CA
      val grid: Array[Array[Boolean]] = ca.getAllStates
      var sum = 0
      for (i <- grid.indices) {
        val row: Array[Boolean] = grid(i)
        for (j <- row.indices)
          if (row(j)) {
            val chord: CPhrase = mapper.map(i, j)
            if (count.contains(chord))
              count(chord) = count(chord) + 1
            else
              count += (chord -> 1)
          }
      }

      // Yield most populated chord
      val ret = count.maxBy(_._2)._1
      ret
    }: CPhrase): CPhraseStream
}

object CAStream {

  def dim(ca: CA): (Int, Int) = {
    val grid: Array[Array[Boolean]] = ca.getAllStates
    (grid.length, grid(0).length)
  }

  def livingsCells(ca: CA): Int = {
    val grid: Array[Array[Boolean]] = ca.getAllStates
    var sum = 0
    for (i <- grid.indices) {
      val row: Array[Boolean] = grid(i)
      for (j <- row.indices)
        if (row(j))
          sum += 1
    }
    sum
  }
}


