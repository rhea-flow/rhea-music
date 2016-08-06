package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import jm.constants.Durations._
import jm.music.data.{Note, Part, Phrase, Rest}
import org.rhea_core.Stream

import scala.util.Random

/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {

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
    * @return the motif as a phrase
    */
  def toPhrase: PhraseStream =
    stream.collect[Phrase](() => new Phrase(), (p: Phrase, n: Note) => p.addNote(n))

  /**
    * Set rhythm to the motif.
    * @param rhythm stream of rhythm durations
    * @return the motif with rhythm
    */
  def setRhythm(rhythm: Stream[Double]): Stream[Note] =
    Stream.zip[Double, Note, Note](rhythm, stream, (r: Double, n: Note) => {
      n.setRhythmValue(r)
      n
    }: Note)

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
