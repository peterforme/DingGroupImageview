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
                dingGroupImageview.setFirstColor(getResources().getColor(R.color.fourth));

                names.add("寿文斌");
                dingGroupImageview2.setNames(names);
                dingGroupImageview2.setFirstColor(getResources().getColor(R.color.fourth));
                dingGroupImageview2.setSecondColor(getResources().getColor(R.color.first));

                names.add("谢明敏");
                dingGroupImageview3.setNames(names);
                dingGroupImageview3.setFirstColor(getResources().getColor(R.color.fourth));
                dingGroupImageview3.setSecondColor(getResources().getColor(R.color.second));
                dingGroupImageview3.setThirdColor(getResources().getColor(R.color.first));

                names.add("吴秋玉");
                dingGroupImageview4.setNames(names);
                dingGroupImageview4.setFirstColor(getResources().getColor(R.color.fourth));
                dingGroupImageview4.setSecondColor(getResources().getColor(R.color.third));
                dingGroupImageview4.setThirdColor(getResources().getColor(R.color.second));
                dingGroupImageview4.setFourthColor(getResources().getColor(R.color.first));
            }
        });




    }
}
