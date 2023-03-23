import java.util.Objects;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class SimilarProfileMatcher extends TypeSafeMatcher<ProfileInfo> {
    private final ProfileInfo another;
    @Override
    protected boolean matchesSafely(ProfileInfo item) {
        return Objects.equals(another.getName(), item.getName()) &&
                Objects.equals(another.getDateOfBirth(), item.getDateOfBirth());
    }

    private SimilarProfileMatcher(ProfileInfo profileInfo) {
        this.another = profileInfo;
    }

    @Factory
    public static Matcher<ProfileInfo> isSimilarTo(ProfileInfo profileInfo) {
        return new SimilarProfileMatcher(profileInfo);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Проверяет, тот ли это человек (по дате рождения и имени)");
    }
}
