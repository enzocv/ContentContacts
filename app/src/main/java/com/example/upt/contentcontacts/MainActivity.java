package com.example.upt.contentcontacts;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText mEmail = (EditText)findViewById(R.id.edt_mail );
        final EditText mPhone = (EditText)findViewById(R.id.edt_phone);
        Button   btn_add = (Button) findViewById(R.id.btn_add  );

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);

                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                intent.putExtra(ContactsContract.Intents.Insert.EMAIL,mEmail.getText()).
                        putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK).
                        putExtra(ContactsContract.Intents.Insert.PHONE,mPhone.getText()).
                        putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK).
                        putExtra("finishActivityOnSaveCompleted",true);

                startActivity(intent);
            }
        });

    }
}
