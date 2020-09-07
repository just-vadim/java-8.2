package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    Radio radio = new Radio(
            19
    );

    @Test
    public void shouldSetCurrentStation() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetBelowMinStation() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetOverMaxStation() {
        radio.setCurrentStation(20);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchNextStation() {
        radio.setCurrentStation(7);
        radio.nextStation();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchPreviousStation() {
        radio.setCurrentStation(4);
        radio.previousStation();
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchLastStationToFirst() {
        radio.setCurrentStation(radio.getMaxStation());
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFirstStationToLast() {
        radio.previousStation();
        assertEquals(radio.getMaxStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSetCurrentVolume() {
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetBelowMinVolume() {
        radio.setCurrentVolume(-20);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetOverMaxVolume() {
        radio.setCurrentVolume(110);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setCurrentVolume(60);
        radio.increaseVolume();
        assertEquals(61, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setCurrentVolume(100);
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseBelowMinVolume() {
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseOverMaxVolume() {
        radio.setCurrentVolume(radio.getMaxVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }
}