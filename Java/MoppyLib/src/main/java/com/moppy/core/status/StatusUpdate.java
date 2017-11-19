package com.moppy.core.status;

import com.moppy.core.device.DeviceDescriptor;
import java.util.Optional;
import javax.sound.midi.Sequence;

/**
 * A status update sent from a sequencer or network.
 */
public class StatusUpdate {
    
    private final StatusType type;
    private final Optional<Object> data;
    
    private StatusUpdate(StatusType type, Optional<Object> data) {
        this.type = type;
        this.data = data;
    }
    
    public StatusType getType() {
        return type;
    }
    
    public Optional<Object> getData() {
        return data;
    }
    
    // Sequencer statuses
    
    public static StatusUpdate SEQUENCE_START = new StatusUpdate(StatusType.SEQUENCE_START, Optional.empty());
    public static StatusUpdate SEQUENCE_PAUSE = new StatusUpdate(StatusType.SEQUENCE_PAUSE, Optional.empty());
    public static StatusUpdate SEQUENCE_END = new StatusUpdate(StatusType.SEQUENCE_END, Optional.empty());
    
    public static StatusUpdate tempoChange(float tempo) {
        return new StatusUpdate(StatusType.SEQUENCE_TEMPO_CHANGE, Optional.of(tempo));
    }
    public static StatusUpdate sequenceLoaded(Sequence sequence) {
        return new StatusUpdate(StatusType.SEQUENCE_TEMPO_CHANGE, Optional.of(sequence));
    }
    
    // Network statuses
    
    public static StatusUpdate pongReceived(DeviceDescriptor deviceDescriptor) {
        return new StatusUpdate(StatusType.NET_PONG_RECEIVED, Optional.of(deviceDescriptor));
    }
}