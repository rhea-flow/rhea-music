package rhea_music.music_streams

import org.jfugue.player.Player
import org.jfugue.realtime.RealtimePlayer
import org.jfugue.theory.Note
import rhea_music.ImplicitConversions._
import org.rhea_core.Stream
import rhea_music.util.random._

import scala.util.Random

/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {

  def play(): Unit =
    stream.subscribe((n: Note) => {
      NoteStream.RTplayer.play(n.getPattern)
    })

}

object NoteStream {
  val player: Player = new Player
  val RTplayer: RealtimePlayer = new RealtimePlayer

  /**
    * Note generation
    */
  def randNotes: NoteStream =
    Stream.just(randNote).loop(entry => entry.map(n => randNote))
}
