package com.example.administrator.read.search;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class search extends AppCompatActivity {
    SearchView searchView;
    Button button;
    ListView listView;
    Handler handler;
    ArrayList<String> author=new ArrayList<String>();
    ArrayList<String> bookname=new ArrayList<String>();
    ArrayList<String> describtion=new ArrayList<String>();
    ArrayList<String> img=new ArrayList<String>();
    ArrayList<Integer> book_id=new ArrayList<Integer>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        handler=new Handler();
//        setContentView(R.layout.activity_search);
//        searchView=(SearchView) findViewById(R.id.searchview);
//        button=(Button) findViewById(R.id.clear);
//        listView=(ListView) findViewById(R.id.history);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(final String query) {
//                button.setVisibility(View.GONE);
//                new Thread(){
//                    @Override
//                    public void run() {
//                        author.clear();
//                        bookname.clear();
//                        book_id.clear();
//                        img.clear();
//                        describtion.clear();
//
//                        System.out.println(result);
//                        try {
//                            JSONObject result_json = null;
//                            result_json = new JSONObject(result);
//                            JSONArray list=result_json.getJSONArray("NAME");
//                            for (int i = 0; i < list.length(); i++) {
//                                JSONObject object=list.getJSONObject(i);
//                                author.add(object.getString("a"));
//                                bookname.add(object.getString("b"));
//                                describtion.add(object.getString("c"));
//                                img.add(object.getString("url"));
//                                book_id.add(object.getInt("id"));
//                            }
//                            handler.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if(book_id.size()==0){
//                                        listView.setAdapter(new search.myadapter());
//                                        Toast.makeText(search.this,"未找到相应结果",Toast.LENGTH_SHORT).show();
//                                    }
//                                    else {
//                                        listView.setAdapter(new search.myadapter());
//                                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                            @Override
//                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                                Intent intent1=new Intent(search.this, Message.class);
//                                                intent1.putExtra("book_id",book_id.get(position));
//                                                intent1.putExtra("flag",1);
//                                                startActivity(intent1);
//                                            }
//                                        });
//                                    }
//                                }
//                            });
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                }.start();
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//    }
//    private class myadapter extends BaseAdapter {
//        @Override
//        public int getCount() {
//            return book_id.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view=View.inflate(search.this,R.layout.ab_department,null);
//            TextView book=(TextView) view.findViewById(R.id.BookName);
//            url_imgview imgview=(url_imgview) view.findViewById(R.id.imageView);
//            TextView authorname=(TextView) view.findViewById(R.id.authorName);
//            TextView innertext=(TextView) view.findViewById(R.id.innertext);
//            book.setText(bookname.get(position));
//            authorname.setText(author.get(position));
//            innertext.setText(describtion.get(position));
//            imgview.geturlimg(img.get(position));
//            return view;
//        }
    }
}
