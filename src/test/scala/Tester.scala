import rhea_music.ImplicitConversions._

import scala.languageFeature.implicitConversions._
import scala_wrapper.ImplicitConversions._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rx_eval.RxjavaEvaluationStrategy
import rhea_music.music_types._
import rhea_music.constants.Tones._
import rhea_music.constants.Notes._
import rhea_music.constants.Durations._
import rhea_music.constants.ChordTypes._
import rhea_music.constants.ScaleTypes._
import rhea_music.constants.KeySignatures._
import rhea_music.constants.Tempos._
import rhea_music.constants.Instruments._
import rhea_music.constants.Chords._
import rhea_music.constants.ScaleTypes._
import rhea_music.constants.Octaves._
import test_data.utilities.Colors.{RED, println => cprintln}

/**
  * @author Orestis Melkonian
  */
class Tester {

  implicit class CertifiableIter[T](array: Array[T]) {
    def ?(predicate: T => Boolean) =
      for (t <- array) t ? predicate

    def ??(that: Array[T]) =
      that.zip(array).foreach((p: Tuple2[T, T]) => p._1 ?? p._2)
  }

  implicit class Certifiable[T](a: T) {
    def ???(predicate: (T, T) => Boolean) = (b: T) =>
      try {
        assert(predicate(a, b))
      } catch {
        case e: AssertionError => cprintln(RED, a + " != " + b) ; throw e
      }

    def ?(predicate: T => Boolean) =
      ???((a: T, b: T) => predicate(a))

    def ?? =
      ???((a: T, b: T) => a == b)
  }
  implicit class TestMusicStream(s: Stream[_ <: MusicString]) {
    def =:=(str: String) = s.extractString ?? str
  }

  @Before
  def set_eval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
    Stream.optimizationStrategy = (graph: FlowGraph) => ()
  }

  @Test
  def blocking() =
    Stream.just(0, 1).toBlocking.first() ?? 0

  @Test
  def melody() =
    Stream.just(C5, D5, E5, F5, G5, A5, B5) =:= "C5 D5 E5 F5 G5 A5 B5"

  @Test
  def chord() =
    new Chord(C4, M9).getTones ?? Array(C, E, G, B, D)

  @Test
  def harmony() =
    Stream.just(new Chord(C4, m9), new Chord(new Note(B, 3), _13)) =:= "C4min9 B3dom13"


  @Test
  def scale() = {
    Stream.just(new Scale(C, major)) =:= "C D E F G A B"
    Stream.just(new Scale(A, minor)) =:= "C D E F G A B"
  }

  @Test // TODO
  def enharmonics() =
    Stream.just(new Scale(As, minor)) =:= "A# B# C# D E F G"

  @Test
  def duration() = {
    val s: Stream[_ <: MusicString] = Stream.just(C5, D5, E5, F5, G5, A5, B5).setDuration(Stream.just(hf, qr, eh, sh, th, sx, ote))
    s =:= "C5h D5q E5i F5s G5t A5x B5o"
  }

  @Test
  def key() =
    (Amajor |> Stream.just(C5, D5, E5, F5, G5, A5, B5).extractString) ?? "KAmaj C5 D5 E5 F5 G5 A5 B5"

  @Test
  def tempo() = 
    (allegretto |> Stream.just(C5, D5, E5, F5, G5, A5, B5).extractString) ?? "T110 C5 D5 E5 F5 G5 A5 B5"

  @Test
  def voice() =
    (new Voice(0) |> Stream.just(C5, D5, E5, F5, G5, A5, B5).extractString) ?? "V0 C5 D5 E5 F5 G5 A5 B5"

  @Test
  def instrument() = 
    (TUBULAR_BELLS |> Stream.just(C5, D5, E5, F5, G5, A5, B5).extractString) ?? "I[14] C5 D5 E5 F5 G5 A5 B5"

  @Test
  def constraint_notes() = {
    constraintNotes(Array(C, B, Ds)) ??
      Array(C, B, Ds).flatMap((t: Tone) => allOctaves.map(new Note(t, _)))

    constraintNotes(new Chord(C4, M).getTones) ??
      Array(C, E, G).flatMap((t: Tone) => allOctaves.map(new Note(t, _)))
  }


  @Test
  def constraint_chords() =
    constraintChords(new Scale(A, minor)) ? ((c: Chord) => {
      val scaleTones = new Scale(A, minor).getTones
      for (chordTone <- c.getTones)
        if (!(scaleTones contains chordTone))
          false
      true
    })
}
