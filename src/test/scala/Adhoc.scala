import rhea_music.ImplicitConversions._

import scala.languageFeature.implicitConversions._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.music_streams.MusicStream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.music_types.Note

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
  def harmony(): Unit = {
    /*val (s1, s2) = ChaosStream.from(ComplexFunction.f3(1.4, 0.3), 100)
    val h = s1.mapTo[Chord](constraintChords(eminor))
              .setDuration(s2.mapTo[String](basicDurations))
    h.writeMidi("harmony")*/
  }

  @Test
  def init() = {
    val n: Note = new Note()
    val s: MusicStream = Stream.just(n).repeat(10)
    s.play()

    Threads.sleep()
  }

//  @Test
  def scale() = {
    /*val scale = new Scale(new Intervals("1 2 3 4 5 6 7"))
    scale.setName("A")
    println(scale.toString)*/
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
