package rhea_music.music_streams

import scala_dsl.ImplicitConversions._
import scala.concurrent.ExecutionContext.Implicits.global

import compose.core.Score
import compose.player.{ScalaColliderPlayer, Tempo}
import org.rhea_core.Stream

import scala.concurrent.Await
import scala.concurrent.duration.Duration.Inf

class ScoreStream(val stream: Stream[Score]) {

  def play() =
    stream.subscribe((score: Score) => {
      ScalaColliderPlayer.withPlayer (4) {
        player: ScalaColliderPlayer => {
          Await.result(player.play(score, Tempo (160)), Inf)
        }
      }
    })
}
object ScoreStream {
}
