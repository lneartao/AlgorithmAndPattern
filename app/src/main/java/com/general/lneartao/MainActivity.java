package com.general.lneartao;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        findViewById(R.id.btn_cm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cm:
                startAct();
                break;
            default:
        }
    }

    private void startAct() {
        Intent intent = new Intent();
        intent.putExtra("serializable_key", new SelfSerializableData());

        ComponentName
                componentName = new ComponentName("com.chinamobile.mcloud", "com.chinamobile.mcloud.client.business.plugin.FileSharePluginActivity");
        intent.setComponent(componentName);
        startActivity(intent);
    }
}
