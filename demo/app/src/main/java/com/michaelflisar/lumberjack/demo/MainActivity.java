package com.michaelflisar.lumberjack.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            mCount = savedInstanceState.getInt("mCount");

        findViewById(R.id.btLog).setOnClickListener(this);

        // here we can ask for the permission, so we init the overlay logger in here
        // make sure to pass on the result of the permission dialog to the overlay logger!
        L.initOverlayLogger(this);

        // Test 1: a few simple test messages (no groups used)
        L.d("Main activity created");
        L.d("Test message 1: %s", "This is the first simple test log");
        L.e(new Throwable("ERROR"), "Test error: %s", "Test error log");
        // ... all syntaxes supported by timber are supported by lumberjack!

        // Test 2: simple advanced logging messages
        // => we enabled pretty collection printing so following will look good when logged
        // => we enabled to print the first 5 values of collections, so following will print the values of the collection
        L.d("Test array log: %s", new ArrayList<>(Arrays.asList("array value 1", "array value 2")));

        // Test 3: a few logs with usage of groups
        L.d(L.G_TEST1, "Test message in test group");
        L.d(L.G_TEST1, "Test message in test group, value=%d", 999);

        // Test 4: Disable a group, log to this group and see, that nothing is logged and enable group again
        L.disableLogGroup(L.G_TEST1);
        L.e(L.G_TEST1, "This message should NOT appear anywhere because the group is disabled!");
        L.enableLogGroup(L.G_TEST1);

        // Test 5 - custom object formatting
        // we have registered a custom formatter for our TestClass, so we can DIRECTLY pass TestClasses for any string paramter and lumberjack will take care of it!
        L.d("Test custom object log: %s", new TestClass(99));
        L.d("Test custom object array log: %s", new ArrayList<>(Arrays.asList(new TestClass(1), new TestClass(2), new TestClass(10))));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        L.handleOverlayPermissionDialogResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("mCount", mCount);
    }

    @Override
    public void onClick(View view)
    {
        mCount++;
        L.d("Button clicked: %d", mCount);
    }

    public static class TestClass
    {
        public int x;

        public TestClass(int x)
        {
            this.x = x;
        }

        public String getLogData()
        {
            return "TestLogData - x=" + x;
        }
    }
}
