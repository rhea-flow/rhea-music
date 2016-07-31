package rhea_music

import jm.audio.Instrument
import jm.constants.Durations._
import jm.constants.Pitches._
import jm.music.data._
import jm.util.Play
import org.rhea_core.Stream

import scala_dsl.ImplicitConversions._

/**
 * @author Orestis Melkonian
 */
package object MusicStreams {

  class NoteStream(stream: Stream[Note]) {

    /**
      * @param instr the instrument to use
      * @return the motif as a instrument part
      */
    def toPart(instr: Int): Stream[Part] =
      stream.toPhrase.map((p: Phrase) => new Part("intst" + instr, instr, p))

    /**
      * @return the motif as a phrase
      */
    def toPhrase: Stream[Phrase] =
      stream.collect(() => new Phrase(), (phrase: Phrase, note:Note) => phrase.addNote(note))

    /**
      * Transpose motif.
      *
      * @param steps the steps to transpose
      * @return the transposed stream of notes
      */
    def transpose(steps: Int): Stream[Note] =
      stream.doOnNext((n: Note) => n.setPitch(n.getPitch + steps))


  }

  object NoteStream {

    /**
      * Generate a new chaotic motif.
      * @param func the chaotic recursive function to use
      * @param init the initial seed
      * @param N the number of notes the motif will consist of
      * @param rangeMix the lower bound of the chaotic system
      * @param rangeMax the upper bound of the chaotic system
      * @return the chaotic melody as a stream of notes
      */
    def generateChaoticMelody(func: Double => Double,
                              init: Double,
                              N: Int,
                              rangeMix: Double = -1,
                              rangeMax: Double = 1): Stream[Note] =
      Stream.just(init).loop((init: Stream[Double]) => init.map(func))
        .map[Note]((i: Double) => {
          val pitch = mapRange(rangeMix, rangeMax, E2, E6, i).toInt
          new Note(pitch, SN)
        })
        .take(N)

    private def mapRange(a1:Double, a2:Double, b1:Double, b2:Double, x:Double): Double =
      b1 + (x - a1) * (b2 - b1) / (a2 - a1)

    private def bound(value: Int, min: Int, max:Int): Int =
      if (value > max)
        max
      else if (value < min)
        min
      else
        value
  }

  implicit def notifyStream(st: Stream[Note]): NoteStream = new NoteStream(st)

  implicit def partifyStream(st: Stream[Part]): PartStream = new PartStream(st)

  class PartStream(stream: Stream[Part]) {

    /**
      * Play part.
      */
    def play(): Unit =
      stream.subscribe((p: Part) => Play.midi(p))

    /**
      * Play the motif on the audio output.
      * @param inst the instrument to use
      */
    def audio(inst: Instrument): Unit =
      stream.subscribe((p: Part) => Play.audio(p, Array(inst)))

  }

  class PhraseStream(stream: Stream[Phrase]) {

    /**
      * Play part.
      */
    def play(): Unit =
      stream.subscribe((p: Phrase) => Play.midi(p))

    /**
      * Play the motif on the audio output.
      * @param inst the instrument to use
      */
    def audio(inst: Instrument): Unit =
      stream.subscribe((p: Phrase) => Play.audio(p, Array(inst)))

  }

  implicit def phrasifyStream(st: Stream[Phrase]): PhraseStream = new PhraseStream(st)

  class ScoreStream(stream: Stream[Score]) {

    /**
      * Play part.
      */
    def play(): Unit =
      stream.subscribe((p: Score) => Play.midi(p))

    /**
      * Play the motif on the audio output.
      * @param inst the instrument to use
      */
    def audio(inst: Instrument): Unit =
      stream.subscribe((s: Score) => Play.audio(s, Array(inst)))

  }

  implicit def scorifyStream(st: Stream[Score]): ScoreStream = new ScoreStream(st)
}
