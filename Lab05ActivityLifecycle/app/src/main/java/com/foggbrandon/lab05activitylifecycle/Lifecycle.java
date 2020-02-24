package com.foggbrandon.lab05activitylifecycle;

import androidx.annotation.NonNull;

class Lifecycle {
    private int onCreateCount;
    private int onStartCount;
    private int onResumeCount;
    private int onPauseCount;
    private int onStopCount;
    private int onRestartCount;
    private int onDestroyCount;

    Lifecycle(int create, int start, int resume, int pause, int stop, int restart, int destroy){
        onCreateCount = create;
        onStartCount = start;
        onResumeCount = resume;
        onPauseCount = pause;
        onStopCount = stop;
        onRestartCount = restart;
        onDestroyCount = destroy;
    }

    int getOnCreateCount() {
        return onCreateCount;
    }

    void setOnCreateCount(int onCreateCount) {
        this.onCreateCount = onCreateCount;
    }

    int getOnStartCount() {
        return onStartCount;
    }

    void setOnStartCount(int onStartCount) {
        this.onStartCount = onStartCount;
    }

    int getOnResumeCount() {
        return onResumeCount;
    }

    void setOnResumeCount(int onResumeCount) {
        this.onResumeCount = onResumeCount;
    }

    int getOnPauseCount() {
        return onPauseCount;
    }

    void setOnPauseCount(int onPauseCount) {
        this.onPauseCount = onPauseCount;
    }

    int getOnStopCount() {
        return onStopCount;
    }

    void setOnStopCount(int onStopCount) {
        this.onStopCount = onStopCount;
    }

    int getOnRestartCount() {
        return onRestartCount;
    }

    void setOnRestartCount(int onRestartCount) {
        this.onRestartCount = onRestartCount;
    }

    int getOnDestroyCount() {
        return onDestroyCount;
    }

    void setOnDestroyCount(int onDestroyCount) {
        this.onDestroyCount = onDestroyCount;
    }
    
    @NonNull
    public String toString() {
        return "Create: " + onCreateCount+ "\nStart: " + onStartCount + "\nResume: " + onRestartCount + "\nPause: " + onPauseCount + "\nStop: " + onStopCount + "\nRestart: " + onRestartCount + "\nDestroy: " + onDestroyCount;
    }
}
