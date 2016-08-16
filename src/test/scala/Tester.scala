import rhea_music.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import rhea_music.music_streams.MusicStream
import rx_eval.RxjavaEvaluationStrategy
import rhea_music.music_types.{Chord, MusicString, Note, Scale}
import rhea_music.constants.Tones._
import rhea_music.constants.Notes._
import rhea_music.constants.Durations._
import rhea_music.constants.ChordTypes._
import rhea_music.constants.ScaleTypes._
import rhea_music.constants.KeySignatures._

/**
  * @author Orestis Melkonian
  */
class Tester {

  implicit class TestMusicStream(s: Stream[_ <: MusicString]) {
    def =:=(str: String) = assert(s.extractString == str)
  }

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
    Stream.optimizationStrategy = (graph: FlowGraph) => ()
  }

  @Test
  def blocking() =
    assert(Stream.just(0, 1).toBlocking.first() == 0)

  @Test
  def melody() =
    Stream.just(C5, D5, E5, F5, G5, A5, B5) =:= "C5 D5 E5 F5 G5 A5 B5"

  @Test
  def harmony() =
    Stream.just(new Chord(C4, m9), new Chord(new Note(Bb, 3), _13)) =:= "C4min9 Bb3dom13"


  @Test
  def scale() =
    Stream.just(new Scale(As, minor)) =:= "A# B# C# D E F G"

  @Test
  def duration() = {
    val s: Stream[_ <: MusicString] = Stream.just(C5, D5, E5, F5, G5, A5, B5).setDuration(Stream.just(hf, qr, eh, sh, th, sx, ote))
    s =:= "C5h D5q E5i F5s G5t A5x B5o"
  }

  @Test
  def key() = assert(
    Amajor.wrap(Stream.just(C5, D5, E5, F5, G5, A5, B5).extractString) == "KAmaj C5 D5 E5 F5 G5 A5 B5"
  )


}
