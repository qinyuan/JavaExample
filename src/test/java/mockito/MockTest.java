package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MockTest {

	@Test
	public void test() {
		String field1 = "field1";
		Mock mock = new Mock();
		assertEquals(field1, mock.getField1());

		field1 = "mock1";
		mock = mock(Mock.class);
		when(mock.getField1()).thenReturn(field1);
		assertEquals(field1, mock.getField1());
	}
}
