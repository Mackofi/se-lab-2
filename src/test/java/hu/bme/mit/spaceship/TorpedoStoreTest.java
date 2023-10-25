package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

  @Test
  void fire_tests(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);

    // now its empty and cannot fire again
    boolean result_empty = true;
    try {
      result_empty = store.fire(1);
    } catch (IllegalArgumentException e) {
      result_empty = false;
    }
    assertEquals(false, result_empty);

    // try and enter illegal values
    boolean result_negative = true;
    try {
      result_negative = store.fire(-1);
    } catch (IllegalArgumentException e) { 
      result_negative = false;
    }
    assertEquals(false, result_negative);

    boolean result_too_many = true;
    try {
      result_too_many = store.fire(100);
    } catch (IllegalArgumentException e) {
      result_too_many = false;
    }
    assertEquals(false, result_too_many);
  }

  @Test
  void torpedoCountGetter() {
    TorpedoStore store = new TorpedoStore(5);
    int result = store.getTorpedoCount();
    assertEquals(5, result);
  }

  @Test
  void isEmpty_Success() {
    TorpedoStore store = new TorpedoStore(0);
    boolean result = store.isEmpty();
    assertEquals(true, result);
    TorpedoStore store2 = new TorpedoStore(10);
    boolean result2 = store2.isEmpty();
    assertEquals(false, result2);
  }

  @Test
  void misfire() {
    TorpedoStore store = new TorpedoStore(1, 1);
    boolean result = store.fire(1);
    assertEquals(false, result);
  }
}
