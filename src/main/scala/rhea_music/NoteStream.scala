package rhea_music

import jm.constants.Durations

import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.constants.Durations._
import jm.constants.Pitches._
import jm.music.data.{Note, Part, Phrase, Rest}
import org.rhea_core.Stream

import scala.util.Random

/**
  * @author Orestis Melkonian
  */
class NoteStream(stream: Stream[Note]) {

  val rand: Random = new Random(System.currentTimeMillis())
  val durations: List[Double] = List(
    WHOLE_NOTE,
    HALF_NOTE,
    HALF_NOTE_TRIPLET,
    QUARTER_NOTE,
    QUARTER_NOTE_TRIPLET,
    EIGHTH_NOTE,
    EIGHTH_NOTE_TRIPLET,
    SIXTEENTH_NOTE,
    SIXTEENTH_NOTE_TRIPLET
  )

  private def getRandomDuration: Double =
    rand.shuffle(durations).head

  /**
    * Accumulate notes in one single part.
    * @return the motif as a instrument part
    */
  def toPart: Stream[Part] =
    stream.toPhrase.map[Part]((p: Phrase) => new Part(p))

  /**
    * Accumulate notes in one single part.
    * @param instr the instrument to use
    * @return the motif as a instrument part
    */
  def toPart(instr: Int): Stream[Part] =
    stream.toPhrase.map[Part]((p: Phrase) => new Part("intst" + instr, instr, p))

  /**
    * @return the motif as a phrase
    */
  def toPhrase: Stream[Phrase] =
    stream.collect[Phrase](() => new Phrase(), (p: Phrase, n: Note) => p.addNote(n))

  /**
    * Transpose motif.
    *
    * @param steps the steps to transpose
    * @return the transposed stream of notes
    */
  def transpose(steps: Int): Stream[Note] =
    stream.doOnNext((n: Note) => n.setPitch(n.getPitch + steps))

  def randomRhythm(percentage: Double = 0.8): Stream[Note] =
    stream.map[Note]((n: Note) => {
      val duration: Double = getRandomDuration
      n.setDuration(duration)
      if (rand.nextDouble() > percentage)
        new Rest()
      else
        n
    })


}
