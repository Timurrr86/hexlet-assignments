package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void TestEnlargeArrayImage() {
        String[][] image1 = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] enlargeImage1 = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };

        String[][] actual = App.enlargeArrayImage(image1);
        String[][] expected = enlargeImage1;
        assertThat(actual).isEqualTo(expected);

    }
    @Test
    void TestEnlargeArrayImage2() {
        String[][] image1 = {
                {"*", "+", "*"},
                {"*", " ", "*"},
                {"*", " ", "*"},
                {"*", "+", "*"},
        };

        String[][] enlargeImage1 = {
                {"*", "*", "+", "+", "*", "*"},
                {"*", "*", "+", "+", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", "+", "+", "*", "*"},
                {"*", "*", "+", "+", "*", "*"},
        };

        String[][] actual = App.enlargeArrayImage(image1);
        String[][] expected = enlargeImage1;
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void TestEnlargeArrayImage3() {
        String[][] image1 = {};

        String[][] enlargeImage1 = {};

        String[][] actual = App.enlargeArrayImage(image1);
        String[][] expected = enlargeImage1;
        assertThat(actual).isEqualTo(expected);

    }
}
// END
