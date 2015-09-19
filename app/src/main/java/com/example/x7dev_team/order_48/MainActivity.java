package com.example.x7dev_team.order_48;

/*
• List View состоит из 100 строк.
• Строка состоит из следующих элементов: номер строки, кнопка
(Button) и стрелка.
• По клику по строке переходим на следующий экран, посередине
которого отображается номер строки и кнопку из этой же строки.
• По клику на "Settings" попадаем на следующий экран, в котором
указываем номер строки (в первом текстовом поле) и коэффициент заполнения
фона кнопки зеленным цветом от 0 до 1 (во втором текстовом поле). При нажатии
на кнопку «Ок» добавляем в List View строку с номером, который был введен в
первом текстовом поле, и кнопку, окрашенную в зеленый цвет, в соответствии с
введенными данными, история введенных данных при этом должна сохраняться.
• При нажатии на кнопку «Back» возвращаемся на предыдущий экран,
на котором видим в соответствующих строках измененый фон кнопок. По клику на
эту строку на следующем экране видим также все изменения.
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<List> list = new ArrayList<List>();
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем адаптер
        fillData();
        listViewAdapter = new ListViewAdapter(this, list);

        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(listViewAdapter);

    }

    private void fillData() {
        for (int i = 1; i <= 100; i++) {
            list.add(new List(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
