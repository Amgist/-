package com.example.administrator.read.Y_Data;

import org.json.JSONException;
import org.json.JSONObject;

public class JSData {
    String id;
    String name;
    String add;
    String web;
    String time;
    String sp;
    String introduce;
    String url1;
    String url2;
    String url3;
    public void setid(String id)
    {
        this.id=id;
    }
    public String getid()
    {
        return id;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    public String getname()
    {
        return name;
    }
    public void setadd(String add)
    {
        this.add=add;
    }
    public String getadd()
    {
        return add;
    }
    public void setweb(String web)
    {
        this.web=web;
    }
    public String getweb()
    {
        return web;
    }
    public void settime(String time)
    {
        this.time=time;
    }
    public String gettime()
    {
        return time;
    }
    public void setsp(String sp)
    {
        this.sp=sp;
    }

    public String getsp()
    {
        return sp;
    }
    public void setintroduce(String introduce)
    {
        this.introduce=introduce;
    }
    public String getintroduce()
    {
        return introduce;
    }
    public void seturl1(String url1)
    {
        this.url1=url1;
    }
    public String geturl1()
    {
        return url1;
    }
    public void setUrl2(String url2)
    {
        this.url2=url2;
    }
    public String geturl2()
    {
        return url2;
    }
    public void seturl3(String url3)
    {
        this.url3=url3;
    }
    public String geturl3()
    {
        return url3;
    }
    public JSData(String id, String name, String add, String web, String time, String sp, String introduce, String url1, String url2, String url3)
    {
        this.id=id;
        this.name=name;
        this.add=add;
        this.web=web;
        this.time=time;
        this.sp=sp;
        this.introduce=introduce;
        this.url1=url1;
        this.url2=url2;
        this.url3=url3;
    }
    public static JSData sectionData(JSONObject json){
        try {
            return new JSData(json.getString("id")
                    , json.getString("name")
                    , json.getString("add")
                    , json.getString("web")
                    , json.getString("time")
                    , json.getString("sp")
                    , json.getString("introduce")
                    , json.getString("url1")
                    , json.getString("url2")
                    , json.getString("url3"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
