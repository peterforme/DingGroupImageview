package dlodloclose.com.dinggroupimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DingGroupImageview dingGroupImageview;
    DingGroupImageview dingGroupImageview2;
    DingGroupImageview dingGroupImageview3;
    DingGroupImageview dingGroupImageview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        dingGroupImageview = (DingGroupImageview)findViewById(R.id.dingImg);
        dingGroupImageview2 = (DingGroupImageview)findViewById(R.id.dingImg2);
        dingGroupImageview3 = (DingGroupImageview)findViewById(R.id.dingImg3);
        dingGroupImageview4 = (DingGroupImageview)findViewById(R.id.dingImg4);
        ArrayList<String> names = new ArrayList<>();
        names.add("刘家珍");
        dingGroupImageview.setNames(names);

        names.add("包凯红");
        dingGroupImageview2.setNames(names);

        names.add("欧阳若诗");
        dingGroupImageview3.setNames(names);

        names.add("廖萍");
        dingGroupImageview4.setNames(names);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> names = new ArrayList<>();
                names.add("彭天文");
                dingGroupImageview.setNames(names);

                names.add("寿文斌");
                dingGroupImageview2.setNames(names);

                names.add("谢明敏");
                dingGroupImageview3.setNames(names);

                names.add("吴秋玉");
                dingGroupImageview4.setNames(names);
            }
        });




    }
}
