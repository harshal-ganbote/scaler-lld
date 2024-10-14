package com.assignment.question;

import com.assignment.question.decoder.AudioDecoder;
import com.assignment.question.decoder.FLACDecoder;
import com.assignment.question.player.AudioPlayer;
import com.assignment.question.player.FLACPlayer;
import com.assignment.question.processor.AudioProcessor;
import com.assignment.question.processor.FLACAudioProcessor;

public class FLACAudioFactory extends AudioFactory {
  @Override
  public MediaFormat supportsFormat() {
    return MediaFormat.FLAC;
  }

  @Override
  public AudioDecoder createAudioDecoder(byte[] audioData) {
    return new FLACDecoder(audioData);
  }

  @Override
  public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
    return new FLACPlayer(volume, playbackRate);
  }

  @Override
  public AudioProcessor createAudioProcessor(byte[] audioData) {
    return new FLACAudioProcessor(audioData);
  }
}