package android.javapapers.com.androidgeocodelocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class GetPhone extends AppCompatActivity {

    EditText motherphone, fatherphone, sisterphone, brotherphone,wifephone,husbandphone,othersphone;
    String mp, bp, fp, sp,wp,hp,op;
    Button save;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_phone);

        motherphone = (EditText) findViewById(R.id.mothernumber);
        sisterphone = (EditText) findViewById(R.id.sisternumber);
        fatherphone = (EditText) findViewById(R.id.fathernumber);
        brotherphone = (EditText) findViewById(R.id.brothernumber);
        wifephone = (EditText) findViewById(R.id.wifenumber);
        husbandphone = (EditText) findViewById(R.id.husbandnumber);
        othersphone = (EditText) findViewById(R.id.othersnumber);

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mp = motherphone.getText().toString();
                bp = brotherphone.getText().toString();
                fp = fatherphone.getText().toString();
                bp = brotherphone.getText().toString();
                wp = brotherphone.getText().toString();
                hp = brotherphone.getText().toString();
                op = brotherphone.getText().toString();

                Log.d("Insert: ", "Inserting ..");
               // db.addContact(new Contact("Father", fp));
                //db.addContact(new Contact("Mother", mp));
                //db.addContact(new Contact("Sister", sp));
                //db.addContact(new Contact("Brother", bp));

                //db.deleteContact(new Contact(4,"Father",fp));




                Log.d("Reading: ", "Reading all contacts..");
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }
            }
            });

    }
}
