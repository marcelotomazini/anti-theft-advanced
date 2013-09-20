package com.marcelotomazini.android.antitheftadvanced;

import static com.github.rtyley.android.screenshot.celebrity.Screenshots.poseForScreenshot;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

public class AntiTheftAdvancedActivityTest extends ActivityInstrumentationTestCase2<AntiTheftAdvancedActivity> {

    public AntiTheftAdvancedActivityTest() {
        super(AntiTheftAdvancedActivity.class);
    }

    @LargeTest
    public void testAppearance() throws Exception {
//        startActivitySync(AntiTheftAdvancedActivity.class);
        Instrumentation instrumentation = getInstrumentation();

//        sleep(500); // robotium provides neater ways of waiting for the activity to initialise

        poseForScreenshot();
//        instrumentation.sendStringSync("s");
//        poseForScreenshot();
//        instrumentation.sendStringSync("o");
//        poseForScreenshot();
//        instrumentation.sendStringSync("s");
//        poseForScreenshotNamed("ConfigureMorseActivity-SOS");
    }

//    private <T extends Activity> T startActivitySync(Class<T> clazz) {
//        Intent intent = new Intent(getInstrumentation().getTargetContext(), clazz);
//        intent.setFlags(intent.getFlags() | FLAG_ACTIVITY_NEW_TASK);
//        return (T) getInstrumentation().startActivitySync(intent);
//    }

}