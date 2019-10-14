import rhea_music.util.ImplicitConversions._

import scala.languageFeature.implicitConversions._
import scala_wrapper.ImplicitConversions._
import scala.collection.JavaConverters._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.chaos.{ChaosStream, ChaoticFunction, ChaoticSystem, ComplexFunction}
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
import rhea_music.constants.NoteMods._
import rhea_music.constants.ScaleTypes._
import rhea_music.constants.Octaves._
import test_data.utilities.Colors.{RED, print => cprint, println => cprintln}

/**
  * @author Orestis Melkonian
  */
class Tester {

  implicit class CertifiableIter[T](array: Array[T]) {
    def ?(predicate: T => Boolean) =
      for (t <- array) t ? predicate

    def ??(that: Array[T]) =
      array.zip(that).foreach((p: (T, T)) => p._1 ?? p._2)
  }
  implicit class Certifiable[T](a: T) {
    def ???(predicate: (T, T) => Boolean) = (b: T) =>
      try {
        assert(predicate(a, b))
      } catch {
        case e: AssertionError => cprint(RED, a) ; println(" != " + b) ; throw e
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

  /**
    * ======================
    * Core
    * ======================
    */
  @Test
  def blocking() =
    Stream.just(0, 1).toBlocking.first() ?? 0

  /**
    * ======================
    * Music data types
    * ======================
    */
  @Test
  def melody() =
    Stream.just(C5, D5, E5, F5, G5, A5, B5) =:= "C5 D5 E5 F5 G5 A5 B5"

  @Test
  def offset() = {
    getDelta(b) ?? -1
    getDelta(bb) ?? -2
    getDelta(s) ?? 1
    getDelta(ss) ?? 2
    stringsToIntervals("2 b3 4 5 b6").map((i: Interval) => i.getOffset) ?? Array(2, 3, 5, 7, 8)
  }

  @Test
  def chord() =
    new Chord(C4, M9).getTones ?? Array(C, E, G, B, D)

  @Test
  def harmony() =
    Stream.just(new Chord(C4, m9), new Chord(new Note(B, 3), M9)) =:= "C4min9 B3maj9"

  @Test
  def scale() = {
    Stream.just(new Scale(C, major)) =:= "C D E F G A B"
    Stream.just(new Scale(A, minor)) =:= "A B C D E F G"
  }

//  @Test // TODO
  def enharmonics() = {
    Stream.just(new Scale(Cs, major)) =:= "C# D# E# F# G# A# B#"
    Stream.just(new Scale(As, minor)) =:= "A# B# C# D E F G"
  }

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

  /**
    * ======================
    * Chaos
    * ======================
    */
  @Test
  def unzip() = {
    val Array(s1, s2, s3) = ChaosStream.unzip[Int](Stream.just(Array(0, 1, 2), Array(10, 11, 12)), 3)
    Stream.concat(s1, s2, s3).toBlocking.toList.asScala.toList ?? List(0, 10, 1, 11, 2, 12)
  }

  @Test
  def chaotic_function() =
    ChaosStream.from(ChaoticFunction.f1(1.4), 3).head
      .toBlocking.toList.asScala.toList ?? List(0.0, 1.0, -0.4)

  @Test
  def chaos_range() =
    ChaoticFunction.f1(1.4).range(3).head ?? (-0.4, 1.0)

  @Test
  def chaos_notes() =
    ChaosStream.from(ChaoticFunction.f1(1.4), 5).head
      .mapTo[Note](constraintNotes(new Scale(C, major), high)) =:= "D5 B5 C4 A4 E5"

  @Test
  def complex_function() = {
    val Array(s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), 3)
    Stream.concat(s1, s2).toBlocking.toList.asScala.toList ??
      List(0.0, 1.0, -0.4, 0.0, 0.0, 0.3)
  }

  @Test
  def complex_range() =
    ComplexFunction.f3(1.4, 0.3).range(3) ?? Array((-0.4, 1.0), (0.0, 0.3))

  @Test
  def complex_notes() = {
    val Array(s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), 3)
    Stream.concat(
      s1.mapTo[Note](constraintNotes(new Scale(C, major), high)),
      s2.mapTo[Note](constraintNotes(new Scale(C, major), high))) =:= "D5 B5 C4 C4 C4 B5"
  }

  @Test
  def chaos_system_function() = {
    ChaosStream.from(ChaoticSystem.F1, 3).head
      .toBlocking.toList.asScala.toList ?? List(0.0, 1.0, -0.4)

    val Array(s1, s2) = ChaosStream.from(ChaoticSystem.F3, 3)
    Stream.concat(s1, s2).toBlocking.toList.asScala.toList ??
      List(0.0, 1.0, -0.4, 0.0, 0.0, 0.3)
  }

  @Test
  def chaos_system_range() = {
    ChaoticSystem.F1.range(3).head ?? (-0.4, 1.0)
    ChaoticSystem.F3.range(3) ?? Array((-0.4, 1.0), (0.0, 0.3))
  }

  @Test
  def chaos_system_notes() = {
    ChaosStream.from(ChaoticSystem.F1, 5).head
      .mapTo[Note](constraintNotes(new Scale(C, major), high)) =:= "D5 B5 C4 A4 E5"

    val Array(s1, s2) = ChaosStream.from(ChaoticSystem.F3, 3)
    Stream.concat(
      s1.mapTo[Note](constraintNotes(new Scale(C, major), high)),
      s2.mapTo[Note](constraintNotes(new Scale(C, major), high))) =:= "D5 B5 C4 C4 C4 B5"
  }

  /**
    * ======================
    * Constraints
    * ======================
    */
  @Test
  def constraint_notes() = {
    constraintNotes(Array(C, B, Ds)) ??
      Array(C, B, Ds).flatMap((t: Tone) => allOctaves.map(new Note(t, _)))

    constraintNotes(new Chord(C4, M).getTones) ??
      Array(C, E, G).flatMap((t: Tone) => allOctaves.map(new Note(t, _)))

    constraintNotes(new Scale(C, major).getTones) ??
      Array(C, D, E, F, G, A, B).flatMap((t: Tone) => allOctaves.map(new Note(t, _)))
  }

  // @Test
  // def constraint_chords() = {
  //     val scaleTones = new Scale(A, minor).getTones
  //     for (chordTone <- c.getTones)
  //       if (!(scaleTones contains chordTone))
  //         false
  //     true
  //   })
}
