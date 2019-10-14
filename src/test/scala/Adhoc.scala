import rhea_music.util.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.chaos.{ChaosStream, ChaoticFunction, ComplexFunction}
import rhea_music.music_streams.MusicStream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.music_types.{Chord, Interval, Note, Scale}
import rhea_music.constants.Chords._
import rhea_music.constants.Notes._
import rhea_music.constants.ScaleTypes._
import rhea_music.constants.Tones._
import rhea_music.constants.Octaves._
import rhea_music.constants.Durations._
import rhea_music.constants.NoteMods._
import rhea_music.constants.Instruments._
import rhea_music.util.ImplicitConversions._

class Adhoc {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
    Stream.optimizationStrategy = null
  }

  @Test
  def melodies(): Unit = {

    // val sc = new Scale(C, major)
    val sc = new Scale(B, lydian)
    // val sc = new Scale(A, japanese)
    // val sc = new Scale(Ab, harmonicMinor)

    val Array(s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, .3), 200)
    val Array(s3, s4) = ChaosStream.from(ComplexFunction.f3(1.42, .28), 200)
    // Melody
    val melody = s1.mapTo[Note](constraintNotes(sc, mid))
                   .setDuration(s3.mapTo[String](medium))
    // Bass
    val bass = s2.mapTo[Note](constraintNotes(sc, low))
                 .setDuration(s4.mapTo[String](slow))
    // Harmony
    val Array(s5, s6) = ChaosStream.from(ComplexFunction.f3(1.4, .3), 100)
    val h = s5.mapTo[Chord](constraintChords(constraintNotes(sc, mid)))
              .setDuration(s6.mapTo[String](Array(wh, wh_)))

    ((ORCHESTRAL_STRINGS ||> melody) || (ORCHESTRAL_STRINGS ||> bass))
      .writeMidi("duet")
    //   .play()
    // Threads.sleep()
  }

//  @Test
  def jfugue() {
    /*val N = 100
    val (s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), N)
    val (s3, s4) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), N)
    val (s5, s6) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), N)

    val melody =
      s1.mapTo[Note](eminor)
        .setDuration(s2.mapTo[String](medium))
        .setInstrument("Violin")

    val harmony =
      s3.mapTo[Chord](Array(
        new Chord("Emin"),
        new Chord("Amin"),
        new Chord("Bmin")
      ))
        .setDuration(s4.mapTo[String](basicDurations))
        .setInstrument("Church_Organ")*/

    /*val rhythm =
      s5.mapTo[Char](basicRhythms)*/

//    MusicStream.sync(melody, harmony).setTempo(90).writeMidi("trio")

    /*ChaosStream.chaoticHarmony(100)
      .setInstrument("Electric_Jazz_Guitar")
      .play()*/

    Threads.sleep()
  }

}
