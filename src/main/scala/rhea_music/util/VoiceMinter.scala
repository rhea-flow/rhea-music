package rhea_music.util

import java.util.concurrent.atomic.AtomicInteger

import rhea_music.music_types.Voice

/**
  * @author Orestis Melkonian
  */
object VoiceMinter {

  val counter = new AtomicInteger(0)

  def nextVoice: Voice =
    new Voice(counter.getAndIncrement())


}
