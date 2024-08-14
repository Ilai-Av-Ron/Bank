package src.test;

import org.junit.jupiter.api.Test;
import src.SimpleDate;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleDateTest {

    @Test
    public void testFromStringValid() {
        SimpleDate date = SimpleDate.fromString("2024-08-13");
        assertNotNull(date, "Date should not be null");
        assertEquals(2024, date.getYear());
        assertEquals(8, date.getMonth());
        assertEquals(13, date.getDay());
    }

    @Test
    public void testFromStringInvalid() {
        assertThrows(AssertionError.class, () -> SimpleDate.fromString("2024-13-32"), "Expected an assertion error for invalid date");
        assertThrows(AssertionError.class, () -> SimpleDate.fromString("2024-02-30"), "Expected an assertion error for invalid February date");
    }

    @Test
    public void testBefore() {
        SimpleDate date1 = new SimpleDate(2023, 8, 13);
        SimpleDate date2 = new SimpleDate(2024, 8, 13);
        assertTrue(date1.before(date2), "Date1 should be before Date2");
        assertFalse(date2.before(date1), "Date2 should not be before Date1");
    }

    @Test
    public void testInvalidDate() {
        assertThrows(AssertionError.class, () -> new SimpleDate(2024, 4, 31), "April has only 30 days");
        assertThrows(AssertionError.class, () -> new SimpleDate(2023, 2, 29), "2023 is not a leap year");
    }
}
