import rhea_music.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import scala.collection.JavaConverters._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.chaos.{ChaosStream, ComplexFunction}
import rhea_music.music_streams.{MusicStream, NoteStream}
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.music_types.{Chord, Note, Scale}
import rhea_music.constants.Chords.{allChords, constraintChords}
import rhea_music.constants.ScaleTypes.major
import rhea_music.constants.Tones.Ab
import rhea_music.constants.Durations.basicDurations
import rhea_music.constants.Notes

/**
  * @author Orestis Melkonian
  */
class Tester {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
    Stream.optimizationStrategy = (graph: FlowGraph) => ()
  }

  @Test
  def blocking() = {
    val s = Stream.just(0, 1)

    assert(s.toBlocking.first() == 0)
  }
}
