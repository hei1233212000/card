package nc.org.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Gallery extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, 0);
    }
    public void clo(View v)
    {
        finish();
    }
    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        EditText firstName = (EditText) findViewById(R.id.aa);
        firstName.setText("Ivan");
        EditText lastName = (EditText) findViewById(R.id.bb);
        lastName.setText("Law");
        EditText email = (EditText) findViewById(R.id.cc);
        email.setText("pro-i@passber.com");
        EditText phone = (EditText) findViewById(R.id.dd);
        phone.setText("63821916");
        EditText address = (EditText) findViewById(R.id.ee);
    }

    public void close(View v)
    {
        Intent i = getIntent();
        setResult(RESULT_OK,i);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
