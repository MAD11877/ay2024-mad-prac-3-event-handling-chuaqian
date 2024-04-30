    package sg.edu.np.mad.madpractical3;

    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.TextView;
    import java.util.Random;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main2);
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
        }
    }