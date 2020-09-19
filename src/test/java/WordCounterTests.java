import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class WordCounterTests {

    WordCounter sut = new WordCounter();

    @Test
    public void it_should_return_IllegalArgumentException_when_given_input_is_null() {
        //Arrange
        //Act
        Throwable throwable = catchThrowable(() -> sut.getCounter(null));

        //Assert
        assertThat(throwable).isInstanceOf(NullPointerException.class).hasMessage("Input cannot be null");
    }

    @Test
    public void it_should_return_4_unique_words_when_input_contains_4_unique_words() {
        //Arrange
        //Act
        String result = sut.getCounter("This is a test.");
        //Assert
        assertThat(result).isEqualTo("Has 4 unique words.");
    }

    @Test
    public void it_should_return_6_unique_words_when_input_contains_8_words_however_6_words_are_identical() {
        //Arrange
        //Act
        String result = sut.getCounter("This is a test and a good test.");
        //Assert
        assertThat(result).isEqualTo("Has 6 unique words.");
    }

    @Test
    public void it_should_return_2_unique_words_when_input_contains_words_with_apostrophes() {
        //Arrange
        //Act
        String result = sut.getCounter("Rock'n Roller.");
        //Assert
        assertThat(result).isEqualTo("Has 2 unique words.");
    }

    @Test
    public void it_should_return_3_unique_words_when_there_are_4_words_in_input_and_2_of_them_identical_except_capitalization() {
        //Arrange
        //Act
        String result = sut.getCounter("Hey hey, What's up.");
        //Assert
        assertThat(result).isEqualTo("Has 3 unique words.");
    }
    @Test
    public void it_should_return_11_unique_words_when_given_input_contains_11_unique_words(){
        //Arrange
        //Act
        String result = sut.getCounter("Hey, hey mama said the way you move Gonna make you sweat, gonna make you groove");
        //Assert
        assertThat(result).isEqualTo("Has 11 unique words.");
    }
    @Test
    public void it_should_return_0_unique_word_when_given_input_is_empty_string(){
        //Arrange
        //Act
        String result = sut.getCounter("");
        //Assert
        assertThat(result).isEqualTo("Has 0 unique words.");
    }
    @Test
    public void it_should_return_1_unique_word_when_given_input_contains_1_identical_word_and_commas_and_dots(){
        //Arrange
        //Act
        String result = sut.getCounter("Can....,,,.Can");
        //Assert
        assertThat(result).isEqualTo("Has 1 unique words.");
    }
    @Test
    public void it_should_return_1_unique_word_when_given_input_contains_2_words_with_apostrophe_and_different_capitalization(){
        //Arrange
        //Act
        String result = sut.getCounter("Led'Zeppelin led'zepPelin");
        //Assert
        assertThat(result).isEqualTo("Has 1 unique words.");
    }

}
