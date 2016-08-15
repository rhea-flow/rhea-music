import rhea_music.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.music_streams.MusicStream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.music_types.{Chord, Note, Scale}
import rhea_music.constants.Chords.allChords

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

//  @Test
  def init() = {
    // TODO add collection implicits
    /*Stream.from(allChords.toIterable).subscribe((c: Chord) => {
      println(c)
      MusicStream.player.play(c.rep)
    })*/

    val s: MusicStream =
//      Note.randNotes
      Chord.randChords.take(100)

    s.play()

    Threads.sleep()
  }

  @Test
  def scale() = {
    import rhea_music.constants.Tones._
    import rhea_music.constants.ScaleTypes._

    val scale = new Scale(Ab, none)
    val notes = scale.getNotes
    val s = Stream.just(notes(0), notes(1), notes(2), notes(3), notes(4), notes(5), notes(6))
    s.play()

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
