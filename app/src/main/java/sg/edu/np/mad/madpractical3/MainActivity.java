package sg.edu.np.mad.madpractical3;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        User user = new User("MAD", "MAD Developer",1,false);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button button = findViewById(R.id.button);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        TextView tvPin = findViewById(R.id.tvPin);
        int randomPin = new Random().nextInt(999999);
        tvPin.setText(String.format("%06d",randomPin));
        button.setText("Follow");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = button.getText().toString();

                if (buttonText.equals("Follow")) {
                    // Change button text to "Unfollow"
                    button.setText("Unfollow");
                    // Show AlertDialog with "Followed" message
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Follow");
                    builder.setMessage("You have followed");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                } else {
                    // Change button text to "Follow"
                    button.setText("Follow");
                    // Show AlertDialog with "Unfollowed" message
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Unfollow");
                    builder.setMessage("You have unfollowed");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }
            }
        });



        Button messageButton = findViewById(R.id.button1);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MessageGroup activity
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });




    }
}