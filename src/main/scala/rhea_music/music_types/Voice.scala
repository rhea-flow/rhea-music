package rhea_music.music_types

import rhea_music.music_types.Voice.VoiceType

/**
  * @author Orestis Melkonian
  */

class Voice(override val t: VoiceType) extends Wrapper[VoiceType](t) {

  override def wrap = t => "V" + t
}

object Voice {
  type VoiceType = Int
}
