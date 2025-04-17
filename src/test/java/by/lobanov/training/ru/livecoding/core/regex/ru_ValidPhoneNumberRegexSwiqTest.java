package by.lobanov.training.ru.livecoding.core.regex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ru_ValidPhoneNumberRegexSwiqTest {



    /**
    * Test to validate phone number in the format (123) 456-7890.
    */
@Test
public void testSolutionValidate_ValidFormatWithParentheses() {
    // Arrange
    String phoneNumber = "(123) 456-7890";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertTrue(result, "The phone number should be valid when in the format (123) 456-7890.");
    }


    /**
    * Test to validate phone number in the format 123-456-7890.
    */
@Test
public void testSolutionValidate_ValidFormatWithDashes() {
    // Arrange
    String phoneNumber = "123-456-7890";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertTrue(result, "The phone number should be valid when in the format 123-456-7890.");
    }


    /**
    * Test to validate phone number with invalid format due to missing area code.
    */
@Test
public void testSolutionValidate_InvalidFormat_MissingAreaCode() {
    // Arrange
    String phoneNumber = "456-7890";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertFalse(result, "The phone number should be invalid when missing the area code.");
    }


    /**
    * Test to validate phone number with invalid format due to incorrect parentheses usage.
    */
@Test
public void testSolutionValidate_InvalidFormat_IncorrectParentheses() {
    // Arrange
    String phoneNumber = "(123 456-7890";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertFalse(result, "The phone number should be invalid when parentheses are not closed.");
    }


    /**
    * Test to validate phone number with invalid format due to extra characters.
    */
@Test
public void testSolutionValidate_InvalidFormat_ExtraCharacters() {
    // Arrange
    String phoneNumber = "(123) 456-78901";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertFalse(result, "The phone number should be invalid when there are extra characters.");
    }


    /**
    * Test to validate phone number with invalid format due to incorrect separator.
    */
@Test
public void testSolutionValidate_InvalidFormat_IncorrectSeparator() {
    // Arrange
    String phoneNumber = "123.456.7890";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertFalse(result, "The phone number should be invalid when using incorrect separators.");
    }


    /**
    * Test to validate phone number with invalid format due to missing dash.
    */
@Test
public void testSolutionValidate_InvalidFormat_MissingDash() {
    // Arrange
    String phoneNumber = "123 456 7890";
    
    // Act
    boolean result = ru_ValidPhoneNumberRegex.solutionValidate(phoneNumber);
    
    // Assert
    assertFalse(result, "The phone number should be invalid when dashes are missing.");
    }
}