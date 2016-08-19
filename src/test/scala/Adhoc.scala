import rhea_music.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import scala.collection.JavaConverters._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.chaos.{ChaosStream, ComplexFunction}
import rhea_music.music_streams.MusicStream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.music_types.{Chord, MusicString, Note, Scale}
import rhea_music.constants.Chords._
import rhea_music.constants.Notes._
import rhea_music.constants.ScaleTypes._
import rhea_music.constants.Tones._
import rhea_music.constants.Durations.basicDurations

/**
 * @author Orestis Melkonian
 */
class Adhoc {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
    Stream.optimizationStrategy = (graph: FlowGraph) => ()
  }

//  @Test
  def rand() = {
    val s: MusicStream = Chord.randChords.take(10)
    val s2: MusicStream = Note.randNotes.take(10)
    println (s.extractString || s2.extractString)
  }

  @Test
  def melodies(): Unit = {
    val CM = new Scale(C, major)

    val (s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), 100)
    val m1 = s1.mapTo[Note](constraintNotes(CM))
              .setDuration(s2.mapTo[String](basicDurations))

    val (s3, s4) = ChaosStream.from(ComplexFunction.f3(1.41, 0.31), 100)
    val m2 = s3.mapTo[Note](constraintNotes(CM))
               .setDuration(s4.mapTo[String](basicDurations))

    Stream.just(m1.extractString || m2.extractString)
//      .play()
      .writeMidi("melodies")

    Threads.sleep()
  }

//  @Test
  def duet(): Unit = {
    val (s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), 100)
    val EbMinor = new Scale(Eb, minor)
    val h = s1.mapTo[Chord](constraintChords(EbMinor))
              .setDuration(s2.mapTo[String](basicDurations))

    val (s3, s4) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), 100)
    val m = s1.mapTo[Note](constraintNotes(EbMinor))
              .setDuration(s4.mapTo[String](basicDurations))

    (m || h).writeMidi("harmony")

    Threads.sleep()
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
