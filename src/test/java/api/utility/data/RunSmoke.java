package api.utility.data;

import com.intuit.karate.junit5.Karate;

public class RunSmoke {

    @Karate.Test
    public Karate runTest() {
        return Karate.run("classpath:features").tags("@Smoke");
    }
}
