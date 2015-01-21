package com.aol.advertising.dmp.disruptor.ringbuffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.Mockito.mock;

import org.apache.avro.specific.SpecificRecord;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AvroEventTest {

  private AvroEvent avroEventUnderTest;

  @Mock
  private SpecificRecord recordMock;

  @Before
  public void setUp() {
    avroEventUnderTest = new AvroEvent();
    avroEventUnderTest.setAvroRecord(recordMock);
  }

  @Test
  public void whenTheContainedAvroRecordIsRetrieved_thenTheRecordAssociatedToThisBufferSlotIsReturned() {
    assertThat(avroEventUnderTest.getAvroRecord(), sameInstance(recordMock));
  }

  @Test
  public void whenTheContainedAvroRecordIsSet_thenTheRecordAssociatedToThisBufferSlotIsUpdated() {
    final SpecificRecord newRecordMock = mock(SpecificRecord.class);
    avroEventUnderTest.setAvroRecord(newRecordMock);
    assertThat(avroEventUnderTest.getAvroRecord(), sameInstance(newRecordMock));
  }

}
