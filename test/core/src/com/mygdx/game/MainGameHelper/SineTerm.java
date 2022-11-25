package com.mygdx.game.MainGameHelper;

final public class SineTerm {
    private final float amplitude;
    private final float waveLength;
    private final float phaseDifference;

    public float getAmplitude() {
        return amplitude;
    }

    public float getWaveLength() {
        return waveLength;
    }

    public float getPhaseDifference() {
        return phaseDifference;
    }

    public SineTerm(float amplitude, float waveLength, float phaseDifference) {
        this.amplitude = amplitude;
        this.waveLength = waveLength;
        this.phaseDifference = phaseDifference;
    }

    public float evaluate(float x) {
        return amplitude * (float) Math.sin(2 * Math.PI * x / waveLength + phaseDifference);
    }
}
