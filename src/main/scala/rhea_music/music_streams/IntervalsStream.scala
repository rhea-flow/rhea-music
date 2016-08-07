package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import org.jfugue.theory.Intervals
import org.rhea_core.Stream

import rhea_music.util.random.randInterval

/**
  * @author Orestis Melkonian
  */
class IntervalsStream(val stream: Stream[Intervals]) {

}

object IntervalsStream {
  def randIntervals: IntervalsStream =
    PatternStream.repeatFunc(randInterval)

}


