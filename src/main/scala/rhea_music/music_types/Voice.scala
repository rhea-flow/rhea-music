package rhea_music.music_types

import rhea_music.music_types.Voice.VoiceType

/**
  * @author Orestis Melkonian
  */

class Voice(override val music: MusicString,
            override val t: VoiceType
            ) extends Wrapper[VoiceType](music, t) {

  override def wrap = t => "V" + t
}

object Voice {
  // Type alias
  type VoiceType = Int
}
