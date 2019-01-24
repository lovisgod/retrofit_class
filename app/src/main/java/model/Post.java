package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("UserId")
    @Expose
    private int UserId;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public Integer getUserId(){
        return UserId;
    }

    public void setUserId(int UserId){
        this.UserId= UserId;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }


    @Override
    public String toString() {
        return title + body + "\n" + UserId + "\n" +  id ;
    }
}


